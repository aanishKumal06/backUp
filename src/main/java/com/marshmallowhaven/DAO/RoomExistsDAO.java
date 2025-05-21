package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.CommonQueries;


public class RoomExistsDAO {
	
	   private Connection conn;
	   private PreparedStatement ps;

	    // Constructor: Establishes DB connection
	    public RoomExistsDAO() throws ClassNotFoundException, SQLException {
	        this.conn = DatabaseConnection.getConnection(); // Assumes you have this class
	    }

	    // Method to check if a room number exists
	    public boolean roomNumberExists(String roomNumberToCheck) {

	    	boolean exists = false;
	    
	    	if (conn != null) {
        	
        	try {
				ps = conn.prepareStatement(CommonQueries.CHECK_ROOM_NUMBER);
				ps.setString(1, roomNumberToCheck);
		
				ResultSet rs  = ps.executeQuery();
				
				if (rs.next()) {
					exists = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    return exists;

	    	}
}
