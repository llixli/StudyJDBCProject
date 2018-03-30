package org.project.study.jdbc.basic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.project.study.jdbc.ConnectionUtils;

public class InsertDataExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection connection = ConnectionUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sqlUpdate = "INSERT INTO user (email, password, username)"
				+ "VALUES('1aa@dd.com', '12d', 'aa') ";
		
		int rowCount = statement.executeUpdate(sqlUpdate);
		
		System.out.println(rowCount);
		
		
	}
}
