package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.Notice;



public class AddNotice {
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public AddNotice() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public int addNotice(Notice notice) {
	    int noticeId = -1;

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(AdminQueries.INSERT_NOTICE, Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, notice.getTitle());
	            ps.setString(2, notice.getMessage());
	            ps.setString(3, notice.getType());


	            if (ps.executeUpdate() > 0) {
	                try (ResultSet rs = ps.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        noticeId = rs.getInt(1);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return noticeId;
	}
	
	public boolean addUserAssociation(int userId, int noticeId) {
		System.out.println("kinaa");
	    boolean isInserted = false;

	    if (conn != null) {
	        try {
	            PreparedStatement ps = conn.prepareStatement(AdminQueries.ADD_APPLICATION_USER_ROOM_WITH_NOTICE_ID);
	            ps.setInt(1, userId);
	            ps.setInt(2, noticeId);

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
