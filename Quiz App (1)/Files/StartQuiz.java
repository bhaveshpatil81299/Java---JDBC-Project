package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StartQuiz {

	public static void main(String[] args) throws SQLException {

		// here we start the execution of the program by welcoming the user
		System.out.println("\t\t\t\t\t\t\tJava Quiz");
		System.out.println("\t\t\t\t\t\t\t*********");

		System.out.println("\t\t\t\t\tWelcome for the Java Quiz Competition");
		System.out.println("\t\t\t\t\t*************************************\n");

		Scanner scan = new Scanner(System.in);

		System.out.print("Please select what you want Quiz or Score or Ranking: ");

		String option = scan.next();
		System.out.println(
				"\n***************************************************************************************************************\n");

		if (option.equalsIgnoreCase("Quiz")) {

			// creating the object for the class to display the rules of quiz
			RulesForQuiz rfq = new RulesForQuiz();
			rfq.displayRules();
			System.out.println(
				"\n***************************************************************************************************************\n");

			// from here the quiz starts. creating the object for the class to take details
			// from user and display the questions of quiz
			StudentInputAndQuestions siq = new StudentInputAndQuestions();
			siq.displayQuestions();

		} else if (option.equalsIgnoreCase("Score")) {

			// creating the object for the class to get the score of a particular student
			GetScore gs = new GetScore();
			gs.getScore();

		} else if (option.equalsIgnoreCase("Ranking")) {

			// creating the object for the class to get the students by their score ranking
			GetRanking gr = new GetRanking();
			gr.getRanking();

		}

	}

}
