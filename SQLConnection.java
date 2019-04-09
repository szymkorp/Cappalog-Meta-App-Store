import java.sql.*;
import javax.sql.*;

/*
 * This needs to be run in eclipse with the mysql-connector jar file
 */

 public class SQLConnection {

 	public static void main(String[] args) throws ClassNotFoundException {
 		String url = "jdbc:mysql://localhost:3306/cappalogdb"; //databaseName=applist;user=Test201User;password=user201";
 		Connection connect = null;
 		 try{
 	       Class.forName("com.mysql.jdbc.Driver");
 	       connect = DriverManager.getConnection(url,"Test201User", "user201");
 	       Statement stmt = connect.createStatement();
 	       String sql = "Select * From apptable;";
 	       ResultSet rs = stmt.executeQuery(sql);
 	       if (rs.next()) {
 	    	   System.out.println("Congrats it works");
 	       }
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		finally {
 			if (connect != null) {
 				try	{
 					connect.close ();
 					System.out.println ("Database connection terminated");
 				}
 				catch (Exception e) { /* ignore close errors */ }
 			}
 		}
 	}



 }
