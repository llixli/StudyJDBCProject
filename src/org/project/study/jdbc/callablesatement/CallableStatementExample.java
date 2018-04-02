package org.project.study.jdbc.callablesatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.project.study.jdbc.ConnectionUtils;

public class CallableStatementExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection connection =ConnectionUtils.getConnection();
		
		String sqlQuery = "{call get_user_info(?, ?, ?, ?)}";
		
		CallableStatement csmt = connection.prepareCall(sqlQuery);
		
		csmt.setInt(1, 2);
		csmt.registerOutParameter(2, java.sql.Types.VARCHAR);
		csmt.registerOutParameter(3, java.sql.Types.VARCHAR);
		csmt.registerOutParameter(4, java.sql.Types.VARCHAR);
		
		csmt.executeUpdate();
		
		String email = csmt.getString(2);
		String password = csmt.getString(3);
		String username = csmt.getString(4);
		
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		System.out.println("Username: " + username);
	}

}
