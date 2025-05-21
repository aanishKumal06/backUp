package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.UpdateUserProfileDetails;
import com.marshmallowhaven.DAO.UserDetailsDAO;
import com.marshmallowhaven.DAO.UserExistsDAO;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UserUpdateProfileServlet")
public class UserUpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
	     User user = (User) session.getAttribute("currentUser");

	     if (user == null) {
	     	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	         return;
	     }

	     int userId = user.getUserId();

	     UserDetailsDAO userDetailsDAO;
		try {


		     userDetailsDAO = new UserDetailsDAO();
		     ArrayList<User> userDetails = userDetailsDAO.getUserById(userId);
		     
		     for (User user1 : userDetails) {
		    	    System.out.println("User ID: " + user1.getUserId());
		    	    System.out.println("Full Name: " + user1.getFullName());
		    	    System.out.println("Gender: " + user1.getGender());
		    	    System.out.println("Email: " + user1.getEmail());
		    	    System.out.println("Contact Number: " + user1.getContactNumber());
		    	    System.out.println("Address: " + user1.getAddress());
		    	    System.out.println("Date of Birth: " + user1.getDateOfBirth());
		    	    System.out.println("---------");  // Just a separator for readability
		    	}
			 request.setAttribute("userDetails", userDetails);
	
		     
		       
		        request.getRequestDispatcher("/Pages/UserPages/update-profile.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // or get it via dependency/context if you're using frameworks
	     

	     // Set user details in request scope and forward to JSP
	    
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
	     User user = (User) session.getAttribute("currentUser");

	     if (user == null) {
	     	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	         return;
	     }

	     int userId = user.getUserId();
		 System.out.println("User ID: ");
	 	String name = request.getParameter("fullname");
	    String username = request.getParameter("username");
	    String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
        String birthday = request.getParameter("dob");
        String address = request.getParameter("address");
        
	    String oldUsername = request.getParameter("oldUsername");
	    System.out.println("User ID: " + oldUsername );
	    String oldEmail = request.getParameter("oldEmail");
        
        System.out.println("User ID: ");
	    ArrayList<String> errors = new ArrayList<>();
	    
	    if (name == null || (!name.trim().matches("^[A-Za-z]+(?: [A-Za-z]+)+$"))) {
	    	 System.out.println("name ID: ");
            errors.add("Full name: Requires at least first and last name (letters only, separated by spaces)");
        }

	    if (username == null || username.length() <= 6 || !username.matches("^[a-zA-Z0-9]+$")) {
	        errors.add("Username must be at least 7 characters long and contain no special characters.");
	        System.out.println("name ID: 1");
	    }
	    
	    
        if (email == null || email.isEmpty()) {
            errors.add("email is required.");
        }
	    try {
			UserExistsDAO loginDao = new UserExistsDAO();
			
		
		    if (!oldUsername.equals(username)) {
		    	boolean usernameTaken = loginDao.usernameExists(username);
		    	if (usernameTaken) {
			    	 errors.add("Username already exists.");
			    	 System.out.println("name ID: 2");
			    }
		    }
		    if (!oldEmail.equals(email)) {
		    	boolean emailTaken = loginDao.emailExists(email);
			    if (emailTaken) {
			    	errors.add("Email already exists.");
			    	System.out.println("name ID: 4");
			    }
		    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block+
			e.printStackTrace();
		}
	    
	    if (phone == null || !phone.matches("^\\d{10}$")) {
            errors.add("Phone number must be exactly 10 digits.");
            System.out.println("name ID: 6");
        }
        
        if (birthday == null || birthday.isEmpty()) {
            errors.add("Birthday is required.");
        } else {
            try {
                LocalDate birthDate = LocalDate.parse(birthday);
                if (birthDate.isAfter(LocalDate.now())) {
                    errors.add("Birthday cannot be in the future.");
                    System.out.println("name ID: 5");
                }
            } catch (DateTimeParseException e) {
                errors.add("Invalid birthday format. Use YYYY-MM-DD.");
                System.out.println("name ID: 78 ");
            }
        }
        if (address == null || address.trim().isEmpty()) {
            errors.add("Address is required.");
        }
        if (gender == null || gender.trim().isEmpty()) {
	    	errors.add("gender is required.");
		    System.out.println("File not 123423123443");
		}
        

        
    	if (errors.isEmpty()) {
    		
    		 System.out.println("User ID: v vgfcx dddddddddddddddddd123 ");
    		
    		try {
				UpdateUserProfileDetails updateUserProfileDetails = new UpdateUserProfileDetails();
				boolean isUpdated =  updateUserProfileDetails.updateUserProfile(name, username, gender, email, phone, birthday, address, userId);
				 System.out.println("User ID: ");
				  if (isUpdated) {
			        	 request.setAttribute("updateMessage", "User successfully updated.");
			        	 request.getRequestDispatcher("/Pages/UserPages/update-profile.jsp").forward(request, response);
			            
			        } else {
			            request.setAttribute("error", "Update user failed. Please try again.");
			            request.getRequestDispatcher("/Pages/UserPages/update-profile.jsp").forward(request, response);
			        }
				  
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}else {
    		System.out.println("User ID: v vgfcx ddddddddddddddd23412133132ddd123 ");
	        request.setAttribute("errors", errors);
		    request.getRequestDispatcher("/Pages/UserPages/update-profile.jsp").forward(request, response);
	    
    	}

	}
	
	

}
