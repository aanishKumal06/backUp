package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class RoomStatusCountDAO {

	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public RoomStatusCountDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	public HashMap<String, Integer> getRoomStatusCounts() {
	    HashMap<String, Integer> statusCounts = new HashMap<>();


	    try {
	        // Get grouped status counts
	        ps = conn.prepareStatement(AdminQueries.GET_ROOM_STATUS_COUNTS);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            statusCounts.put(rs.getString("room_status"), rs.getInt("count"));
	        }

	        // Get total room count
	        ps = conn.prepareStatement(AdminQueries.GET_TOTAL_ROOM_COUNT);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            statusCounts.put("Total", rs.getInt("total_rooms"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return statusCounts;
	}


}
