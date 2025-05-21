package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.AddWhislistDAO;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class UploadWishListServlet
 */
@WebServlet("/UploadWishListServlet")
public class UploadWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }
        
        String roomID = request.getParameter("roomId");
        
        
        AddWhislistDAO wishlistDAO;
		try {
			 int userId = user.getUserId();
			 int roomIdInt = Integer.parseInt(roomID);
			wishlistDAO = new AddWhislistDAO();
			 System.out.println(roomIdInt);
		        
			boolean success = wishlistDAO.addWishlistEntry(userId, roomIdInt);
			
			if(success) {
				request.setAttribute("message", "Add Room to wishlist successfuly.");
	            request.getRequestDispatcher("/Pages/UserPages/room-details.jsp").forward(request, response);
			}else {
				  request.setAttribute("message", "Add Room to wishlist failed. Please try again.");
		            request.getRequestDispatcher("/Pages/UserPages/room-details.jsp").forward(request, response);
			}
	

		} catch (ClassNotFoundException | SQLException e) {
			
		}
        
	}

}
