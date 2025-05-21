<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <title>Student Dashboard-Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/student_dashboard.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <Style>
    .profile-btn {
	  margin-top: 20px;
	  display: flex;
	  flex-direction: column; /* Stack items vertically */
	  align-items: center;    /* Center horizontally */
	  gap: 20px;  
  }
  
  .profile-pic-wrapper {
  position: relative;
  display: inline-block;
}

.profile-pic {
  display: block;
  border-radius: 50%;
  width: 100px; /* adjust size as needed */
  height: 100px;
  object-fit: cover;
}

.update-btn {
  position: absolute;
  bottom: 0;
  right: 0;
  background-color: #1a3c5a;
  color: white;
  border: none;
  border-radius: 50%;
  width: 24px;
  height: 24px;
  font-size: 18px;
  line-height: 24px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0;
}

.update-pic a{
  text-decoration: none;
}

</Style>
</head>
<body>
  <!-- Header -->
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>
  <!-- Main Content -->
  <section class="main-content">
    <div class="container">
      <h1 class="section-title">Student Dashboard</h1>
      
<div class="dashboard-container">
    <div class="profile-section">
    
     <c:if test="${empty user}">

      <c:redirect url="/UserProfileServlet" />
     
    </c:if>
    
        <c:forEach var="user" items="${user}">
    <!-- Dynamically set the profile image URL -->
		<div class="profile-pic-wrapper">
		  <img src="${imgURL}${user.profileImageUrl}" alt="Profile" class="profile-pic">
		  
		  <form class ="update-pic">
		    <a href="${pageContext.request.contextPath}/Pages/UserPages/update-profile-img.jsp" class="update-btn"> <i class="fas fa-plus pulse-plus"></i></a>
		  </form>

		</div>
    <h2>${user.fullName}</h2>

    <div class="profile-details">
        <p><span>Gender:</span> <span>${user.gender}</span></p>
        <p><span>Email:</span> <span>${user.email}</span></p>
        <p><span>Contact:</span> <span>${user.contactNumber}</span></p>
        <p><span>Address:</span> <span>${user.address}</span></p>
        <p><span>Date of Birth:</span> 
            <span>
               <fmt:formatDate value="${user.dateOfBirth}" pattern="MMMM dd, yyyy" />
            </span>
        </p>
    </div>
       </c:forEach>  
      	<div class="profile-btn">
		  <form action="${pageContext.request.contextPath}/UserUpdateProfileServlet" method="get">
		      <button type="submit" class="btn update-profile-btn">Update Profile</button>

		  </form>
		  <form >
		    <a href="${pageContext.request.contextPath}/Pages/UserPages/update-password.jsp" class="btn update-profile-btn">Change Password</a>
		  </form>
		</div>

        </div>
        
        <div class="status-section">
           <c:if test="${not empty applicationRecentone}">
            <c:forEach var="recentOne" items="${applicationRecentone}">
          <h3>Recent Application Details</h3>

          <div class="room-preview" title="Click for more details">
			  <p><strong>Room Number:</strong> ${recentOne.roomNumber}</p>
			  <p><strong>Room Type:</strong> ${recentOne.roomType}</p>
			  <p><strong>Floor:</strong> ${recentOne.roomfloor}</p>
			  <p><strong>Expected CheckIn Date:</strong> ${recentOne.expectedCheckIn}</p>
			  <p><strong>Duration Of Stay:</strong> ${recentOne.durationOfStay}</p>
			  <p><strong>Status:</strong> ${recentOne.status}</p>
			  <p><strong>Monthly Fee:</strong> ${recentOne.monthlyFee}</p>
          </div>
          </c:forEach>
          </c:if>
          
         <c:if test="${not empty applicationExceptFirst}">
         <h3 style="margin-top: 20px;">All Application Details</h3>
         <c:forEach var="ExceptFirst" items="${applicationExceptFirst}">
          
          <div class="room-preview" title="Click for more details">
			  <p><strong>Room Number:</strong> ${ExceptFirst.roomNumber}</p>
			  <p><strong>Room Type:</strong> ${ExceptFirst.roomType}</p>
			  <p><strong>Floor:</strong> ${ExceptFirst.roomfloor}</p>
			  <p><strong>Expected CheckIn Date:</strong> ${ExceptFirst.expectedCheckIn}</p>
			  <p><strong>Duration Of Stay:</strong> ${ExceptFirst.durationOfStay}</p>
			  <p><strong>Status:</strong> ${ExceptFirst.status}</p>
			  <p><strong>Monthly Fee:</strong> ${ExceptFirst.monthlyFee}</p>
          </div>
          </c:forEach>
         </c:if> 
          
          <div class="notifications">
            <h3>Notice</h3>
            
            <div class="notification notification-maintenance">
              <h4>Scheduled Maintenance</h4>
              <p>Water supply will be disrupted on Sunday, 10th April from 9 AM to 12 PM for maintenance work.</p>
              <small>Posted: 5th April, 2025</small>
            </div>
            
            <div class="notification notification-rule">
              <h4>New Policy Update</h4>
              <p>Updated guest policy: All guests must register at the reception before entering the hostel premises.</p>
              <small>Posted: 1st April, 2025</small>
            </div>
            
            <div class="notification">
              <h4>Fee Payment Reminder</h4>
              <p>Monthly fees for May are due by April 30th. Please make payments on time to avoid late fees.</p>
              <small>Posted: 20th April, 2025</small>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
  <!-- Footer -->
  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
</body>
</html>