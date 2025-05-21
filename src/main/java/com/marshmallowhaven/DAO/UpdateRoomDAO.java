package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class UpdateRoomDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UpdateRoomDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	
	public boolean updateRoomOccupancyAndStatus(String roomNumber, int occupancy, String status) {
	    boolean isUpdated = false;

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(AdminQueries.UPDATE_ROOM_OCCUPANCY_AND_STATUS);
	            ps.setInt(1, occupancy);
	            ps.setString(2, status);
	            ps.setString(3, roomNumber);

	            if (ps.executeUpdate() > 0) {
	                isUpdated = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isUpdated;
	}

	
	public boolean updateRoomDetails(String roomNumber, String roomType, String floor, int monthlyFee, String roomStatus,
			String facilities, String roomDescription, int roomId) {
		boolean isUpdated = false;
		
		if (conn != null) {
			try {
				ps = conn.prepareStatement(AdminQueries.UPDATE_ROOM_DETAILS);
				ps.setString(1, roomNumber);
				ps.setString(2, roomType);
				ps.setString(3, floor);
				ps.setInt(4, monthlyFee);
				ps.setString(5, roomStatus);
				ps.setString(6, facilities);
				ps.setString(7, roomDescription);
				ps.setInt(8, roomId);
				
				
				if (ps.executeUpdate() > 0) {
					isUpdated = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return isUpdated;
		}
	
	public boolean updateRoomDetailsOfOccuied(String roomNumber,  int monthlyFee,
            String roomFacilities, String roomDescription,  int roomId) {
		boolean isUpdated = false;
		
		if (conn != null) {
			try {
				ps = conn.prepareStatement(AdminQueries.UPDATE_ROOM_DETAILS);
				ps.setString(1, roomNumber);
				ps.setInt(2, monthlyFee);
				ps.setString(3, roomFacilities);
				ps.setString(4, roomDescription);
				ps.setInt(5, roomId);
				
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
