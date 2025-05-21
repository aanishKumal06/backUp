<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.util.ArrayList" %>
<%@ page import="com.marshmallowhaven.Model.Room" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Rooms-Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/global_for_client.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/rooms.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>

.main-content {
    padding: 3rem 0;
  }
  
  .section-title {
    font-size: 1.8rem;
    color: #1a3c5a;
    margin-bottom: 1.5rem;
    border-bottom: 2px solid #e6f2ff;
    padding-bottom: 0.5rem;
  }
  
  .form-container {
    background-color: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  }
  
  .form-group {
    margin-bottom: 20px;
  }
  
  .form-group label {
    display: block;
    margin-bottom: 8px;
    font-weight: 500;
    color: #333;
  }
  
  .form-control {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 1rem;
  }
  
  .form-control:focus {
    outline: none;
    border-color: #1a3c5a;
    box-shadow: 0 0 0 2px rgba(26, 60, 90, 0.2);
  }
  
  .form-row {
    display: flex;
    gap: 20px;
  }
  
  .form-row .form-group {
    flex: 1;
  }
  
  .form-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;

  }  
  
  .btn {
    display: inline-block;
    background-color: #1a3c5a;
    color: white;
    padding: 0.8rem 1.5rem;
    border-radius: 4px;
    text-decoration: none;
    font-weight: 500;
    transition: background-color 0.3s;
    border: none;
    cursor: pointer;
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
  
    .btn:hover {
    background-color: #2c5a85;
  }
  
  
 .vacancy {
   display: inline-block;
   padding: 5px 10px;
   border-radius: 4px;
   font-weight: bold;
 }
 
  .maintenance {
	background-color: #fef3c7; 
 }
 
 .vacant {
   background-color: #d4edda;
 }
 
 .occupied {
   background-color: #f8d7da;
 }
 
  .room-link {
    text-decoration: none;
    color: inherit;
    display: block;
}
 
  
</style>
</head>
<body>
  <!-- Header -->
  <c:set var="activePage" value="rooms" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>


  <!-- Main Content -->
  <section class="main-content">
    <div class="container">
      <h1 class="section-title">Room </h1>
      
      <div class="room-filters">
        <form  action="${pageContext.request.contextPath}/RoomDetailsServelt" method="get">
  <div class="form-row">
    
    <!-- Room Type Filter -->
    <div class="form-group">
      <label for="room-type">Room Type</label>
      <select id="room-type" name="roomType" class="form-control">
        <option value="all" <%= "all".equals(request.getAttribute("selectedRoomType")) ? "selected" : "" %>>All Types</option>
        <option value="Single AC" <%= "Single AC".equals(request.getAttribute("selectedRoomType")) ? "selected" : "" %>>Single AC</option>
        <option value="Single Non-AC" <%= "Single Non-AC".equals(request.getAttribute("selectedRoomType")) ? "selected" : "" %>>Single Non-AC</option>
        <option value="Double AC" <%= "Double AC".equals(request.getAttribute("selectedRoomType")) ? "selected" : "" %>>Double AC</option>
        <option value="Double Non-AC" <%= "Double Non-AC".equals(request.getAttribute("selectedRoomType")) ? "selected" : "" %>>Double Non-AC</option>
      </select>
    </div>

    <!-- Price Filter -->
    <div class="form-group">
      <label for="price">Price Range</label>
      <select id="price" name="priceRange" class="form-control">
        <option value="all" <%= "all".equals(request.getAttribute("selectedPriceRange")) ? "selected" : "" %>>All</option>
        <option value="high" <%= "high".equals(request.getAttribute("selectedPriceRange")) ? "selected" : "" %>>High</option>
        <option value="low" <%= "low".equals(request.getAttribute("selectedPriceRange")) ? "selected" : "" %>>Low</option>
      </select>
    </div>

    <button type="submit" class="btn btn-primary" style="padding: 6px 12px; font-size: 16px; height: 40px; margin-top: 35px;">Apply Filters</button>

  </div>
</form>


      </div>
      
      <div class="room-list">
               <c:if test="${empty rooms}">
           			<c:redirect url="/RoomDetailsServelt" />
       			 </c:if>

<c:forEach var="room" items="${rooms}">
    <div class="room-card">

			 <form action="${pageContext.request.contextPath}/RoomDetailsByIdServlet" method="get" style="all: unset;">
			    <input type="hidden" name="roomId" value="${room.roomId}" />
			    <button type="submit" class="room-link" style="all: unset; cursor: pointer;">
			        <img src="${imgURL}${room.imageUrl}" alt="${room.roomType}" class="room-image">
			        <div class="room-details">
			            <h3 class="room-type">${room.roomType}</h3>
			            <div class="room-specs">
			                <span><strong>Room Number:</strong> ${room.roomNumber}</span>
			                <span class="vacancy vacant">
			                    ${room.roomStatus}
			                </span>
			            </div>
			
			            <p><strong>Monthly Fee:</strong> $${room.monthlyFee}</p>
			
			            <!-- Facilities -->
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
  
  <!-- Footer -->
  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
</body>
</html>