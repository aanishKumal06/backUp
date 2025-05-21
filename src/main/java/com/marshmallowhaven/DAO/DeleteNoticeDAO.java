package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class DeleteNoticeDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public DeleteNoticeDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public boolean deleteNoticeAndAssociationsByNoticeId(int noticeId) {
	    boolean success = false;

	    if (conn != null) {
	        try {
	            // Step 1: Delete from user_associations
	            ps = conn.prepareStatement(AdminQueries.DELETE_FROM_USER_ASSOCIATIONS);
	            ps.setInt(1, noticeId);
	            ps.executeUpdate();
	            ps.close();

	            // Step 2: Delete from notice
	            ps = conn.prepareStatement(AdminQueries.DELETE_FROM_NOTICE);
	            ps.setInt(1, noticeId);
	            int rowsAffected = ps.executeUpdate();
	            ps.close();

	            success = rowsAffected > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return success;
	}


}
