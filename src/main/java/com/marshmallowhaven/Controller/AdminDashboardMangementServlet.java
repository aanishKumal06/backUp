package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.ApplicationDetailsDAO;
import com.marshmallowhaven.DAO.ApplicationStatusDAO;
import com.marshmallowhaven.DAO.ComplaintTypeCountDAO;
import com.marshmallowhaven.DAO.RoomStatusCountDAO;
import com.marshmallowhaven.DAO.UserCountDAO;
import com.marshmallowhaven.Model.ApplicationDetails;


/**
 * Servlet implementation class AdminDashboardMangementServlet
 */
@WebServlet("/AdminDashboardMangementServlet")
public class AdminDashboardMangementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationDetailsDAO  applicationDetails;
		ApplicationStatusDAO applicationStatusDAO;
		ComplaintTypeCountDAO complaintTypesCountDAO;
		RoomStatusCountDAO roomStatusCountDAO;
		UserCountDAO adminDAO ;
		try {
			applicationDetails = new ApplicationDetailsDAO();
			applicationStatusDAO = new ApplicationStatusDAO();
			complaintTypesCountDAO =new ComplaintTypeCountDAO();
			roomStatusCountDAO =  new RoomStatusCountDAO();
			adminDAO = new UserCountDAO();
			
			
			ArrayList<ApplicationDetails> applicationList = applicationDetails.getTopThreeAllApplicationDetails();
			request.setAttribute("applicationList", applicationList);

			
			
			 HashMap<String, Integer> applicationStatusCounts = applicationStatusDAO.getApplicationStatusCounts();
		     request.setAttribute("applicationStatusCounts", applicationStatusCounts);
		     
		     HashMap<String, Integer> conmplaintsStatusCounts = complaintTypesCountDAO.getComplaintStatusCounts();
		     request.setAttribute("conmplaintsStatusCounts", conmplaintsStatusCounts);
		     
		     for (Entry<String, Integer> entry : applicationStatusCounts.entrySet()) {
		    	    System.out.println("Status: " + entry.getKey() + ", Count: " + entry.getValue());
		    	}
		     
		     for (Entry<String, Integer> entry : conmplaintsStatusCounts.entrySet()) {
		    	    System.out.println("Type: " + entry.getKey() + ", Count: " + entry.getValue());
		    	}

		     HashMap<String, Integer> roomStatusCounts = roomStatusCountDAO.getRoomStatusCounts();
		     request.setAttribute("roomStatusCounts", roomStatusCounts);
		     
		     for (Entry<String, Integer> entry : roomStatusCounts.entrySet()) {
		    	    System.out.println("Status: " + entry.getKey() + ", Count: " + entry.getValue());
		    	}
		     int totalusers = adminDAO.getTotalUserCount();
		     request.setAttribute("totalusers", totalusers);
		     
		     request.getRequestDispatcher("/Pages/AdminPages/admin-dashboard.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
			
				
				
			      		
	       
	    }

}


