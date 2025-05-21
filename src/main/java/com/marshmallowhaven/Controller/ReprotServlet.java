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

import com.marshmallowhaven.DAO.ReportDAO;
import com.marshmallowhaven.DAO.RoomDetailsDAO;
import com.marshmallowhaven.Model.BookingStat;
import com.marshmallowhaven.Model.Room;

/**
 * Servlet implementation class ReprotServlet
 */
@WebServlet("/ReprotServlet")
public class ReprotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ReportDAO reportDAO = new ReportDAO();

			  ArrayList<BookingStat> dailyBookingStats ; 
			  
			  
			  
			  HashMap<String, Integer> roomTypeBookingCounts = reportDAO.getRoomTypeBookingCounts();
			     request.setAttribute("roomTypeBookingCounts", roomTypeBookingCounts);
			  
			  
	
			  dailyBookingStats = reportDAO.getDailyBookingStatsByRoomType();
			  
		        request.setAttribute("dailyBookingStats", dailyBookingStats);
		        request.getRequestDispatcher("/Pages/AdminPages/report.jsp").forward(request, response);
			  
			  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
