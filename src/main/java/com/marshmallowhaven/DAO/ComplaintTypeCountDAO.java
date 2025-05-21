package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class ComplaintTypeCountDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public ComplaintTypeCountDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	public HashMap<String, Integer> getComplaintStatusCounts() {
	    HashMap<String, Integer> complaintStatusCounts = new HashMap<>();


	    try {
	        // Get grouped status counts
	        ps = conn.prepareStatement(AdminQueries.GET_COMPLAINTS_TYPES_COUNTS);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	complaintStatusCounts.put(rs.getString("complaint_type"), rs.getInt("count"));
	        }

	        // Get total room count
	        ps = conn.prepareStatement(AdminQueries.GET_COMPLAINTS_COUNT);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	        	complaintStatusCounts.put("Total", rs.getInt("total_complaints"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return complaintStatusCounts;
	}
}
