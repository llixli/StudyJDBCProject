package org.project.study.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		return MySQLConnUtils.getMySQLConnection();
	}
	
	public static void main(String... args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection...");
		Connection connection = ConnectionUtils.getConnection();	
		
		System.out.println("Get connection " + connection);
		System.out.println("Done!");

	}

}
