package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class UpdateUserPasswordDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UpdateUserPasswordDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	
	public boolean updatePassword(String password, int userId) {
	    boolean isUpdated = false;

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(UserQueries.UPDATE_USER_PASSWORD);
	            ps.setString(1, password);
	            ps.setInt(2, userId);

	            if (ps.executeUpdate() > 0) {
	                isUpdated = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isUpdated;
	}
	
	


}
