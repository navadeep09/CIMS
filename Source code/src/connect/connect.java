package connect;

import java.sql.*;
public class connect {
	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/carinsurence";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Done");
		} catch (Exception e) {
			System.out.println("Connection Not Createted : " + e);
		}
		return connection;
	}

}
