package org.project.study.jdbc.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.project.study.jdbc.ConnectionUtils;

public class ScrollableResultSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection connection = ConnectionUtils.getConnection();
		
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		String sqlQuery = "SELECT email, password FROM user";
		
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		
		boolean last = resultSet.last();
		
		
		System.out.println(last);
		
		if(last) {
			System.out.println("User id: " + resultSet.getString("email"));
			System.out.println("User email: " + resultSet.getString("password"));
		}
		
		System.out.println("-----");
		
		boolean previous = resultSet.previous();
		
		System.out.println("Previous 1:" + previous);

		previous = resultSet.previous();
		
		System.out.println("Previous 2:" + previous);
		
		while (resultSet.next()) {
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			
			System.out.println("-----");
			System.out.println("User id: " + email);
			System.out.println("User email: " + password);
		}
		
		connection.close();

	}

}
