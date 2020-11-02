package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	/*
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
	}*/
	
	private static Connection c;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			c = DriverManager.getConnection("jdbc:mysql://w1kr9ijlozl9l79i.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/tjjk3gm62ggkhnso", "n2jkd5lzsqduol89" , "bs1tzbxt3i6z9axj");
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
