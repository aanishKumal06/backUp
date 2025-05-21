package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.UpdateApplicationDAO;

/**
 * Servlet implementation class ApprovedApplicationServlet
 */
@WebServlet("/ApprovedApplicationServlet")
public class ApprovedApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String applicationIdStr = request.getParameter("application_id");
		String status = "approved";
	

		System.out.println(applicationIdStr);
		int applicationId = Integer.parseInt(applicationIdStr);

		 try {

		            UpdateApplicationDAO appDao = new UpdateApplicationDAO();

		            boolean isApplicationUpdated = appDao.updateApplicationStatus(applicationId, status);

		            if (isApplicationUpdated) {
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
