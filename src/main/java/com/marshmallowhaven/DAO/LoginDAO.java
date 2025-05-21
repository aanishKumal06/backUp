package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.Model.UserQueries;


public class LoginDAO {
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public LoginDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public User login(String usernameToCheck, String passwordToCheck) {
        User loginedUser = null;
        System.out.println(passwordToCheck);
        
        if (conn != null) {
        	
        	try {
				ps = conn.prepareStatement(UserQueries.USER_LOGIN);
				ps.setString(1, usernameToCheck);
				ps.setString(2, passwordToCheck);
				ResultSet userSet  = ps.executeQuery();
				
				// If user is found, put values to User object
				if (userSet.next()) {
					loginedUser = new User(userSet.getInt("user_id"),
							userSet.getString("full_name"),
							userSet.getString("email"),
							userSet.getString("username"),
							userSet.getString("password"),
							userSet.getString("gender"),
							userSet.getDate("date_of_birth"),
							userSet.getString("contact_number"),
							userSet.getString("address"),
							userSet.getString("profile_image_url"),
							userSet.getString("role"),
							userSet.getTimestamp("created_at"),
							userSet.getTimestamp("updated_at"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }

        
        return loginedUser;
    }

}
