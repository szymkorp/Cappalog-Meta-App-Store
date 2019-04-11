import java.sql.*;
import java.util.ArrayList;


public class SQLConnection {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/cappalogdb"; //databaseName=applist;user=Test201User;password=user201";
		Connection connect = null;
		ArrayList<APP> appList = new ArrayList<APP>();
		 try{
	       Class.forName("com.mysql.jdbc.Driver");
	       connect = DriverManager.getConnection(url,"romerta", "romert2GE");
	       Statement stmt = connect.createStatement();
	       String sql = "Select * From apptable;";
	       ResultSet rs = stmt.executeQuery(sql);
	       while (rs.next()) {
	    	   int id = rs.getInt("appID");
	    	   String name = rs.getString("Name");
	    	   String dev = rs.getString("Developer");
	    	   String link = rs.getString("Link");
	    	   String desc = rs.getString("Description");
	    	   String plat = rs.getString("Platform");
	    	   double price = rs.getDouble("Price");
	    	   APP app = new APP(id, name, dev, link, plat, plat, price);
	    	   appList.add(app);
	       }
	       System.out.println(rs);

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
