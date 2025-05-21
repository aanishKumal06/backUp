package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.EmergencyContactByUserId;

public class EmergencyContactDAO {


	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public EmergencyContactDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	public ArrayList<EmergencyContactByUserId> getAllEmergencyContacts(int userId) {
		ArrayList<EmergencyContactByUserId> contacts = new ArrayList<>();

        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(AdminQueries.GET_EMERGENCY_DETAILS);
                ps.setInt(1, userId); 
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                	EmergencyContactByUserId contact = new EmergencyContactByUserId(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("relationship"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                    );
                    contacts.add(contact);
                }

                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Use logging in production
            }
        }

        return contacts;
    }

}
