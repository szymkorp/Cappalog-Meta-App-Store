import java.sql.*;
import java.util.ArrayList;


public class SQLConnection {

	private static Connection connect;
	
	public SQLConnection() {
		String url = "jdbc:mysql://localhost:3306/cappalogdb"; //databaseName=applist;user=Test201User;password=user201";
		 try{
	       Class.forName("com.mysql.jdbc.Driver");
	       connect = DriverManager.getConnection(url,"romerta", "romert2GE");
		} catch (SQLException e) {
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

	public static ArrayList<APP> getApps() {
		ArrayList<APP> appList = new ArrayList<APP>();

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
        return appList;
	}
	
	public static ArrayList<APP> getSubmittedApps() {
	ArrayList<APP> submittedList = new ArrayList<APP>();

	Statement stmt = connect.createStatement();
       	String sql = "Select * From submittedApps;";
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
    	   submittedList.add(app);
        }
        return submittedList;
	}
	
	public static boolean loginCheck(String username, String password) {
		Statement log = connect.createStatement();
	    String check = "Select * From apptable WHERE userName = '" + username + "' AND userPassword = '" + password + "';";
	    ResultSet rs = log.executeQuery(check);
	    return rs.next(); // returns true if user exists, false if user does not exist (rs is empty)
	}

	public static void submitApp(int id, String name, String developer, String link, String description, String platform, double price) {
		Statement st = connect.createStatement();
		String insert = "INSERT INTO submittedApps (id, Name, Developer, Link, Description, Platform, Price, IsAdded)" 
				+ " VALUES (" + id + ", '" + name + "', '" + developer + "', '" + "', '" + link + "', '" + description
				+ "', '" + platform + "', " + price + ", 'N');";
	    	st.executeUpdate(insert);
	}
	
	public static boolean approveApp(int id) {
		Statement st1 = connect.createStatement();
		String submittedCheck = "Select * from submittedApps WHERE appID=" + id + ";";
		ResultSet rs = st.executeQuery(submittedCheck);
		if (!rs.next()) {
			return false;
		}
		int id = rs.getInt("appID");
    	   	String name = rs.getString("Name");
    	   	String dev = rs.getString("Developer");
    	   	String link = rs.getString("Link");
    	   	String desc = rs.getString("Description");
    	   	String plat = rs.getString("Platform");
    	   	double price = rs.getDouble("Price");
		Statement st2 = connect.createStatement();
		String add = "INSERT INTO appTable (id, Name, Developer, Link, Description, Platform, Price)" 
				+ " VALUES (" + id + ", '" + name + "', '" + developer + "', '" + "', '" + link + "', '" + description
				+ "', '" + platform + "', " + price + ");";
		st2.executeUpdate(add);
		Statement st3 = connect.createStatement();
		String update = "UPDATE submittedApps SET isAdded = 'Y' WHERE appID = " + id + ";";
		st3.executeUpdate(update);
		return true;
	}

	

}
