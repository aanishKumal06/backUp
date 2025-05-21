package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.Model.Room;

/**
 * Servlet implementation class RoomDetailsByIdServlet
 */
@WebServlet("/RoomDetailsByIdServlet")
public class RoomDetailsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomID = request.getParameter("roomId");
        System.out.println(roomID);
        int roomIdInt = Integer.parseInt(roomID);
      
        RoomDetailsDAO dao;

        
		try {
			dao = new RoomDetailsDAO();
			 ArrayList<Room> rooms;

		            rooms = dao.getARoomDetailById(roomIdInt);
		           
		            
		        String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath); // You must store this in Room object

		        request.setAttribute("rooms", rooms);

		        request.getRequestDispatcher("/Pages/UserPages/room-details.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
}
	

}
