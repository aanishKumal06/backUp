package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marshmallowhaven.DAO.NoticeDetailsDAO;
import com.marshmallowhaven.Model.Notice;

/**
 * Servlet implementation class AdminNoticeDetails
 */
@WebServlet("/AdminNoticeDetails")
public class AdminNoticeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDetailsDAO noticeDAO;
		try {
			noticeDAO = new NoticeDetailsDAO();
			ArrayList<Notice> notices = noticeDAO.getAllNotices(); // From the method you wrote earlier

		    request.setAttribute("notices", notices); // Send data to JSP
		    request.getRequestDispatcher("/Pages/AdminPages/notice.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Replace with your DAO access, or inject it
	    
	}

	

}
