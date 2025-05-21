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

import com.marshmallowhaven.DAO.ApplicationDetailsDAO;
import com.marshmallowhaven.DAO.ApplicationStatusDAO;
import com.marshmallowhaven.DAO.UserDetailsDAO;
import com.marshmallowhaven.Model.ApplicationDetails;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.Model.UserApplicationDetails;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
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
	     ApplicationDetailsDAO applicationDAO ;
		try {


		     userDetailsDAO = new UserDetailsDAO();
		     applicationDAO = new ApplicationDetailsDAO();
		     
		     ArrayList<User> userDetails = userDetailsDAO.getUserById(userId);
		     ArrayList<UserApplicationDetails> applicationListRecentone = applicationDAO.getApplicationDetailsRecentOne(userId);
		     ArrayList<UserApplicationDetails> applicationListExceptFirst = applicationDAO.getApplicationDetailsExceptFirst(userId);

		     System.out.println("Most Recent Application:");
		     for (UserApplicationDetails app : applicationListRecentone) {
		         System.out.println("Application User ID: " + app.getApplicationUserId());
		         System.out.println("Room Number: " + app.getRoomNumber());
		         System.out.println("Room Type: " + app.getRoomType());
		         System.out.println("Room Floor: " + app.getRoomfloor());
		         System.out.println("Monthly Fee: " + app.getMonthlyFee());
		         System.out.println("Duration of Stay: " + app.getDurationOfStay());
		         System.out.println("Expected Check-In: " + app.getExpectedCheckIn());
		         System.out.println("Status: " + app.getStatus());
		         System.out.println("----------------------------------");
		     }

		     System.out.println("Applications Except the Most Recent One:");
		     for (UserApplicationDetails app : applicationListExceptFirst) {
		         System.out.println("Application User ID: " + app.getApplicationUserId());
		         System.out.println("Room Number: " + app.getRoomNumber());
		         System.out.println("Room Type: " + app.getRoomType());
		         System.out.println("Room Floor: " + app.getRoomfloor());
		         System.out.println("Monthly Fee: " + app.getMonthlyFee());
		         System.out.println("Duration of Stay: " + app.getDurationOfStay());
		         System.out.println("Expected Check-In: " + app.getExpectedCheckIn());
		         System.out.println("Status: " + app.getStatus());
		         System.out.println("----------------------------------");
		     }


		     
			 request.setAttribute("user", userDetails);
			 request.setAttribute("applicationRecentone", applicationListRecentone);
			 request.setAttribute("applicationExceptFirst", applicationListExceptFirst);
	
		     
			 String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath);
		       
		        request.getRequestDispatcher("/Pages/UserPages/student-dashboard.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // or get it via dependency/context if you're using frameworks
	     

	     // Set user details in request scope and forward to JSP
	    
	}



}
