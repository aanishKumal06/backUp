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
import com.marshmallowhaven.Model.ApplicationDetails;

/**
 * Servlet implementation class ApplicationDetailsServlet
 */
@WebServlet("/ApplicationDetailsServlet")
public class ApplicationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("applicationStatus");
		 System.out.println(status);
		ApplicationDetailsDAO  applicationDetails;
		ApplicationStatusDAO applicationStatusDAO ;

		try {
			
			applicationStatusDAO = new ApplicationStatusDAO();
			 HashMap<String, Integer> applicationStatusCounts = applicationStatusDAO.getApplicationStatusCounts();
		     request.setAttribute("applicationStatusCounts", applicationStatusCounts);
		     
		     
			applicationDetails = new ApplicationDetailsDAO();
			ArrayList<ApplicationDetails> applicationList;
			if (status == null || status.equalsIgnoreCase("all")) {
				applicationList = applicationDetails.getAllApplicationDetails();
				
	        } else {
	        	applicationList = applicationDetails.getAllApplicationDetailsByStatus(status);
	        }
			request.setAttribute("applicationList", applicationList);
			

			
	
			 request.setAttribute("selectedApplicationType", status);
		     request.getRequestDispatcher("/Pages/AdminPages/application-management.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
