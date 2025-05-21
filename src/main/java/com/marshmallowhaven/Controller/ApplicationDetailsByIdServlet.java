package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.ApplicationDetailsDAO;
import com.marshmallowhaven.DAO.EmergencyContactDAO;
import com.marshmallowhaven.Model.ApplicationDetails;
import com.marshmallowhaven.Model.EmergencyContactByUserId;


@WebServlet("/ApplicationDetailsByIdServlet")
public class ApplicationDetailsByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicationUserIdStr = request.getParameter("application_user_id");
		String userIdStr = request.getParameter("user_id");

		System.out.println(applicationUserIdStr);
		System.out.println(userIdStr);
		int applicationUserId = Integer.parseInt(applicationUserIdStr);
		int userId = Integer.parseInt(userIdStr);
		
		ApplicationDetailsDAO  applicationDetails;
		EmergencyContactDAO emergencyContactDAO;

		try {
			applicationDetails = new ApplicationDetailsDAO();
			emergencyContactDAO = new EmergencyContactDAO();

			
			ArrayList<ApplicationDetails> applicationList = applicationDetails.getAllApplicationDetailsByI(applicationUserId);
			request.setAttribute("applicationList", applicationList);
			
			 ArrayList<EmergencyContactByUserId> emergencyContactList =  emergencyContactDAO.getAllEmergencyContacts(userId);
			 request.setAttribute("emergencyContactList", emergencyContactList);
			
			 String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath);
			
		
		     
		     request.getRequestDispatcher("/Pages/AdminPages/application-details.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
