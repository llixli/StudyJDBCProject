package org.project.study.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.project.study.jdbc.ConnectionUtils;

public class BatchExample2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtils.getConnection();

		try {
			String sqlQuery = "INSERT INTO information(title, description, rememberingType) VALUES(?, ?, ?)";
			
			PreparedStatement pstm = connection.prepareStatement(sqlQuery);
			
			connection.setAutoCommit(false);
			
			pstm.setString(1, "nok");
			pstm.setString(2, "ia");
			pstm.setString(3, "long-term");
			
			pstm.addBatch();
			
			
			pstm.setString(1, "kk");
			pstm.setString(2, "no");
			pstm.setString(3, "short-term");
			
			pstm.addBatch();
			
			int[] counts = pstm.executeBatch();
			
			System.out.println("counts[0]: " + counts[0]);
			System.out.println("counts[1]: " + counts[1]);

			connection.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			connection.rollback();
		}
		connection.close();
	}

}
