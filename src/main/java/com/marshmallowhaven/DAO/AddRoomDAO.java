package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.Room;


public class AddRoomDAO {
	

	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public AddRoomDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public boolean addRoom (Room room) {
		boolean isAddedRoom = false;
		
		if (conn != null) {

			try {
				ps = conn.prepareStatement(AdminQueries.ADD_ROOM);
				ps.setString(1, room.getRoomNumber());
				ps.setString(2, room.getRoomType());
				ps.setString(3, room.getFloor());
				ps.setInt(4, room.getMonthlyFee());
				ps.setString(5, room.getRoomStatus());
				ps.setString(6, room.getRoomDescription());
				ps.setString(7, room.getRoomFacilities());
				ps.setString(8, room.getImageUrl());
				ps.setInt(9, room.getCapacity());
				ps.setBoolean(10, room.getIsAvailable());
	
			
			    
				if (ps.executeUpdate() > 0) {
					isAddedRoom = true;
					
				}
				
			} catch (SQLException e) {
				// TODO Good for debugging; can be replaced with proper logging
				e.printStackTrace();
			}
		}
		return isAddedRoom;

	}

}
