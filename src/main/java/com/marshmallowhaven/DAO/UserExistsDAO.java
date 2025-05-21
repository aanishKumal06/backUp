package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.CommonQueries;
import com.marshmallowhaven.Model.UserQueries;

public class UserExistsDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public UserExistsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public boolean usernameExists(String usernameToCheck ) {
	    boolean exists = false;
	    
	    if (conn != null) {
        	
        	try {
				ps = conn.prepareStatement(CommonQueries.CHECK_USER_USERNAME);
				ps.setString(1, usernameToCheck);
		
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
	
	public boolean emailExists(String usernameToCheck ) {
	    boolean exists = false;
	    
	    if (conn != null) {
        	
        	try {
				ps = conn.prepareStatement(CommonQueries.CHECK_USER_EMAIL);
				ps.setString(1, usernameToCheck);
		
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
