package com.marshmallowhaven.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.DeleteWishlistDAO;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class DeleteWishServlet
 */
@WebServlet("/DeleteWishServlet")
public class DeleteWishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomIdParam = request.getParameter("roomId");
	       System.out.println(roomIdParam);

	       HttpSession session = request.getSession(false);
	        User user = (User) session.getAttribute("currentUser");
	
	        if (user == null) {
	        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	            return;
	        }
	
	        
	        
	        if (roomIdParam != null && !roomIdParam.isEmpty()) {
	        	
	        	try {
	         
	        	     
	                int userId = user.getUserId();
	                int roomId = Integer.parseInt(roomIdParam);
	                DeleteWishlistDAO dao = new DeleteWishlistDAO();

	                boolean deleted = dao.deleteWishlistByRoomIdAndUserId(roomId, userId);

	                
	                if (deleted) {
	    	            request.setAttribute("message", "Wishlist  deleted successfully.");
	    	            request.getRequestDispatcher("/Pages/UserPages/wishlist.jsp").forward(request, response);
	    	        } else {
	    	            request.setAttribute("message", " Wishlist could not be deleted.");
	    	            request.getRequestDispatcher("/Pages/UserPages/wishlist.jsp").forward(request, response);
	    	        }
	                
		        } catch (Exception e) {
		    		
	
			    }

	            
	        }

	        
	    

		
		    
	}

}
