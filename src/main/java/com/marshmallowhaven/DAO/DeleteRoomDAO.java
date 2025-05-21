package com.marshmallowhaven.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.marshmallowhaven.DatabaseConnection.DatabaseConnection;
import com.marshmallowhaven.Model.AdminQueries;

public class DeleteRoomDAO {


    private Connection conn;
    private PreparedStatement ps;

    // Constructor: Establishes DB connection
    public DeleteRoomDAO() throws ClassNotFoundException, SQLException {
        this.conn = DatabaseConnection.getConnection(); // Assuming it returns a live connection
    }

    // Method to delete application_users and then the room based on room_id
    public boolean deleteRoomAndApplicationsByRoomId(int roomId) {
        boolean success = false;

        if (conn != null) {
            try {
                // Delete from application_users
                ps = conn.prepareStatement(AdminQueries.DELETE_APPLICATION_USERS_BY_ROOM_ID);
                ps.setInt(1, roomId);
                ps.executeUpdate();
                ps.close();

                // Delete from rooms
                ps = conn.prepareStatement(AdminQueries.DELETE_ROOM_BY_ROOM_ID);
                ps.setInt(1, roomId);
                int rowsAffected = ps.executeUpdate();
                ps.close();

                success = rowsAffected > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }
}