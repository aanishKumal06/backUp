package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.marshmallowhaven.Model.CommonQueries;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.UserQueries;
import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;

public class RoomDetailsDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public RoomDetailsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public ArrayList<Room> getAllRooms() {
		ArrayList<Room> rooms = new ArrayList<>();
	
		if (conn != null) {

			  try {
				ps = conn.prepareStatement(CommonQueries.GET_ROOM_DETAILS);
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
		        	    rooms.add(room);
		        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	
	}
		return rooms;

	}
	
	public ArrayList<Room> getVacantRooms() {
		ArrayList<Room> rooms = new ArrayList<>();
	
		if (conn != null) {

			  try {
				ps = conn.prepareStatement(UserQueries.GET_VACANT_ROOM_DETAILS_ONLY);
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
		        	    rooms.add(room);
		        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	
		}
	  return rooms;

	}
	
	public ArrayList<Room> getRoomsByStatus(String status) {
	    ArrayList<Room> rooms = new ArrayList<>();

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(CommonQueries.GET_ROOM_DETAILS_BY_STATUS);
	            ps.setString(1, status); 
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
	                rooms.add(room);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return rooms;
	}
	
	public ArrayList<Room> getRoomsByTypeAndPriceOrder(String roomType, String priceOrder) {
	    ArrayList<Room> rooms = new ArrayList<>();

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(UserQueries.GET_ROOMS_BY_TYPE_AND_PRICE_ORDER);
	            ps.setString(1, roomType);      // For WHERE room_type = ?
	            ps.setString(2, roomType);      // For OR ? = 'all'
	            ps.setString(3, priceOrder);    // For ORDER BY CASE 'low'
	            ps.setString(4, priceOrder);    // For ORDER BY CASE 'high'

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
	                rooms.add(room);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return rooms;
	}

	
	public ArrayList<Room> getARoomDetailById(int roomID) {
		ArrayList<Room> rooms = new ArrayList<>();
	
		if (conn != null) {

			  try {
				ps = conn.prepareStatement(CommonQueries.GET_ROOM_DETAILS_BY_ID);
				ps.setInt(1, roomID);
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
		        	    rooms.add(room);
		        	}
		         
		         System.out.println("sd");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	
	}
		return rooms;

	}

}