package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.UserQueries;

public class AddComplaintDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public AddComplaintDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	public int addComplaint(String complaint_type, String description ) {
		int complaintId = -1 ;

	    if (conn != null) {
	        try {
	        	PreparedStatement ps = conn.prepareStatement(UserQueries.ADD_COMPLIANT,Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, complaint_type);
	            ps.setString(2, description);


	            if (ps.executeUpdate() > 0) {
	            	 try (ResultSet rs = ps.getGeneratedKeys()) {
		                    if (rs.next()) {
		                    	complaintId = rs.getInt(1);
		                    }
		                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with logger in production
	        }
	    }

	    return complaintId;
	}

	
	public boolean addComplaintId(int user_id, int  complaint_id ) {

		 boolean isInserted = false;

	    if (conn != null) {
	        try {
	        	PreparedStatement ps = conn.prepareStatement(UserQueries.ADD_COMPLIANT_ID);
	            ps.setInt(1, user_id);
	            ps.setInt(2, complaint_id);
	            
	            if (ps.executeUpdate() > 0) {
	                isInserted = true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with logger in production
	        }
	    }

	    return isInserted;
	}
}
