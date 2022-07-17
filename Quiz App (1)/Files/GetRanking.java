package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetRanking {
	
	public void getRanking() throws SQLException {
	     try {
	    	//establishing the connection between database and program
	    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_app?autoReconnect=true&useSSL=false","root","bhavesh08");
			//to get information of user in descending order
	    	 PreparedStatement ps=con.prepareStatement("select * from student_details order by score desc");
			ResultSet rs1=ps.executeQuery();
			int temp=1;
			System.out.println("<Ranking Of Student As per Score>");
			System.out.println("------------------------------------------------------");
		
		while(rs1.next()) {
				System.out.print("\n"+temp+")");
				System.out.println("Id="+rs1.getInt(1));
				System.out.println("Name="+rs1.getString(2)+" "+rs1.getString(3));
				System.out.println("Score="+rs1.getInt(4));
				temp++;
			}
		con.close();
		ps.close();
		}catch(Exception e) {
			e.printStackTrace();
	  }
	}
}
