package org.project.study.jdbc.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.project.study.jdbc.ConnectionUtils;

public class TransactionExample {

	private static void doJob1(Connection conn) {
		
	}
	
	private static void doJob2(Connection conn) {
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectionUtils.getConnection();
		
		connection.setAutoCommit(false);
		
		try {
			doJob1(connection);
			
			doJob2(connection);
			
			connection.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
		}
		
		connection.close();
		
	}

}
