package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.UpdateAdminCredentialsDAO;
import com.marshmallowhaven.DAO.UpdateUserPasswordDAO;
import com.marshmallowhaven.DAO.UserExistsDAO;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.util.EncryptDecrypt;

/**
 * Servlet implementation class UpdateAdminCredentials
 */
@WebServlet("/UpdateAdminCredentials")
public class UpdateAdminCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
	     User user = (User) session.getAttribute("currentUser");

	     if (user == null) {
	     	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	         return;
	     }

	     int userId = user.getUserId();


	     
		ArrayList<String> updateCredentialsError = new ArrayList<>();
		
	    String password = request.getParameter("password");
	    String username = request.getParameter("username");
	    System.out.println("User ID: " + username );
	    String oldUsername = request.getParameter("oldUsername");
	    System.out.println("User ID: " + oldUsername );
	    String encryptPassword = EncryptDecrypt.encrypt(password);
	    
	    
	    if (password == null || password.isEmpty()) {
	    	updateCredentialsError.add("Password  is required.");
	    	
		}
	    
	    if (password.length() <= 6 || !password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,}$")) {
	    	updateCredentialsError.add("Password: Must be >6 characters, include a number, uppercase letter, and special symbol (e.g., #, $).");
	    }
		
	    
	    if (username == null || username.length() <= 6 || !username.matches("^[a-zA-Z0-9]+$")) {
	    	updateCredentialsError.add("Username must be at least 7 characters long and contain no special characters.");
	        System.out.println("name ID: 1");
	    }
	    
	    
        if (username == null || username.isEmpty()) {
        	updateCredentialsError.add("username is required.");
        }
	    
	    
	    if (updateCredentialsError.isEmpty()) {
	 		
	 		
	 		
			try {
			   
				UpdateAdminCredentialsDAO updateAdminCredentials = new UpdateAdminCredentialsDAO();

				
				boolean isUpdated = updateAdminCredentials.updateAdminCredentials(username, encryptPassword, userId);
				
				  if (isUpdated) {
			        	 request.setAttribute("updateMessage", "credentials successfully updated.");
			        	 request.getRequestDispatcher("/Pages/AdminPages/edit-credentials.jsp").forward(request, response);
			            
			        } else {
			            request.setAttribute("updateError", "Update credentials failed. Please try again.");
			            request.getRequestDispatcher("/Pages/AdminPages/edit-credentials.jsp").forward(request, response);
			        
						
			} 
				  
			}catch (Exception e) {
				
				System.out.println("File not uploaded");
				request.setAttribute("updateError", "Update credentials failed. Please try again.");
	            request.getRequestDispatcher("/Pages/AdminPages/edit-credentials.jsp").forward(request, response);
			}
			
			
			
	 		
			}
			
			
	 	else {
	 		request.setAttribute("updateCredentialsError", updateCredentialsError);
           request.getRequestDispatcher("/Pages/AdminPages/edit-credentials.jsp").forward(request, response);
	 		
	 	}
	}

}
