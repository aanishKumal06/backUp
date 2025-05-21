package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class AddWhislistDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public AddWhislistDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public boolean addWishlistEntry(int userId, int roomId) {
	    
		 boolean isInserted = false;

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(UserQueries.INSERT_INTO_WISHLIST);
	            ps.setInt(1, userId);
	            ps.setInt(2, roomId);

	            if (ps.executeUpdate() > 0) {
	            	isInserted = true ;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isInserted;
	}
	
	


}
