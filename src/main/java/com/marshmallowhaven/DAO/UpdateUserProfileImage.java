package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class UpdateUserProfileImage {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UpdateUserProfileImage() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	
	public boolean updateImage(String imageUrl, int userId) {
	    boolean isUpdated = false;

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(UserQueries.UPDATE_USER_PROFILE_IMAGE);
	            ps.setString(1, imageUrl);
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
