package org.project.study.jdbc.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.project.study.jdbc.ConnectionUtils;


public class BatchExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectionUtils.getConnection();
		
		try {
			Statement stmt = connection.createStatement();
			
			connection.setAutoCommit(false);
			
			String sql1 = "UPDATE user AS u set u.email = '2vasya2@gg.org' WHERE u.id = 1";
			
			stmt.addBatch(sql1);
			
			String sql2 = "UPDATE user AS u set u.email = '3va2@gg.owrg' WHERE u.id = 2";
			
			stmt.addBatch(sql2);

			String sql3 = "UPDATE user AS u set u.email = '2va3@gg.owrg' WHERE u.id = 3";

			stmt.addBatch(sql3);
			
			int[] counts = stmt.executeBatch();
			
			System.out.println("SQL1 count: " + counts[0]);
			System.out.println("SQL2 count: " + counts[1]);
			System.out.println("SQL3 count: " + counts[2]);
			
			connection.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			
			connection.rollback();
		}
	}

}
