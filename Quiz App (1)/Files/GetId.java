package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetId {
	
	public void getId() throws SQLException{
	     
        try {
        	
        	//loading driver
            Class.forName("com.mysql.cj.jdbc.Driver");
          //establishing the connection between database and program
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_app?autoReconnect=true&useSSL=false","root", "bhavesh08");
            
            Statement stmt = con.createStatement();
            String query = "select count(*) from student_details";
            //Executing the query
            ResultSet rs = stmt.executeQuery(query);
            //Retrieving the result
            rs.next();
            int id = rs.getInt(1);
            System.out.println("\n*****************");
            System.out.println("* Your Id is: "+(id+1)+" *");
            System.out.println("*****************\n");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
}
