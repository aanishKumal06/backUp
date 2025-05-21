package com.marshmallowhaven.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static String databaseName = "marshmallow_haven"; 
	private static String username = "root";
	private static String password = ""; 
	private static String jdbcURL = "jdbc:mysql://localhost:3306/" + databaseName;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcURL, username, password);
		return conn;
	}
	
//	public static void main(String[] args) {
//        try {
//            Connection conn = DatabaseConnection.getConnection();
//            if (conn != null && !conn.isClosed()) {
//                System.out.println("✅ Connection to the database was successful!");
//                conn.close(); // Always close the connection when done
//            } else {
//                System.out.println("❌ Failed to connect to the database.");
//            }
//        } catch (ClassNotFoundException e) {
//            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("❌ SQL Exception: " + e.getMessage());
//        }
//    }

}
