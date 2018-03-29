package org.project.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "";
		String userName = "root";
		String password = "1234";
		
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		
		Connection connection = DriverManager.getConnection(connectionURL, userName, password);
		
		return connection;
	}
	
	
}
