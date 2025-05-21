package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.Application;

import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.Model.UserQueries;

public class AddApplicationDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public AddApplicationDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	 
	 // Method to check if a room number exists
    
	
	public int addApplication(Application application) {
		int applicationId = -1;

	    if (conn != null) {
	        try {
	        	
	        	 ps = conn.prepareStatement(UserQueries.APPLY_APPLICATION,Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, application.getDurationOfStay());
	            ps.setDate(2, application.getExpectedCheckIn()); // java.sql.Date

	            ps.setString(3, application.getSpecialRequests());;

	            ps.setString(4, application.getPhotoUrl());


	            if (ps.executeUpdate() > 0) {
	                try (ResultSet rs = ps.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        applicationId = rs.getInt(1);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            // Replace with a logger in production
	            e.printStackTrace();
	        }
	    }

	    return applicationId;
	}
	
	 
	

	public int addEmergencyContact(String name, String relationship, String phoneNumber, String email) {
		int emergencyContactId = -1 ;

	    if (conn != null) {
	        try {
	        	PreparedStatement ps = conn.prepareStatement(UserQueries.ADD_EMERGENCY_CONTACT,Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, name);
	            ps.setString(2, relationship);
	            ps.setString(3, phoneNumber);
	            ps.setString(4, email);

	            if (ps.executeUpdate() > 0) {
	            	 try (ResultSet rs = ps.getGeneratedKeys()) {
		                    if (rs.next()) {
		                    	emergencyContactId = rs.getInt(1);
		                    }
		                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with logger in production
	        }
	    }

	    return emergencyContactId;
	}
	
	public boolean updateUserByUsername(User user) {
	    boolean isUpdated = false;

	    if (conn != null) {
	        try {
	        	ps = conn.prepareStatement(UserQueries.UPDATE_USER_BY_USERNAME);
	            ps.setString(1, user.getFullName());
	            ps.setDate(2, user.getDateOfBirth()); // Ensure this is java.sql.Date
	            ps.setString(3, user.getContactNumber());
	            ps.setString(4, user.getAddress());
	            ps.setString(5, user.getProfileImageUrl());
	            ps.setInt(6, user.getUserId()); // WHERE clause value

	            if (ps.executeUpdate() > 0) {
	                isUpdated = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Use a logger in production
	        }
	    }

	    return isUpdated;
	}


	public boolean updateRoomStatusById(int roomId, int currentOccupancy, boolean isAvailable, String roomStatus) {
	    boolean isUpdated = false;

	    if (conn != null) {
	        try {
	        	PreparedStatement ps = conn.prepareStatement(UserQueries.UPDATE_ROOM_STATUS_BY_ID);
	            ps.setInt(1, currentOccupancy);
	            ps.setBoolean(2, isAvailable);
	            ps.setString(3, roomStatus);
	            ps.setInt(4, roomId);

	            if (ps.executeUpdate() > 0) {
	                isUpdated = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with logger
	        }
	    }

	    return isUpdated;
	}

	public boolean addApplicationUserRoom(int applicationId, int userId, int roomId) {
	    boolean isInserted = false;

	    if (conn != null) {
	        try {
	        	PreparedStatement ps = conn.prepareStatement(UserQueries.ADD_APPLICATION_USER_ROOM_WITH_ID);
	            ps.setInt(1, applicationId);
	            ps.setInt(2, userId);
	            ps.setInt(3, roomId);

	            if (ps.executeUpdate() > 0) {
	                isInserted = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with logger
	        }
	    }

	    return isInserted;
	}


	public Room getRoomStatusById(int roomId) throws SQLException {
		Room status = null;
	    try {
	         PreparedStatement ps = conn.prepareStatement(UserQueries.GET_ROOM_STATUS_BY_ID);
	        
	        ps.setInt(1, roomId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int occupancy = rs.getInt("current_occupancy");
	            boolean isAvailable = rs.getBoolean("is_available");
	            String roomStatus = rs.getString("room_status");
	            String roomType = rs.getString("room_Type");


	            status = new Room(occupancy, isAvailable, roomStatus, roomType); // assuming such a class exists
	        }
	    }catch (SQLException e) {
            e.printStackTrace(); // Replace with logger
        }
	    return status;
	}
	
	
	public boolean addUserAssociation(int userId, int emergencyId) {
		System.out.println("kinaa");
	    boolean isInserted = false;

	    if (conn != null) {
	        try {
	            PreparedStatement ps = conn.prepareStatement(UserQueries.ADD_USER_ASSOCIATION_WITH_IDS);
	            ps.setInt(1, userId);
	            ps.setInt(2, emergencyId);

	            if (ps.executeUpdate() > 0) {
	                isInserted = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Replace with proper logging in production
	        }
	    }
	    System.out.println(isInserted);
	    return isInserted;
	}

	



}
