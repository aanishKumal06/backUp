package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.CommonQueries;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.UserQueries;

public class ExpensiveRoomDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public ExpensiveRoomDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	public ArrayList<Room> ExpensiveRoom() {
		ArrayList<Room> expensiveRooms = new ArrayList<>();
	
		if (conn != null) {

			  try {
				ps = conn.prepareStatement(UserQueries.TOP_THREE_EXPENSIVE_VACANT_ROOMS);
				 ResultSet rs = ps.executeQuery();
		         while (rs.next()) {
		        	    Room room = new Room(
		        	        rs.getInt("room_id"),
		        	        rs.getString("room_number"),
		        	        rs.getString("room_type"),
		        	        rs.getString("room_description"),
		        	        rs.getString("room_facilities"),
		        	        rs.getInt("capacity"),
		        	        rs.getInt("current_occupancy"),
		        	        rs.getInt("monthly_fee"),
		        	        rs.getBoolean("is_available"),
		        	        rs.getString("image_url"),
		        	        rs.getTimestamp("created_at"),
		        	        rs.getTimestamp("updated_at"),
		        	        rs.getString("floor"),
		        	        rs.getString("room_status")
		        	    );
		        	    expensiveRooms.add(room);
		        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	
	}
		return expensiveRooms;

	}
}
