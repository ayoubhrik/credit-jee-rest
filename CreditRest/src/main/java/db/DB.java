package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private static Connection c;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/credit", "root" , "");
		} catch (ClassNotFoundException e) {
			System.err.println("DB problem!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL statement error!");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return c;
	}
	

}
