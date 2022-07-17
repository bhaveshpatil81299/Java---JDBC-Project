package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentInputAndQuestions {

	public void displayQuestions() throws SQLException {

		// scanner class to take student input
		Scanner scan1 = new Scanner(System.in);

		// Taking student details from the student who is taking the quiz
		System.out.println("We need some details from you for our records.");
		System.out.println("Please enter the following required details.");

		System.out.print("First Name:");
		String fName = scan1.next();// taking first name as input

		System.out.print("Last Name:");
		String lName = scan1.next();// taking last name as input

		System.out.println("Thanks for the information.");
		
		// Getting the Id for the new Student
		GetId gen = new GetId();
		gen.getId();

		// initialize the score variable to count the score of the user
		int score = 0;

		System.out.println("To start the quiz type 'S' and press enter:-");
		char st = scan1.next().charAt(0);

		if (st == 'S' || st == 's') {

			try {

				// loading driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				// establishing the connection between database and program
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/quiz_app?autoReconnect=true&useSSL=false", "root", "bhavesh08");

				// we are having 10 questions, so we are storing 1 to 10 integers in arraylist.
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 1; i <= 10; i++) {
					list.add(new Integer(i));
				}

				// this will give us 1 to 10 integers in random order
				Collections.shuffle(list);

				// here we are taking the random numbers from above code to display questions in
				// random order
				for (int j = 0; j < 10; j++) {

					// creating preparedstatement to select particular column from database
					PreparedStatement ps = con
							.prepareStatement("select * from quiz_app.questions where Q_num=" + list.get(j));
					// result set to execute prepared statement query
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						// scanner class to take input from user
						Scanner scan2 = new Scanner(System.in);

						System.out.print("\nQ" + (j + 1)); // this will display question number
						System.out.println(" " + rs.getString(2)); // this will display the question
						System.out.println("A." + rs.getString(3));// this will display option A
						System.out.println("B." + rs.getString(4));// this will display option B
						System.out.println("C." + rs.getString(5));// this will display option C
						System.out.println("D." + rs.getString(6));// this will display option D

						System.out.print("Enter the answer: "); // here user will enter the option for the correct
																// answer according to user
						String answer = scan2.next();

						if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("c")
								|| answer.equalsIgnoreCase("d")) {

							// here if user entered answer is same as in our database then we will increase
							// score by 1
							if (answer.equalsIgnoreCase(rs.getString(7))) {
								score++;
							}

						} else {
							System.out.println("Invalid output.");
						}

					}

					ps.close();
					rs.close();

				}

				// here we are displaying the score of user and his/her grade i.e. pass or fail
				System.out.println("Total marks out of 10=" + score);
				if (score <= 10 && score >= 8) { // with the help of score we divide result
					System.out.println("Excellent performance");
					System.out.println("Pass By Class A");
				} else if (score < 8 && score >= 6) {
					System.out.println("Good performance");
					System.out.println("Pass By Class B");
				} else if (score == 5) {
					System.out.println("Congratulation");
					System.out.println("Pass By Class C");
				} else if (score < 5) {
					System.out.println("Fail");
				}

				System.out.println("\t\t\t\t\t*Finish*");
				System.out.println("\t\t\t\t\t*Thank you!*");
				System.out.println(
						"\n***************************************************************************************************************\n");

				// this prepared statement is used to store the score in database
				PreparedStatement ps2 = con
						.prepareStatement("insert into quiz_app.student_details (f_name,l_name,score) values(?,?,?)");
				ps2.setString(1, fName);
				ps2.setString(2, lName);
				ps2.setInt(3, score);

				int i = ps2.executeUpdate();

				ps2.close();
				con.close();

			}

			catch (Exception e) {

				e.printStackTrace();

			}

		} else {
			System.out.println("Invalid input!");
		}

	}

}
