import java.sql.*;
import javax.sql.*;


public class SQLConnection {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://69.133.23.107:3306/applist"; //databaseName=applist;user=Test201User;password=user201";
		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		 try{
	         // this will load the MySQL driver, each DB has its own driver
	       Class.forName("com.mysql.jdbc.Driver");
	       // setup the connection with the DB.
	       connect = DriverManager.getConnection(url,"Test201User", "user201");

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
