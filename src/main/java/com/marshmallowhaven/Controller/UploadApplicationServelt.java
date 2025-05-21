package com.marshmallowhaven.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.marshmallowhaven.DAO.AddApplicationDAO;
import com.marshmallowhaven.DAO.CheckEmergencyContactsDAO;
import com.marshmallowhaven.Model.Application;
import com.marshmallowhaven.Model.Room;
import com.marshmallowhaven.Model.User;

@WebServlet("/UploadApplicationServelt")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class UploadApplicationServelt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    	
 
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
        	request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }

        
        
        
        int userId = user.getUserId();
        String roomID = request.getParameter("roomId");
        int roomIdInt = Integer.parseInt(roomID);
        System.out.println(roomIdInt);
        AddApplicationDAO appDAO ;
        CheckEmergencyContactsDAO checkEmergencyContactsDAO;
        
        
		
        
        
        // now check them:
      
    
            System.out.println("User has a cancelled application.");
  
        // Personal Information
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("dob");
        String address = request.getParameter("address");

        // Emergency Contact
        String emergencyName = request.getParameter("emergency-name");
        String emergencyRelationship = request.getParameter("relationship");
        String emergencyPhone = request.getParameter("emergency-phone");
        String emergencyEmail = request.getParameter("emergency-email");

        // Room Preferences
        String durationOfStay = request.getParameter("duration");
        String expectedCheckInStr = request.getParameter("check-in");
        String specialRequests = request.getParameter("special-requests");

        // File Upload
        Part image = request.getPart("photo");
        String fileName = image.getSubmittedFileName();

        ArrayList<String> applicationError = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Validations
        validateFields(applicationError, fullName, phone,  birthday, address,
                emergencyName, emergencyRelationship, emergencyPhone, emergencyEmail,
                expectedCheckInStr, durationOfStay, formatter);

        if (!applicationError.isEmpty()) {
            request.setAttribute("applicationError", applicationError);
            request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);
            return;
        }

        try {
            // Save uploaded photo
            String storePath = request.getServletContext().getRealPath("");
            String filePath = "photos" + File.separator + fileName;
            image.write(storePath + File.separator + filePath);

            LocalDate checkInDate = LocalDate.parse(expectedCheckInStr, formatter);
            Date expectedCheckIn = Date.valueOf(checkInDate);

            Application application = new Application(durationOfStay, expectedCheckIn, specialRequests, fileName);
          
            appDAO = new AddApplicationDAO();
            int applicationId = appDAO.addApplication(application);

            
            appDAO.addApplicationUserRoom(applicationId,userId , roomIdInt);

            // Update room status
            Room room = appDAO.getRoomStatusById(roomIdInt);
            if (room != null) {
                updateRoomStatus(appDAO, roomIdInt, room);
            }

            checkEmergencyContactsDAO = new CheckEmergencyContactsDAO();
            
            Integer isEmergencyContact = checkEmergencyContactsDAO.getUserId(userId);
            // Emergency contact
            

            if (isEmergencyContact == null) {
            	int emergencyId = appDAO.addEmergencyContact(emergencyName, emergencyRelationship, emergencyPhone, emergencyEmail);
                System.out.println(emergencyId);
                appDAO.addUserAssociation(userId,emergencyId);
            }
            // Update user profile
            user.setFullName(fullName);
            user.setDateOfBirth(Date.valueOf(birthday));
            user.setContactNumber(phone);
            user.setAddress(address);
            user.setProfileImageUrl(fileName);
            user.setUserId(userId);
            appDAO.updateUserByUsername(user);
            
            
            
            
            request.setAttribute("infoMessage", "Application submitted successfully!");

            request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            applicationError.add("Internal error occurred. Please contact support.");
            forwardWithErrors(request, response, applicationError);
        }
       
    }

    private void validateFields(ArrayList<String> errors, String fullName, 
                                String phone, String birthday, String address,
                                String emergencyName, String emergencyRelationship,
                                String emergencyPhone, String emergencyEmail,
                                String checkInStr, String duration, DateTimeFormatter formatter) {

        if (fullName == null || !fullName.trim().matches("^[A-Za-z]+(?: [A-Za-z]+)+$")) {
            errors.add("Full name: Requires at least first and last name (letters only).");
        }
       
        if (phone == null || !phone.matches("^\\d{10}$")) {
            errors.add("Phone number must be exactly 10 digits.");
        }
        
        if (birthday == null || birthday.isEmpty()) {
            errors.add("Birthday is required.");
        } else {
            try {
                LocalDate birthDate = LocalDate.parse(birthday, formatter);
                if (birthDate.isAfter(LocalDate.now())) {
                    errors.add("Birthday cannot be in the future.");
                }
            } catch (DateTimeParseException e) {
                errors.add("Invalid birthday format. Use YYYY-MM-DD.");
            }
        }
        if (address == null || address.trim().isEmpty()) {
            errors.add("Address is required.");
        }
        if (emergencyName == null || !emergencyName.matches("^[A-Za-z ]+$")) {
            errors.add("Emergency contact name must contain only letters.");
        }
        if (emergencyRelationship == null || emergencyRelationship.trim().isEmpty()) {
            errors.add("Emergency relationship is required.");
        }
        if (emergencyPhone == null || !emergencyPhone.matches("^\\d{10}$")) {
            errors.add("Emergency contact phone must be 10 digits.");
        }
        if (emergencyEmail != null && !emergencyEmail.trim().isEmpty() &&
                !emergencyEmail.matches("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
            errors.add("Invalid emergency email format.");
        }
        if (checkInStr == null || checkInStr.isEmpty()) {
            errors.add("Check-in date is required.");
        } else {
            try {
                LocalDate checkInDate = LocalDate.parse(checkInStr, formatter);
                if (!checkInDate.isAfter(LocalDate.now())) {
                    errors.add("Check-in date must be in the future.");
                }
            } catch (DateTimeParseException e) {
                errors.add("Invalid check-in date format. Use YYYY-MM-DD.");
            }
        }
        if (duration == null || duration.trim().isEmpty()) {
            errors.add("Duration of stay is required.");
        }
    }

    private void updateRoomStatus(AddApplicationDAO dao, int roomId, Room room) throws SQLException {
        int occupancy = room.getCurrentOccupancy();
        boolean available;
        String status;

        String type = room.getRoomType();
        if ("Single AC".equalsIgnoreCase(type) || "Single Non-AC".equalsIgnoreCase(type)) {
            occupancy = 1;
            available = false;
            status = "occupied";
        } else if (("Double AC".equalsIgnoreCase(type) || "Double Non-AC".equalsIgnoreCase(type)) && occupancy == 0) {
            occupancy = 1;
            available = true;
            status = "vacant";
        } else {
            occupancy = 2;
            available = false;
            status = "occupied";
        }

        dao.updateRoomStatusById(roomId, occupancy, available, status);
    }

    private void forwardWithErrors(HttpServletRequest request, HttpServletResponse response, ArrayList<String> errors)
        throws ServletException, IOException {
        request.setAttribute("errors", errors);
        request.getRequestDispatcher("/Pages/UserPages/application.jsp").forward(request, response);
    }
}
