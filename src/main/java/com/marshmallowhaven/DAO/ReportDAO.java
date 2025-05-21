package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.BookingStat;

public class ReportDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	
	public ReportDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	
	public HashMap<String, Integer> getRoomTypeBookingCounts() {
	    HashMap<String, Integer> roomTypeBookingCounts = new HashMap<>();

	    try (PreparedStatement ps = conn.prepareStatement(AdminQueries.GET_ROOM_TYPE_BOOKING_COUNT);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            String roomType = rs.getString("room_type");
	            int bookingCount = rs.getInt("booking_count");

	            roomTypeBookingCounts.put(roomType, bookingCount);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return roomTypeBookingCounts;
	}


    // Query 2: Get daily bookings by room type
    public ArrayList<BookingStat> getDailyBookingStatsByRoomType() {
        ArrayList<BookingStat> dailyBookingStats = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(AdminQueries.GET_DAILY_BOOKINGS_BY_ROOM_TYPE);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String roomType = rs.getString("room_type");
                Date bookingDate = rs.getDate("booking_date");
                int totalBookings = rs.getInt("total_bookings");

                dailyBookingStats.add(new BookingStat(roomType, bookingDate, totalBookings));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dailyBookingStats;
    }

}
