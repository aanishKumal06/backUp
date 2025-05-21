package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;
import com.marshmallowhaven.Model.UserComplaint;
import com.marshmallowhaven.Model.UserQueries;

public class CompliantDetailsDAO {
	
	
	private Connection conn;
	private PreparedStatement ps;
	// Constructor: Initializes the database connection when an object is created
	public CompliantDetailsDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}
	
	
    public ArrayList<UserComplaint> getAllComplaintsWithUserNames() {
        ArrayList<UserComplaint> complaintList = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(AdminQueries.GET_COMPLAINTS_WITH_USER_NAMES);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserComplaint complaint = new UserComplaint(
                    rs.getString("full_name"),
                    rs.getInt("complaint_id"),
                    rs.getString("complaint_type"),
                    rs.getString("description"),
                    rs.getTimestamp("created_at")
                );
                complaintList.add(complaint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaintList;
    }

    public ArrayList<UserComplaint> getComplaintsByType(String complaintType) {
        ArrayList<UserComplaint> complaintList = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(AdminQueries.GET_COMPLAINTS_BY_TYPE_WITH_USER_NAMES);
            ps.setString(1, complaintType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserComplaint complaint = new UserComplaint(
                    rs.getString("full_name"),
                    rs.getInt("complaint_id"),
                    rs.getString("complaint_type"),
                    rs.getString("description"),
                    rs.getTimestamp("created_at")
                );
                complaintList.add(complaint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaintList;
    }
    
    
    public ArrayList<UserComplaint> getComplaintsById(int userId) {
        ArrayList<UserComplaint> complaintList = new ArrayList<>();
   	 System.out.println("Complaint ID: ");
        try {
            PreparedStatement ps = conn.prepareStatement(AdminQueries.GET_COMPLAINTS_BY__USER_ID);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserComplaint complaint = new UserComplaint(
                    rs.getString("full_name"),
                    rs.getInt("complaint_id"),
                    rs.getString("complaint_type"),
                    rs.getString("description"),
                    rs.getTimestamp("created_at")
                );
                complaintList.add(complaint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return complaintList;
    }

}
