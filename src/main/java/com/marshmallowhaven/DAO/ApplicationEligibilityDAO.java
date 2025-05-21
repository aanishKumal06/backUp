package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class ApplicationEligibilityDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public ApplicationEligibilityDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public ArrayList<String> getApplicationStatusesByUserId(int userId) {
		System.out.println("yessssssssssss");
		ArrayList<String> statuses = new ArrayList<>();

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(UserQueries.GET_APPLICATION_STATUSES_BY_USER_ID);
	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                statuses.add(rs.getString("status"));
	            }

	            rs.close();
	            ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with proper logging
	        }
	    }

	    return statuses;
	}

}
