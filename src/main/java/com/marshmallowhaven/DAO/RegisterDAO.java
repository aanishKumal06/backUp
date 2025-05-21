package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.Model.UserQueries;



public class RegisterDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public RegisterDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	// Registers a new user in the database
	public boolean registerClient (User user) {
		boolean isUserRegistered = false;
		
		if (conn != null) {

			try {
				ps = conn.prepareStatement(UserQueries.REGISTER_CLIENT);
				ps.setString(1, user.getFullName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getUsername());
				ps.setString(4, user.getPassword()); // TODO Passwords should be hashed in real-world apps
				ps.setString(5, user.getGender());


				if (ps.executeUpdate() > 0) {
					isUserRegistered = true;
				}
				
			} catch (SQLException e) {
				// TODO Good for debugging; can be replaced with proper logging
				e.printStackTrace();
			}
		}
		return isUserRegistered;

	}

}
