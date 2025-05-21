package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.ComplaintTypeCountDAO;
import com.marshmallowhaven.DAO.CompliantDetailsDAO;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.UserComplaint;

/**
 * Servlet implementation class ComplaintManagementServlet
 */
@WebServlet("/ComplaintManagementServlet")
public class ComplaintManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type= request.getParameter("ComplaintType");
		
		
		CompliantDetailsDAO complaintDAO ;
		ComplaintTypeCountDAO complaintTypesCountDAO;

	        try {
	        	complaintDAO = new CompliantDetailsDAO();
	        	complaintTypesCountDAO =new ComplaintTypeCountDAO();
	        	
	        	
	        	 HashMap<String, Integer> conmplaintsStatusCounts = complaintTypesCountDAO.getComplaintStatusCounts();
			     request.setAttribute("conmplaintsStatusCounts", conmplaintsStatusCounts);
			     
			     
			     ArrayList<UserComplaint> complaints;

			        if (type == null || type.equalsIgnoreCase("all")) {
			        	complaints = complaintDAO.getAllComplaintsWithUserNames();
			        }else {
			        	complaints = complaintDAO.getComplaintsByType(type);
			        }
			        
				     for (Entry<String, Integer> entry : conmplaintsStatusCounts.entrySet()) {
				    	    System.out.println("Type: " + entry.getKey() + ", Count: " + entry.getValue());
				    	}

	            request.setAttribute("complaints", complaints);
	            request.setAttribute("selectedComplaint", type);
	            request.setAttribute("conmplaintsStatusCounts", conmplaintsStatusCounts);
	            
	            request.getRequestDispatcher("/Pages/AdminPages/complaint-management.jsp").forward(request, response);

	        } catch (Exception e) {
	        	// TODO Auto-generated catch block
				e.printStackTrace();  
	        }
		 
	}

	

}
