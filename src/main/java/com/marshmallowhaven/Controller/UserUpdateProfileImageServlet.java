package com.marshmallowhaven.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.marshmallowhaven.DAO.UpdateUserProfileImage;
import com.marshmallowhaven.Model.User;

/**
 * Servlet implementation class UserUpdateProfileImage
 */
@WebServlet("/UserUpdateProfileImageServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UserUpdateProfileImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
	     User user = (User) session.getAttribute("currentUser");

	     if (user == null) {
	     	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
	         return;
	     }

	     int userId = user.getUserId();


	     
		ArrayList<String> updateImageError = new ArrayList<>();
		
	     Part image = request.getPart("photo");
	     String fileName = image.getSubmittedFileName();
	     
	     
	     if (fileName == null || fileName.isEmpty()) {
			    updateImageError.add("Profile image is required.");
			} else {
			    // Validate file extension
			    String fileNameLower = fileName.toLowerCase();
			    if (!(fileNameLower.endsWith(".jpg") || fileNameLower.endsWith(".png") || fileNameLower.endsWith(".jpeg"))) {
			    	updateImageError.add("Only JPG, JPEG, or PNG image formats are allowed.");
			    }
			} 
	     
	     
	 	if (updateImageError.isEmpty()) {
	 		
	 		
	 		String storePath = request.getServletContext().getRealPath(""); //get path of deployment folder
			String filePath = "photos"+File.separator+fileName;   //prepared file path like photos\fileName.jpg
			System.out.println(storePath);  
			System.out.println(filePath);  

			try {
			    image.write(storePath+File.separator +filePath); //upload file to selected path
				System.out.println("File uploaded");
	     		
				UpdateUserProfileImage updateUserProfileImage = new UpdateUserProfileImage();
				
				boolean isUpdated = updateUserProfileImage.updateImage(fileName, userId);
				
				  if (isUpdated) {
			        	 request.setAttribute("updateMessage", "Profile image successfully updated.");
			        	 request.getRequestDispatcher("/Pages/UserPages/update-profile-img.jsp").forward(request, response);
			            
			        } else {
			            request.setAttribute("updateError", "Update profile image failed. Please try again.");
			            request.getRequestDispatcher("/Pages/UserPages/update-profile-img.jsp").forward(request, response);
			        }
				
					
			} catch (Exception e) {
				
				System.out.println("File not uploaded");
				request.setAttribute("updateError", "Update profile image failed. Please try again.");
	            request.getRequestDispatcher("/Pages/UserPages/update-profile-img.jsp").forward(request, response);
			}
			
			
			
	 		
	 	}else {
	 		request.setAttribute("updateError", "Update profile image failed. Please try again.");
            request.getRequestDispatcher("/Pages/UserPages/update-profile-img.jsp").forward(request, response);
	 		
	 	}
			
			

	}

}
