package com.marshmallowhaven.Model;

public class CommonQueries {
	
	public static final String GET_ROOM_DETAILS = "SELECT * FROM rooms";
	public static final String CHECK_USER_USERNAME = "SELECT * FROM users WHERE username = ?";
	public static final String CHECK_USER_EMAIL = "SELECT * FROM users WHERE username = ? ";
	public static final String GET_ROOM_DETAILS_BY_STATUS = "SELECT * FROM rooms WHERE room_status = ?";
	public static final String CHECK_ROOM_NUMBER = "SELECT * FROM rooms WHERE room_number = ?";
	public static final String GET_ROOM_DETAILS_BY_ID= "SELECT * FROM rooms WHERE room_id = ?";
	public static final String GET_NOTICE = "SELECT * FROM notice ORDER BY created_at DESC";


}
