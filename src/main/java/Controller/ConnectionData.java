package Controller;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionData
{
	public static Connection getConnection()
	{
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MVC","root","root");
		}
	catch(Exception e) {
		System.out.println(e);
	}
	return con;
	}

}
