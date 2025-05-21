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

import com.marshmallowhaven.DAO.AddComplaintDAO;
import com.marshmallowhaven.Model.Complaint;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class UploadComplaint
 */
@WebServlet("/UploadComplaint")
public class UploadComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
	        User user = (User) session.getAttribute("currentUser");
	
	        if (user == null) {
	        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	            return;
	        }
	
	      
	        int userId = user.getUserId();
	        
		String complaintType = request.getParameter("complaint-type");
		String complaintDescription = request.getParameter("complaint-description");
		

		ArrayList<String> addComplaintErrors = new ArrayList<>();
		
		if (complaintType == null || complaintType.trim().isEmpty()) {
			addComplaintErrors.add("complaintType is required.");
		    System.out.println("File not 12341231443");
		}
		
		if (complaintDescription == null || complaintDescription.trim().isEmpty()) {
			addComplaintErrors.add("complaintDescription is required.");
		    System.out.println("File not 123423123443");
		}
		
		if (addComplaintErrors.isEmpty()) {
			
			AddComplaintDAO addComplaint;
	        
			try {
				addComplaint = new AddComplaintDAO();
				
				
				


		        int complaintId = addComplaint.addComplaint(complaintType, complaintDescription);

		  
		            boolean isInserted = addComplaint.addComplaintId(userId, complaintId);
		            
		            System.out.println(complaintId);
		            System.out.println(userId);

		            if (isInserted) {

		            	request.setAttribute("successMessage", "complaint successfully added.");
		       
		            } else {
		     
		                request.setAttribute("errors", "Failed to complaint with user.");
		                
		            }
		            
		            request.getRequestDispatcher("/Pages/UserPages/complaint.jsp").forward(request, response);      
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.setAttribute("addComplaintErrors", addComplaintErrors);
			 request.getRequestDispatcher("/Pages/UserPages/complaint.jsp").forward(request, response);      
		}
		
	}

}
