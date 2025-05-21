package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.Model.UserQueries;

public class UserDetailsDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UserDetailsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	
	public ArrayList<User> getUserById(int userId) {
		System.out.println("gfg");
		ArrayList<User> users = new ArrayList<>();

	    if (conn != null) {
	        try {
	            ps = conn.prepareStatement(UserQueries.USER_DETAILS_ID); // SELECT * FROM users WHERE user_id = ?
	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                User user = new User(
	                    rs.getInt("user_id"),
	                    rs.getString("full_name"),
	                    rs.getString("email"),
	                    rs.getString("username"),
	                    rs.getString("password"),
	                    rs.getString("gender"),
	                    rs.getDate("date_of_birth"),
	                    rs.getString("contact_number"),
	                    rs.getString("address"),
	                    rs.getString("profile_image_url"),
	                    rs.getString("role"),
	                    rs.getTimestamp("created_at"),
	                    rs.getTimestamp("updated_at")
	                );
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return users;
	}


}
