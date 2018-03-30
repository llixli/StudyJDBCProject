package org.project.study.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.project.study.jdbc.ConnectionUtils;


public class PreparedStatementExample {
	public static void main(String... args) throws ClassNotFoundException, SQLException{
		Connection connection = ConnectionUtils.getConnection();
				
		String sqlQuery = "SELECT email, username FROM user WHERE fkKnowledge = ? OR fkKnowledge = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 4);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			String email = resultSet.getString("email");
			String username = resultSet.getString("username");

			System.out.println("-----");
			System.out.println("Email: " + email);
			System.out.println("Email: " + username);
		}
		
		System.out.println("Set another params");
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 3);
		
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			String email = resultSet.getString("email");
			String username = resultSet.getString("username");

			System.out.println("-----");
			System.out.println("Email: " + email);
			System.out.println("Email: " + username);
		}
		
		connection.close();
	}
}
