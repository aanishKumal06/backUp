package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.Notice;
import com.marshmallowhaven.Model.CommonQueries;

public class NoticeDetailsDAO {
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public NoticeDetailsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public ArrayList<Notice> getAllNotices() {
	    ArrayList<Notice> notices = new ArrayList<>();

	    if (conn != null) {
	        try {
	        	ps = conn.prepareStatement(CommonQueries.GET_NOTICE);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Notice notice = new Notice(
	                    rs.getInt("notice_id"),
	                    rs.getString("title"),
	                    rs.getString("message"),
	                    rs.getString("type"),
	                    rs.getTimestamp("created_at"),
	                    rs.getTimestamp("updated_at")
	                );
	                notices.add(notice);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return notices;
	}


}
