package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.marshmallowhaven.DAO.CompliantDetailsDAO;
import com.marshmallowhaven.Model.UserComplaint;

/**
 * Servlet implementation class CompliantDetailsServelt
 */
@WebServlet("/CompliantDetailsServelt")
public class CompliantDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String compliantId = request.getParameter("compliant_id");
        System.out.println(compliantId);
        int compliantIdInt = Integer.parseInt(compliantId);
		
		
		CompliantDetailsDAO complaintDAO ;


	        try {
	        	complaintDAO = new CompliantDetailsDAO();

	        	

	        	 System.out.println("Complaint ID: ");
			     
			     ArrayList<UserComplaint> complaints = complaintDAO.getComplaintsById(compliantIdInt);
	
			     for (UserComplaint complaint : complaints) {
			    	    System.out.println("Complaint ID: " + complaint.getComplaintId());
			    	    System.out.println("Full Name: " + complaint.getFullName());
			    	    System.out.println("Type: " + complaint.getComplaintType());
			    	    System.out.println("Description: " + complaint.getDescription());
			    	    System.out.println("Created At: " + complaint.getCreatedAt());
			    	    System.out.println("---------------------------");
			    	}

	            request.setAttribute("complaints", complaints);


	            
	            request.getRequestDispatcher("/Pages/AdminPages/complaint-details.jsp").forward(request, response);

	        } catch (Exception e) {
	        	// TODO Auto-generated catch block
				e.printStackTrace();  
	        }
	}

	

}
