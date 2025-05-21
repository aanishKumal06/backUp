package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.UserQueries;

public class CheckEmergencyContactsDAO {
	

	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public CheckEmergencyContactsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	    public Integer getUserId(int userId) {
	        Integer isUserId = null;



	        try  {
	        	ps = conn.prepareStatement(UserQueries.GET_USER_EMERGENCY_ASSOCIATION);
	            ps.setInt(1, userId);


	            ResultSet rs = ps.executeQuery();
	                if (rs.next()) {
	                	isUserId = rs.getInt("user_id"); 
	                }

	        } catch (SQLException e) {
	            e.printStackTrace();  
	        }

	        return isUserId;  
	    }

}
