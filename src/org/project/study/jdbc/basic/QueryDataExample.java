package org.project.study.jdbc.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.project.study.jdbc.ConnectionUtils;

import com.mysql.cj.api.jdbc.Statement;

public class QueryDataExample  {
	public static void main(String... args) throws ClassNotFoundException, SQLException {
		Connection connection  = ConnectionUtils.getConnection();
		
		Statement statement = (Statement) connection.createStatement();
		
		
		String sqlQuery = "SELECT id, email, password, username FROM user";
		
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");
			String username = resultSet.getString("username");
			
			
			System.out.println("-----");
			System.out.println("User id: " + id);
			System.out.println("User email: " + email);
			System.out.println("User password: " + password);
			System.out.println("User username: " + username);
		}
		
		connection.close();
	}
}
