package com.marshmallowhaven.Model;

public class UserQueries {
	
	public static final String USER_LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
	
	public static final String USER_DETAILS_ID = "SELECT * FROM users WHERE user_id = ?";

	public static final String REGISTER_CLIENT = "INSERT INTO users (full_name, email, username, password, gender) VALUES (?, ?, ?, ?, ?)";
	
	public static final String TOP_THREE_EXPENSIVE_VACANT_ROOMS = "SELECT * FROM rooms WHERE is_available = 1 ORDER BY monthly_fee DESC LIMIT 3";
	
	public static final String GET_ROOMS_BY_TYPE_AND_PRICE_ORDER = 
		    "SELECT * " +
		    "FROM rooms " +
		    "WHERE is_available = 1 AND room_type = ? OR ? = 'all' " +
		    "ORDER BY " +
		    "CASE WHEN ? = 'low' THEN monthly_fee END ASC, " +
		    "CASE WHEN ? = 'high' THEN monthly_fee END DESC";
	
	
	public static final String GET_VACANT_ROOM_DETAILS_ONLY = "SELECT * FROM rooms WHERE room_status = 'vacant'";
;
	
	public static final String APPLY_APPLICATION = 
		    "INSERT INTO applications (" +
		    "duration_of_stay, expected_check_in , special_requests, " +
		    "photo_url" +
		    ") VALUES (?, ?, ?, ?)";


	
	public static final String UPDATE_USER_BY_USERNAME = 
		    "UPDATE users SET "
		    + "full_name = ?, "
		    + "date_of_birth = ?, "
		    + "contact_number = ?, "
		    + "address = ?, "
		    + "profile_image_url = ? "
		    + "WHERE user_id = ?";
	
	public static final String ADD_EMERGENCY_CONTACT =
		    "INSERT INTO emergency_contacts (name, relationship, phone_number, email) " +
		    "VALUES (?, ?, ?, ?)";

	
	public static final String UPDATE_ROOM_STATUS_BY_ID =
		    "UPDATE rooms SET current_occupancy = ?, is_available = ?, room_status = ? WHERE room_id = ?";
	
	public static final String ADD_APPLICATION_USER_ROOM_WITH_ID = 
		    "INSERT INTO application_user_room (application_id, user_id, room_id) VALUES (?, ?, ?)";
	
	
	public static final String ADD_COMPLIANT_ID = 
		    "INSERT INTO complaint_user_room (user_id, complaint_id) VALUES (?, ?)";
	
	public static final String ADD_COMPLIANT = 
		    "INSERT INTO complaints (complaint_type, description) VALUES (?, ?)";

	public static final String GET_ROOM_STATUS_BY_ID =
		    "SELECT current_occupancy, is_available, room_status , room_type FROM rooms WHERE room_id = ?";


	 public static final String GET_APPLICATION_STATUSES_BY_USER_ID =
		        "SELECT a.status " +
		        "FROM application_user_room AS aur " +
		        "JOIN applications AS a " +
		        "  ON aur.application_id = a.application_id " +
		        "WHERE aur.user_id = ?";
	 
	 public static final String ADD_USER_ASSOCIATION_WITH_IDS = 
			    "INSERT INTO user_associations (user_id, emergency_id) " +
			    "VALUES (?, ?)";
	 
	 
	 public static final String GET_USER_EMERGENCY_ASSOCIATION = 
			    "SELECT "
		        + "u.user_id "
			    + "FROM user_associations uc "
			    + "JOIN emergency_contacts ec ON uc.emergency_id = ec.emergency_id "
			    + "JOIN users u ON uc.user_id = u.user_id " 
			    + "WHERE uc.user_id = ? ";  

	 
	 public static final String GET_APPLICATIONS_DETAILS_BY_USER =
			    "SELECT " +
			    "aur.application_user_id, " +
			    "r.room_number, " +
			    "r.room_type, " +
			    "r.floor, "+
			    "r.monthly_fee, "+
			    "a.duration_of_stay, " +
			    "a.expected_check_in, " +
			    "a.status " +
			    "FROM application_user_room AS aur " +
			    "JOIN users AS u ON aur.user_id = u.user_id " +
			    "JOIN rooms AS r ON aur.room_id = r.room_id " +
			    "JOIN applications AS a ON aur.application_id = a.application_id " +
			    "WHERE u.user_id = ? " +
			    "ORDER BY a.created_at DESC " +
			    "LIMIT 1";
	 
	 public static final String GET_APPLICATIONS_DETAILS_EXCEPT_FIRST =
			    "SELECT " +
			    "aur.application_user_id, " +
			    "r.room_number, " +
			    "r.room_type, " +
			    "r.floor, " +
			    "r.monthly_fee, " +
			    "a.duration_of_stay, " +
			    "a.expected_check_in, " +
			    "a.status " +
			    "FROM application_user_room AS aur " +
			    "JOIN users AS u ON aur.user_id = u.user_id " +
			    "JOIN rooms AS r ON aur.room_id = r.room_id " +
			    "JOIN applications AS a ON aur.application_id = a.application_id " +
			    "WHERE u.user_id = ? " +
			    "ORDER BY a.created_at DESC " +
			    "LIMIT 1000 OFFSET 1"; 
	 
	 public static final String UPDATE_USER_PROFILE =
			    "UPDATE users SET " +
			    "full_name = ?, " +
			    "username = ?, " +
			    "gender = ?, " +
			    "email = ?, " +
			    "contact_number = ?, " +
			    "date_of_birth = ?, " +
			    "address = ? " +
			    "WHERE user_id = ?";
	 
	 public static final String UPDATE_USER_PROFILE_IMAGE =
			    "UPDATE users SET " +
			    "profile_image_url = ? " +
			    "WHERE user_id = ?";
	 
	 public static final String UPDATE_USER_PASSWORD =
			    "UPDATE users SET " +
			    "password = ? " +
			    "WHERE user_id = ?";

	 
	 public static final String INSERT_INTO_WISHLIST =
			    "INSERT INTO wishlist (user_id, room_id) " +
			    "VALUES (?, ?)";

	 public static final String GET_VACANT_ROOM_DETAILS_FROM_WISHLIST_BY_USER_ID =
			    "SELECT r.room_id, r.room_number, r.room_type, r.room_description, r.room_facilities, " +
			    "r.capacity, r.current_occupancy, r.monthly_fee, r.is_available, r.image_url, " +
			    "r.floor, r.room_status " +
			    "FROM wishlist w " +
			    "JOIN rooms r ON w.room_id = r.room_id " +
			    "WHERE w.user_id = ? AND r.room_status = 'vacant'";
	 
	 
	    public static final String DELETE_FROM_WISHLIST_BY_ROOM_ID =
	            "DELETE FROM wishlist WHERE room_id = ? AND user_id = ?";
	    
	    public static final String CHECK_WISHLIST =
	    	    "SELECT EXISTS (SELECT 1 FROM wishlist " +
	    	    "WHERE user_id = ? AND room_id = ?) AS is_in_wishlist";



}