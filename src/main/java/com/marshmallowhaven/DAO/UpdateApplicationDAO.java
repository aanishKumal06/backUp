package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class UpdateApplicationDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UpdateApplicationDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	public boolean updateApplicationCheckOut(int applicationId, java.sql.Date checkOutDate, String status) {
	    boolean isUpdated = false;

	    
	    if (conn != null) {
	        try {
	        	 ps = conn.prepareStatement(AdminQueries.UPDATE_APPLICATION_STATUS_AND_CHECKOUT_DATE_BY_ID);
	            ps.setDate(1, checkOutDate);
	            ps.setString(2, status);
	            ps.setInt(3, applicationId);
	            
	            if (ps.executeUpdate() > 0) {
	                isUpdated = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return isUpdated;
	}
	
	
	public boolean updateApplicationStatus(int applicationId, String status) {
	    boolean isUpdated = false;

	    
	    if (conn != null) {
	        try {
	        	 ps = conn.prepareStatement(AdminQueries.UPDATE_APPLICATION_STATUS_BY_ID);
	            ps.setString(1, status);
	            ps.setInt(2, applicationId);
	            
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
