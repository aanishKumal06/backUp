package com.marshmallowhaven.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.marshmallowhaven.DAO.AddRoomDAO;
import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.DAO.RoomExistsDAO;
import com.marshmallowhaven.DAO.UpdateRoomDAO;
import com.marshmallowhaven.Model.Room;

/**
 * Servlet implementation class UpdateRoomServlet
 */
@WebServlet("/UpdateRoomServlet")
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
        System.out.println(roomID);
        int roomIdInt = Integer.parseInt(roomID);
        System.out.println(roomIdInt);
        RoomDetailsDAO dao;

        
		try {
			dao = new RoomDetailsDAO();
			 ArrayList<Room> rooms;

		            rooms = dao.getARoomDetailById(roomIdInt);
		           
		            
		        String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath); // You must store this in Room object

		        request.setAttribute("roomDetails", rooms);

		        request.getRequestDispatcher("/Pages/AdminPages/edit-room.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
        
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String roomStatus = request.getParameter("status");
		System.out.println(roomStatus);
		
		String roomID = request.getParameter("roomId");
        System.out.println(roomID);
        int roomIdInt = Integer.parseInt(roomID);
        System.out.println(roomIdInt);
        
        String oldRoomNum = request.getParameter("oldRoomNum");
        System.out.println(oldRoomNum);
        String roomNumber = request.getParameter("roomNumber");
        System.out.println(roomNumber);
		String roomType = request.getParameter("roomType");
		String floor = request.getParameter("floor");
		String monthlyFee = request.getParameter("monthlyFee");
		String newRoomStatus = request.getParameter("roomStatus");
		String description = request.getParameter("description");
		int monthlyFeeInt = 0;
	
		String[] facilities = request.getParameterValues("facilities");

		
		

		ArrayList<String> roomErrors = new ArrayList<>();

		
		if (roomNumber == null || roomNumber.trim().isEmpty()) {
		    roomErrors.add("Room number is required.");
		    System.out.println("File not 1234443");
		}
		
		if (roomNumber.length() >= 10) {
			roomErrors.add("Room number must be 10 digits or fewer.");
		}
		
		if (!oldRoomNum.equals(roomNumber)) {
			try {
			    RoomExistsDAO roomDao = new RoomExistsDAO();
			    boolean roomExists = roomDao.roomNumberExists(roomNumber); 
	
			    if (roomExists) {
			    	roomErrors.add("Room number already exists.");
			    }
	
			} catch (ClassNotFoundException | SQLException e) {
	
			    e.printStackTrace();
			}
		}
		if ("vacant".equalsIgnoreCase(roomStatus)) {
			
		
			if (roomType == null) {
			    roomErrors.add("Room type is required.");
			}
	
			if (floor == null ) {
			    roomErrors.add("Room floor is required.");
			}
			
			if (newRoomStatus == null) {
			    roomErrors.add("Room status is required.");
			}
		
	}
		

		if (monthlyFee == null ) {
		    roomErrors.add("Monthly fee is required.");
		}
		
		if (monthlyFee.length() >= 10) {
			roomErrors.add("Monthly fee  must be 10 digits or fewer.");
		}
		
		try {
		    monthlyFeeInt = Integer.parseInt(request.getParameter("monthlyFee"));
		    if (monthlyFeeInt < 1) {
		        roomErrors.add("Monthly fee must be greater than or equal to 1.");
		    }
		} catch (NumberFormatException e) {
		    roomErrors.add("Monthly fee must be a valid number.");
		    System.out.println("File not 1233");
		  		
		}

		
		if (facilities == null) {
		    roomErrors.add("Room facilities is required.");
		}

		if (description == null || description.trim().isEmpty()) {
		    roomErrors.add("Room description is required.");
		    System.out.println("File not 1234443");
		}
		
	
		
		if (roomErrors.isEmpty()) {
			

			
		
			
			
			
			try {
				
				String facilitiesStr = "";
				
				for (String facility : facilities) {
			        facilitiesStr += facility + ", ";
			    }
				
				UpdateRoomDAO updateroom = new UpdateRoomDAO();
				boolean isUpdated = false; 
				if  ("vacant".equalsIgnoreCase(roomStatus)) {
					 isUpdated = updateroom.updateRoomDetails(roomNumber, roomType, floor, monthlyFeeInt,  newRoomStatus, facilitiesStr, description, roomIdInt);
				}else {
					 isUpdated= updateroom.updateRoomDetailsOfOccuied(roomNumber, monthlyFeeInt, facilitiesStr, description, roomIdInt);
				}
			

			        if (isUpdated) {
			        	 request.setAttribute("updateMessage", "Room successfully updated.");
			        	 request.getRequestDispatcher("/Pages/AdminPages/room-management.jsp").forward(request, response);
			            
			        } else {
			            request.setAttribute("roomError", "Update room failed. Please try again.");
			            request.getRequestDispatcher("/Pages/AdminPages/edit-room.jsp").forward(request, response);
			        }
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	

		
		}
		else {
		    request.setAttribute("roomErrors", roomErrors);
		    request.getRequestDispatcher("/Pages/AdminPages/edit-room.jsp").forward(request, response);
		}

	}

}
