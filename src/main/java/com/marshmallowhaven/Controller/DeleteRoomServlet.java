package com.marshmallowhaven.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.DeleteRoomDAO;

/**
 * Servlet implementation class DeleteRoomServlet
 */
@WebServlet("/delete-room")
public class DeleteRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String roomIdParam = request.getParameter("roomId");
	       System.out.println(roomIdParam);


		    try {
		        int roomId = Integer.parseInt(roomIdParam);

		        DeleteRoomDAO dao = new DeleteRoomDAO();
		        boolean deleted = dao.deleteRoomAndApplicationsByRoomId(roomId);
		        
		        if (deleted) {
		            request.setAttribute("message", "Room  deleted successfully.");
		            request.getRequestDispatcher("/Pages/AdminPages/room-delete-message.jsp").forward(request, response);
		        } else {
		            request.setAttribute("message", "Room not found or could not be deleted.");
		            request.getRequestDispatcher("/Pages/AdminPages/room-delete-message.jsp").forward(request, response);
		        }
		    
		    } catch (Exception e) {
		

		    }
		    
		    
		}
	}
