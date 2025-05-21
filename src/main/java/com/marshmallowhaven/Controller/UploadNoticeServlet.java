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

import com.marshmallowhaven.DAO.AddNotice;
import com.marshmallowhaven.Model.Notice;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class UploadNoticeServlet
 */
@WebServlet("/UploadNoticeServlet")
public class UploadNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  HttpSession session = request.getSession(false);
	        User user = (User) session.getAttribute("currentUser");
	
	        if (user == null) {
	        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	            return;
	        }
	
	        
	        
	        
	        int userId = user.getUserId();
	        
		String notificationTitle = request.getParameter("notificationTitle");
		String notificationType = request.getParameter("notificationType");
		String notificationContent = request.getParameter("notificationContent");
	
		
		
		ArrayList<String> addNoticeErrors = new ArrayList<>();

		
		if (notificationTitle == null || notificationTitle.trim().isEmpty()) {
			addNoticeErrors.add("notificationTitle is required.");
		    System.out.println("File not 1234443");
		}else if (!notificationTitle.matches("[a-zA-Z]+( [a-zA-Z]+)*")){
			addNoticeErrors.add("notificationTitle should be alpha.");
		}
		
		if (notificationType == null || notificationType.trim().isEmpty()) {
			addNoticeErrors.add("notificationType is required.");
		    System.out.println("File not 12341231443");
		}
		
		if (notificationContent == null || notificationContent.trim().isEmpty()) {
			addNoticeErrors.add("notificationContent is required.");
		    System.out.println("File not 123423123443");
		}

		if (addNoticeErrors.isEmpty()) {
	        AddNotice addNoticeDao;
	        
			try {
				addNoticeDao = new AddNotice();
				Notice notice = new Notice(notificationTitle, notificationType, notificationContent);
		        notice.setTitle(notificationTitle);
		        notice.setType(notificationType);
		        notice.setMessage(notificationContent);

		        int noticeId = addNoticeDao.addNotice(notice);

		  
		            boolean associationResult = addNoticeDao.addUserAssociation(userId, noticeId);

		            if (associationResult) {

		            	request.setAttribute("successMessage", "Notice successfully added.");
		       
		            } else {
		     
		                request.setAttribute("errors", "Failed to associate notice with user.");
		                
		            }
		            
		            request.getRequestDispatcher("/Pages/AdminPages/add-notice.jsp").forward(request, response);      
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.setAttribute("addNoticeErrors", addNoticeErrors);
			 request.getRequestDispatcher("/Pages/AdminPages/add-notice.jsp").forward(request, response);      
		}
		
	        


	}

}
