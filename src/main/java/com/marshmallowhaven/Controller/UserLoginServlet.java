package com.marshmallowhaven.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marshmallowhaven.DAO.LoginDAO;
import com.marshmallowhaven.Model.User;
import com.marshmallowhaven.util.EncryptDecrypt;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String encryptPassword = EncryptDecrypt.encrypt(password);
        System.out.println(encryptPassword);



        try {
            LoginDAO loginDao = new LoginDAO();
            User user = loginDao.login(username, encryptPassword);
            
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                

                String role = user.getRole();
                System.out.println(role);

                if ("admin".equalsIgnoreCase(role) || "staff".equalsIgnoreCase(role)) {
                    response.sendRedirect(request.getContextPath() +"/Pages/AdminPages/admin-dashboard.jsp");
                } else if ("customer".equalsIgnoreCase(role)) {
                	System.out.println(role);
                    response.sendRedirect(request.getContextPath() +"/Pages/UserPages/home.jsp");
                }
            } else {
                // Invalid login attempt
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // System error handling
    
            request.getRequestDispatcher("/Pages/error.jsp").forward(request, response);
        }
    }


	

}
