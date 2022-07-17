package quiz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class GetScore {
	public void getScore() throws SQLException  {
		
	try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your Id to get Your Information:");
			int k=Integer.parseInt(sc.nextLine());//By using this method we convert string to Integer
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_app?autoReconnect=true&useSSL=false","root","bhavesh08");
		    String sql=("select * from student_details where S_id="+k);
		    Statement s=con.createStatement();//to execute single query with database
			ResultSet rs2=s.executeQuery(sql);//to retrive or select data from database
			while(rs2.next()) {
				int id=rs2.getInt("S_id");
				String Fname=rs2.getString("f_name");
				String Lname=rs2.getString("l_name");
				int Score=rs2.getInt("score");
				System.out.println("Student_id="+id);
				System.out.println("Name="+Fname+" "+Lname);
				System.out.println("Score="+Score);
				
			}
			s.close();
		}
			catch(Exception e) {
		
			e.printStackTrace();
		
			}
	}

}
