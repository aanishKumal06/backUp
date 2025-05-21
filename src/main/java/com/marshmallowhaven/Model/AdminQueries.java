package com.marshmallowhaven.Model;

public class AdminQueries {
	
	public static final String ADD_ROOM = "INSERT INTO rooms (room_number, room_type, floor, monthly_fee, room_status, room_description, room_facilities, image_url, capacity, is_available) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String GET_ROOM_STATUS_COUNTS = 
		    "SELECT room_status, COUNT(*) AS count " +
		    "FROM rooms " +
		    "GROUP BY room_status";

		public static final String GET_TOTAL_ROOM_COUNT = 
		    "SELECT COUNT(*) AS total_rooms " +
		    "FROM rooms";
	
	public static final String CHECK_ROOM_NUMBER = "SELECT * FROM rooms WHERE room_number = ?";

	public static final String DELETE_APPLICATION_USERS_BY_ROOM_ID = 
		    "DELETE FROM application_user_room WHERE room_id = ?";

		public static final String DELETE_ROOM_BY_ROOM_ID = 
		    "DELETE FROM rooms WHERE room_id = ?";

		public static final String GET_APPLICATIONS_STATUS_COUNTS = 
			    "SELECT status, COUNT(*) AS count " +
			    "FROM applications " +
			    "GROUP BY status";
		
		public static final String GET_APPLICATIONS_COUNT = 
			    "SELECT COUNT(*) AS total_applications " +
			    "FROM applications";
		
		public static final String GET_COMPLAINTS_TYPES_COUNTS = 
			    "SELECT complaint_type, COUNT(*) AS count " +
			    "FROM complaints " +
			    "GROUP BY complaint_type";
	
		
		public static final String GET_COMPLAINTS_COUNT = 
			    "SELECT COUNT(*) AS total_complaints " +
			    "FROM complaints";
		
		public static final String GET_USERS_COUNT = 
			    "SELECT COUNT(*) AS total_users " +
			    "FROM users " +  
			    "WHERE role = 'customer'";

		
		public static final String GET_TOP_THREE_APPLICATIONS =
			    "SELECT " +
			    "aur.application_user_id, " +
			    "u.full_name, " +
			    "u.user_id, " +
			    "u.email, " +
			    "u.gender, " +
			    "u.date_of_birth, " +
			    "u.contact_number, " +
			    "u.address, " +
			    "r.room_number, " +
			    "r.room_type, " +
			    "r.current_occupancy, " +
			    "a.application_id, " +
			    "a.duration_of_stay, " +
			    "a.expected_check_in, " +
			    "a.check_out_date, " +
			    "a.special_requests, " +
			    "a.status, " +
			    "a.photo_url, " +
			    "a.created_at AS application_created_at " +
			    "FROM application_user_room AS aur " +
			    "JOIN users AS u ON aur.user_id = u.user_id " +
			    "JOIN rooms AS r ON aur.room_id = r.room_id " +
			    "JOIN applications AS a ON aur.application_id = a.application_id " +
			    "ORDER BY a.created_at DESC " +
			    "LIMIT 3";
		
		public static final String GET_APPLICATIONS =
			    "SELECT " +
			    "aur.application_user_id, " +
			    "u.full_name, " +
			    "u.user_id, " +
			    "u.email, " +
			    "u.gender, " +
			    "u.date_of_birth, " +
			    "u.contact_number, " +
			    "u.address, " +
			    "r.room_number, " +
			    "r.room_type, " +
			    "r.current_occupancy, " +
			    "a.application_id, " +
			    "a.duration_of_stay, " +
			    "a.expected_check_in, " +
			    "a.check_out_date, " +
			    "a.special_requests, " +
			    "a.status, " +
			    "a.photo_url, " +
			    "a.created_at AS application_created_at " +
			    "FROM application_user_room AS aur " +
			    "JOIN users AS u ON aur.user_id = u.user_id " +
			    "JOIN rooms AS r ON aur.room_id = r.room_id " +
			    "JOIN applications AS a ON aur.application_id = a.application_id " +
			    "ORDER BY a.created_at DESC " ;
		
		public static final String GET_APPLICATIONS_BY_STATUS =
			    "SELECT " +
			    "aur.application_user_id, " +
			    "u.full_name, " +
			    "u.user_id, " +
			    "u.email, " +
			    "u.gender, " +
			    "u.date_of_birth, " +
			    "u.contact_number, " +
			    "u.address, " +
			    "r.room_number, " +
			    "r.room_type, " +
			    "r.current_occupancy, " +
			    "a.application_id, " +
			    "a.duration_of_stay, " +
			    "a.expected_check_in, " +
			    "a.check_out_date, " +
			    "a.special_requests, " +
			    "a.status, " +
			    "a.photo_url, " +
			    "a.created_at AS application_created_at " +
			    "FROM application_user_room AS aur " +
			    "JOIN users AS u ON aur.user_id = u.user_id " +
			    "JOIN rooms AS r ON aur.room_id = r.room_id " +
			    "JOIN applications AS a ON aur.application_id = a.application_id " +
			    "Where a.status = ?" +
			    "ORDER BY a.created_at DESC " ;
		
