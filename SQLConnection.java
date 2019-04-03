import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnection {

	public static void main(String[] args) {
		 String url = "jdbc:sqlserver://69.133.23.107:3306;databaseName=applist;user=Test201User;password=user201";
		 try {
			Connection sqlConnection = DriverManager.getConnection(url);
			Statement statement = sqlConnection.createStatement();
			String query = "SELECT name;";
			ResultSet results = statement.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
