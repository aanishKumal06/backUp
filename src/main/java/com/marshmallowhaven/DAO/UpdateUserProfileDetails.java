package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class UpdateUserProfileDetails {

	

	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UpdateUserProfileDetails() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	
	public boolean updateUserProfile(String fullName, String username, String gender, String email,
            String contactNumber, String dateOfBirth, String address, int userId) {
		boolean isUpdated = false;
		
		if (conn != null) {
			try {
			ps = conn.prepareStatement(UserQueries.UPDATE_USER_PROFILE);
			ps.setString(1, fullName);
			ps.setString(2, username);
			ps.setString(3, gender);
			ps.setString(4, email);
			ps.setString(5, contactNumber);
			ps.setString(6, dateOfBirth);
			ps.setString(7, address);
			ps.setInt(8, userId);
			
			if (ps.executeUpdate() > 0) {
			isUpdated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		return isUpdated;
	}
	

	public boolean updateUserProfileImage (String profileImageUrl,int userId) {
		boolean isUpdated = false;
		
		if (conn != null) {
			try {
			ps = conn.prepareStatement(UserQueries.UPDATE_USER_PROFILE_IMAGE);
			ps.setString(1, profileImageUrl);
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
	

	public boolean updateUserPassword (String password,  int userId) {
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
