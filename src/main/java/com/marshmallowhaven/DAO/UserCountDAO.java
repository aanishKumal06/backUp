package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class UserCountDAO {
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UserCountDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	  public int getTotalUserCount() throws SQLException {
	        int totalUsers = 0;
	        String query = AdminQueries.GET_USERS_COUNT;
	        
	        try (PreparedStatement ps = conn.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {
	            
	            if (rs.next()) {
	                totalUsers = rs.getInt("total_users");
	            }
	        }

	        return totalUsers;
	    }

}
