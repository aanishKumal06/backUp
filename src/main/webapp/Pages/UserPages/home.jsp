<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.http.HttpSession" %>
        <%@ page import="java.util.ArrayList" %>
<%@ page import="com.marshmallowhaven.Model.Room" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/global_for_client.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/rooms.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/home.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
 
 .vacancy {
   display: inline-block;
   padding: 5px 10px;
   border-radius: 4px;
   font-weight: bold;
 }
 
  .vacant {
   background-color: #d4edda;
 }
 
 .room-link a {
    text-decoration: none;
    color: inherit;
    display: block;
}

 
 .room-link {
    text-decoration: none;
    color: inherit;
    display: block;
    
    
  
    
}
    .applybtn {
    display: inline-block;
    background-color: #1a3c5a;
    width: 100%;
    color: white;
    padding: 0.8rem 1.5rem;
    border-radius: 4px;
    text-decoration: none;
    font-weight: 500;
    transition: background-color 0.3s;
    border: none;
    cursor: pointer;
  }
  
  .applybtn:hover {
    background-color: #2c5a85;
  }
</style>

</head>

<body>

<!-- Header -->
<c:set var="activePage" value="home" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>
<!-- Hero Section -->
<section class="hero">
  <div class="container">
    <h1>Welcome to Marshmallow Haven</h1>
    <p>Your home away from home. We provide comfortable, safe, and affordable accommodation for students.</p>
    <a href="${pageContext.request.contextPath}/Pages/UserPages/rooms.jsp" class="btn">View Rooms</a>
  </div>
</section>

<!-- Room Section -->
<section class="main-content">
  <div class="container">
    <div class="room-list">
			   <c:if test="${empty expensiveRooms}">
			    <c:redirect url="/TopExpensiveRoomServelt" />
			</c:if>
			
			<c:forEach var="room" items="${expensiveRooms}">
			    <div class="room-card">

			  			 <form action="${pageContext.request.contextPath}/RoomDetailsByIdServlet" method="get" style="all: unset;">
			    <input type="hidden" name="roomId" value="${room.roomId}" />
			    <button type="submit" class="room-link" style="all: unset; cursor: pointer;">
			        <img src="${imgURL}${room.imageUrl}" alt="${room.roomType}" class="room-image">
			         <div class="room-details">
			            <h3 class="room-type">${room.roomType}</h3>
			            <div class="room-specs">
			                <span><strong>Room Number:</strong> ${room.roomNumber}</span>
			                 <span class="vacancy vacant">vacant</span>
			            </div>
			            <p><strong>Monthly Fee:</strong> $${room.monthlyFee}</p>
			
			            <!-- Display facilities -->
			            <div class="room-facilities">
			                <c:forEach var="facility" items="${fn:split(room.roomFacilities, ',')}">
			                    <div class="facility">${fn:trim(facility)}</div>
			                </c:forEach>
			            </div>
			
			      		 </div>
			         
			      			    </button>
			</form>

           <form action="${pageContext.request.contextPath}/ApplicationEligibilityServlet" method="get" style="text-align: center; margin: 0 auto;">
			  <input type="hidden" name="roomId" value="${room.roomId}">
			  <button  type="submit" class="applybtn btn-primary">Apply Now</button>
			</form>
			    </div>
			</c:forEach>


    </div>
  </div>
</section>

<!-- Why Choose Us Section -->
<section class="main-content">
  <div class="container">

    <h2 class="section-title">Why Choose Marshmallow Haven?</h2>
    <div class="card-container">
      <div class="card">
        <div class="card-header">Safe & Secure</div>
        <div class="card-body">
          <p>24/7 security, CCTV surveillance, and secure access control to ensure your safety at all times.</p>
        </div>
      </div>

      <div class="card">
        <div class="card-header">Modern Facilities</div>
        <div class="card-body">
          <p>High-speed WiFi, study rooms, common areas, and fully equipped kitchens for your convenience.</p>
        </div>
      </div>

      <div class="card">
        <div class="card-header">Prime Location</div>
        <div class="card-body">
          <p>Located just 5 minutes from campus with easy access to public transportation, shopping, and dining.</p>
        </div>
      </div>
    </div>

    <h2 class="section-title">About Our Hostel Management System</h2>
    <p>Our online hostel management system makes it easy for students to:</p>

    <div class="card-container">
      <div class="card">
        <div class="card-header">View Room Details</div>
        <div class="card-body">
          <p>Browse through available rooms, check occupancy status, and view room features and amenities.</p>
        </div>
        <div class="card-footer">
          <a href="rooms.jsp" class="btn">View Rooms</a>
        </div>
      </div>

      <div class="card">
        <div class="card-header">Check Fees & Policies</div>
        <div class="card-body">
          <p>Access information about hostel fees, payment schedules, and understand our hostel rules and policies.</p>
        </div>
        <div class="card-footer">
          <a href="hostel-rules.jsp" class="btn">Learn More</a>
        </div>
      </div>

      <div class="card">
        <div class="card-header">Easy Application</div>
        <div class="card-body">
          <p>Apply online for hostel accommodation, track your application status, and receive important notifications.</p>
        </div>
        <div class="card-footer">
          <a href="application.jsp" class="btn">Apply Now</a>
        </div>
      </div>
    </div>

  </div>
</section>

<!-- Footer -->
  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
</body>
</html>
