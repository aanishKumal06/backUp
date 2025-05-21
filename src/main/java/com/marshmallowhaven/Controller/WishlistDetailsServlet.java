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

import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class WishlistDetailsServlet
 */
@WebServlet("/WishlistDetailsServlet")
public class WishlistDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomDetailsDAO dao;

		HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }
        
        int userId = user.getUserId();
        
		try {
			dao = new RoomDetailsDAO();
			 ArrayList<Room> rooms;

		            rooms = dao.getVacantWishlistRoomsByUserId(userId);
		            
		            
		           
		        String displayPath = request.getContextPath() + "/photos/" ;
		        request.setAttribute("imgURL",displayPath); // You must store this in Room object

		        request.setAttribute("rooms", rooms);


		        request.getRequestDispatcher("/Pages/UserPages/wishlist.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	

}
