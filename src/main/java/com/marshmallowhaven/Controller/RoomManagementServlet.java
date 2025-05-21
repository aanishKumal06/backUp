package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.DAO.RoomStatusCountDAO;
import com.marshmallowhaven.Model.Room;

/**
 * Servlet implementation class RoomFilterServlet
 */
@WebServlet("/RoomManagementrServlet")
public class RoomManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("roomStatus"); // e.g., vacant, occupied, maintenance
        RoomDetailsDAO dao;
        RoomStatusCountDAO dao1; 
        System.out.println(status);
        
		try {
			dao = new RoomDetailsDAO();
			 ArrayList<Room> rooms;

		        if (status == null || status.equalsIgnoreCase("all")) {
		            rooms = dao.getAllRooms();
		        } else {
		            rooms = dao.getRoomsByStatus(status);
		        }

		        request.setAttribute("rooms", rooms);
		        request.setAttribute("selectedStatus", status);
		        dao1 = new RoomStatusCountDAO();
		        HashMap<String, Integer> roomStatusCounts = dao1.getRoomStatusCounts();


		        request.setAttribute("roomStatusCounts", roomStatusCounts);
		        request.getRequestDispatcher("/Pages/AdminPages/room-management.jsp").forward(request, response);
		        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
	

}