		public static final String GET_APPLICATIONS_BY_ID =
			    "SELECT " +
			    "aur.application_user_id, " +
			    "u.full_name, " +
			    "u.user_id, " +
			    "u.email, " +
			    "u.gender, " +
			    "u.date_of_birth, " +
			    "u.contact_number, " +
			    "u.address, " +
			    "r.room_number, " +
			    "r.room_type, " +
			    "r.current_occupancy, " +
			    "a.application_id, " +
			    "a.duration_of_stay, " +
			    "a.expected_check_in, " +
			    "a.check_out_date, " +
			    "a.special_requests, " +
			    "a.status, " +
			    "a.photo_url, " +
			    "a.created_at AS application_created_at " +
			    "FROM application_user_room AS aur " +
			    "JOIN users AS u ON aur.user_id = u.user_id " +
			    "JOIN rooms AS r ON aur.room_id = r.room_id " +
			    "JOIN applications AS a ON aur.application_id = a.application_id " +
			    "Where aur.application_user_id = ?";

		 public static final String GET_EMERGENCY_DETAILS = 
				    "SELECT "+
			        "u.user_id, "+
			        "ec.name, "+
			        "ec.relationship, "+
			        "ec.phone_number, "+
			        "ec.email "+
				    "FROM user_associations uc "+
				    "JOIN emergency_contacts ec ON uc.emergency_id = ec.emergency_id "+ 
				    "JOIN users u ON uc.user_id = u.user_id "+ 
				    "Where u.user_id = ?"; 
		 
		 
		 public static final String UPDATE_APPLICATION_STATUS_AND_CHECKOUT_DATE_BY_ID = 
				    "UPDATE applications SET "+
				    "check_out_date = ?, " +
				    "status = ? " +
				    "WHERE application_id = ?";
		 
		 public static final String UPDATE_APPLICATION_STATUS_BY_ID = 
				    "UPDATE applications SET " +
				    "status = ? " +
				    "WHERE application_id = ?";

		 public static final String UPDATE_ROOM_OCCUPANCY_AND_STATUS =
				    "UPDATE rooms " +
				    "SET current_occupancy = ?, " +
				    " room_status = ? " +
				    "WHERE room_number = ?";
		 
		 public static final String UPDATE_ROOM_DETAILS =
				    "UPDATE rooms " +
				    "SET room_number = ?, "+
				    "room_type = ?, " +
				    "floor = ?, " +
				    "monthly_fee = ?, " +
				    "room_status = ?, " +
				    "room_facilities = ?, " +
				    "room_description = ? " +
				    "WHERE room_id = ?";

		 public static final String UPDATE_ROOM_DETAILS_FOR_OCCUPIED =
				    "UPDATE rooms " +
				    "SET room_number = ?, "+
				    "monthly_fee = ?, " +
				    "room_facilities = ?, " +
				    "room_description = ? " +
				    "WHERE room_id = ?";
		 
		 public static final String INSERT_NOTICE = 
				    "INSERT INTO Notice (title, message, type) VALUES (?, ?, ?)";
		 
			public static final String ADD_APPLICATION_USER_ROOM_WITH_NOTICE_ID = 
				    "INSERT INTO user_associations ( notice_id, user_id) VALUES (?, ?)";

			
			public static final String GET_COMPLAINTS_WITH_USER_NAMES =
				    "SELECT u.full_name, " +
				    "       c.complaint_id, " +
				    "       c.complaint_type, " +
				    "       c.description, " +
				    "       c.created_at " +
				    "FROM complaints c " +
				    "JOIN complaint_user_room cu ON c.complaint_id = cu.complaint_id " +
				    "JOIN users u ON cu.user_id = u.user_id";


			public static final String GET_COMPLAINTS_BY_TYPE_WITH_USER_NAMES =
				    "SELECT u.full_name, " +
				    "       c.complaint_id, " +
				    "       c.complaint_type, " +
				    "       c.description, " +
				    "       c.created_at " +
				    "FROM complaints c " +
				    "JOIN complaint_user_room cu ON c.complaint_id = cu.complaint_id " +
				    "JOIN users u ON cu.user_id = u.user_id " +
				    "WHERE c.complaint_type = ?";
			
			
			public static final String GET_COMPLAINTS_BY__USER_ID =
				    "SELECT u.full_name, " +
				    "       c.complaint_id, " +
				    "       c.complaint_type, " +
				    "       c.description, " +
				    "       c.created_at " +
				    "FROM complaints c " +
				    "JOIN complaint_user_room cu ON c.complaint_id = cu.complaint_id " +
				    "JOIN users u ON cu.user_id = u.user_id " +
				    "WHERE cu.complaint_id = ?";

			 public static final String UPDATE_ADMIN_CREDENTAILS =
					    "UPDATE users SET " +
					    "username = ?, " +
					    "password = ? " +
					    "WHERE user_id = ?";
			 
			 
			 public static final String DELETE_FROM_USER_ASSOCIATIONS =
					    "DELETE FROM user_associations WHERE notice_id = ?";

			public static final String DELETE_FROM_NOTICE =
			    "DELETE FROM notice WHERE notice_id = ?";
			
			
			public static final String GET_ROOM_TYPE_BOOKING_COUNT =
				    "SELECT r.room_type, " +
				    "COUNT(aur.room_id) AS booking_count " +
				    "FROM rooms r " +
				    "JOIN application_user_room aur ON r.room_id = aur.room_id " +
				    "GROUP BY r.room_type " +
				    "ORDER BY booking_count DESC";
			
			public static final String GET_DAILY_BOOKINGS_BY_ROOM_TYPE =
				    "SELECT r.room_type, " +
				    "DATE(a.expected_check_in) AS booking_date, " +
				    "COUNT(*) AS total_bookings " +
				    "FROM application_user_room au " +
				    "JOIN applications a ON au.application_id = a.application_id " +
				    "JOIN rooms r ON au.room_id = r.room_id " +
				    "GROUP BY r.room_type, booking_date " +
				    "ORDER BY booking_date DESC, total_bookings DESC";

		

			 
			 

}
