package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class DeleteWishlistDAO {
	
	 private Connection conn;
	    private PreparedStatement ps;

	    // Constructor: Establishes DB connection
	    public DeleteWishlistDAO() throws ClassNotFoundException, SQLException {
	        this.conn = DatabaseConnection.getConnection(); // Assuming it returns a live connection
	    }
	
	    public boolean deleteWishlistByRoomIdAndUserId(int roomId, int userId) {
	        boolean success = false;

	        if (conn != null) {
	            PreparedStatement ps = null;
	            try {
	                String sql = UserQueries.DELETE_FROM_WISHLIST_BY_ROOM_ID; 
	                ps = conn.prepareStatement(sql);
	                ps.setInt(1, roomId);
	                ps.setInt(2, userId);

	                int rowsAffected = ps.executeUpdate();
	                success = rowsAffected > 0;

	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	                if (ps != null) {
	                    try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
	                }
	            }
	        }

	        return success;
	    }



}
