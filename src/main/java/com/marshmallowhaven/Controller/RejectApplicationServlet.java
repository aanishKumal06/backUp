package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.UpdateApplicationDAO;
import com.marshmallowhaven.DAO.UpdateRoomDAO;

/**
 * Servlet implementation class RejectApplicationServlet
 */
@WebServlet("/RejectApplicationServlet")
public class RejectApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String appIdStr = request.getParameter("application_id");
		System.out.println(appIdStr);

	

	    String status = "rejected";
	    
	    
	    String roomNumber = request.getParameter("roomNumber");
	    String roomType = request.getParameter("roomType");
	    String currentOccupancyStr = request.getParameter("currentOccupancy");

	    System.out.println(roomNumber);
	    
	    System.out.println(currentOccupancyStr);
	    System.out.println(roomType);
	    
	    try {
	    	int currentOccupancy = Integer.parseInt(currentOccupancyStr);
	        int applicationId = Integer.parseInt(appIdStr);
	        
	
	  
	        	
	        	int roomOccupancy = 0 ;  
	        	String roomStatus = "vacant";
	        	
		        if (roomType.equals("Single AC") ||roomType.equals("Single Non-AC")) {
		        	 roomOccupancy = 0 ;  
		        } else if(roomType.equals("Double AC") ||roomType.equals("Double Non-AC")) {
		        	if (currentOccupancy == 2 ) {
			        	 roomOccupancy = 1 ; 
			        }else {
			        	 roomOccupancy = 0 ;  
			        	 
			        }
		        }
		        

	            UpdateApplicationDAO appDao = new UpdateApplicationDAO();
	            
	            UpdateRoomDAO roomDao = new UpdateRoomDAO();

	            boolean isApplicationUpdated = appDao.updateApplicationStatus(applicationId, status);

	            boolean isRoomUpdated  = roomDao.updateRoomOccupancyAndStatus(roomNumber, roomOccupancy, roomStatus);
	            
	            if (isApplicationUpdated && isRoomUpdated) {
	                request.setAttribute("infoMsg", "Update successful!");
	            } else {
	                request.setAttribute("errorMsg", "Update failed!");
	            }
	        
	        
	        

           

	        request.getRequestDispatcher("/Pages/AdminPages/application-management.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().write("Error: " + e.getMessage());
	    }
	}

}
