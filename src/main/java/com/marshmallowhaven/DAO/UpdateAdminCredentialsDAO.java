package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class UpdateAdminCredentialsDAO {

	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UpdateAdminCredentialsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	
	public boolean updateAdminCredentials(String username, String password, int userId) {
	    boolean isUpdated = false;


	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(AdminQueries.UPDATE_ADMIN_CREDENTAILS);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ps.setInt(3, userId);

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
