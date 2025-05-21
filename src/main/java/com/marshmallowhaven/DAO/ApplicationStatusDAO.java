package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.UserQueries;

public class ApplicationStatusDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public ApplicationStatusDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	 public ArrayList<String> getStatusesForUser(int userId) throws SQLException {
		 ArrayList<String> statuses = new ArrayList<>();
	        try {
	        	ps = conn.prepareStatement(UserQueries.GET_APPLICATION_STATUSES_BY_USER_ID);
	        
	            ps.setInt(1, userId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    statuses.add(rs.getString("status"));
	                }
	            }
	        }catch (SQLException e) {
	            e.printStackTrace(); // Replace with logger
	        }

	        return statuses;
	    }

	 
		public HashMap<String, Integer> getApplicationStatusCounts() {
		    HashMap<String, Integer> applicationsStatusCounts = new HashMap<>();


		    try {
		        // Get grouped status counts
		        ps = conn.prepareStatement(AdminQueries.GET_APPLICATIONS_STATUS_COUNTS);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        	applicationsStatusCounts.put(rs.getString("status"), rs.getInt("count"));
		        }

		        // Get total room count
		        ps = conn.prepareStatement(AdminQueries.GET_APPLICATIONS_COUNT);
		        rs = ps.executeQuery();
		        if (rs.next()) {
		        	applicationsStatusCounts.put("Total", rs.getInt("total_applications"));
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		     for (Entry<String, Integer> entry : applicationsStatusCounts.entrySet()) {
		    	    System.out.println("Status: " + entry.getKey() + ", Count: " + entry.getValue());
		    	}
		     
		    return applicationsStatusCounts;
		}


}
