package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class WishlistEligibilityDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public WishlistEligibilityDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	
	public boolean isInWishlist(int userId, int roomId) {
	    boolean isUpdated = false;  // initialize to false
	    

	    
	    if (conn != null) {
	    	
	    	try {
	    		
	    		ps = conn.prepareStatement(UserQueries.CHECK_WISHLIST);
	    		ps.setInt(1, userId);
	    		ps.setInt(2, roomId);
	    		ResultSet rs = ps.executeQuery();
	    		
	    		if (rs.next()) {
	                int exists = rs.getInt("is_in_wishlist");
	                if (exists == 1) {
	                    isUpdated = true;  
	                }
	            }
	    		
	    	}catch (SQLException e) {
		        e.printStackTrace();
		    }
	  
	    	
	    }
	    
	    
	    return isUpdated;  
	}


}
