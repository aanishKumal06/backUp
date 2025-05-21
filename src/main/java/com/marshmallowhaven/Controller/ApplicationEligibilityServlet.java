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

import com.marshmallowhaven.DAO.ApplicationEligibilityDAO;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class ApplicationEligibilityServlet
 */
@WebServlet("/ApplicationEligibilityServlet")
public class ApplicationEligibilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }

        
        
        
        int userId = user.getUserId();
        
		String roomID = request.getParameter("roomId");
        int roomIdInt = Integer.parseInt(roomID);
        System.out.println(roomIdInt);
        
        boolean isapplicationEligibility = true;
        ApplicationEligibilityDAO applicationEligibility;
        
        try {
			applicationEligibility = new ApplicationEligibilityDAO();
			 ArrayList<String> statuses = applicationEligibility.getApplicationStatusesByUserId(userId);

			    // Loop through the list and print the statuses
			    for (String status : statuses) {
			    	if ("approved".equalsIgnoreCase(status) || "pending".equalsIgnoreCase(status)    ) {
			    		
			    		isapplicationEligibility = false;
			            break; // Stop checking once found
			        }
			    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		    if (isapplicationEligibility) {
		    	
		    	request.setAttribute("roomId", roomIdInt);
		    	request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);

		    }else {
		
		        request.setAttribute("infoMessage", "You have already booked the room. You cannot apply again.");
		
		        request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);
		    }
    
	}
	

}
