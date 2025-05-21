<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Room Management - Hostel Admin</title>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>
  
  .add-body {
  background-color: #ffffff;         /* white background */
  padding: 1rem;                     /* inner spacing */
  border-radius: 10px;               /* rounded corners */
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15); /* soft shadow */
  max-width: 1400px;                  /* optional: limit width */
  margin: auto;                      /* center horizontally */
}

.error-list {
  color: red;
  padding-left: 0;
  margin-left: 0;
  list-style-position: inside;
}

.successMessage-list {
  color: green;
  padding-left: 0;
  margin-left: 0;
  list-style-position: inside;
}

  
  </style>
  

</head>
<div class="hostel-admin">
    <!-- Sidebar -->
          <c:set var="activePage" value="reports" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>

      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>




      <div class="page-header">
        <h1>Report </h1>
      </div>
      
      
            
      <c:if test="${empty roomTypeBookingCounts}">
        <c:redirect url="/ReprotServlet" />
    </c:if>



     <c:set var="count" value="${roomTypeBookingCounts}" />

		<c:set var="total" value="${empty count['Single AC'] ? 0 : count['Single AC']}" />
		<c:set var="security" value="${empty count['Single Non-AC'] ? 0 : count['Single Non-AC']}" />
		<c:set var="maintenance" value="${empty count['Double AC'] ? 0 : count['Double AC']}" />
		<c:set var="others" value="${empty count['Double Non-AC'] ? 0 : count['Double Non-AC']}" />

    
    
    
      <!-- Complaints Summary Stats -->
      <div class="dashboard-stats">
        <div class="stat-card">
          <div class="stat-icon blue">
            <i class="fas fa-exclamation-circle"></i>
          </div>
          <div class="stat-info">
            <h3>Single AC</h3>
            <p class="stat-number">${total}</p>
          </div>
        </div>
        <div class="stat-card">
        <div class="stat-icon amber">
            <i class="fas fa-tools"></i>
        </div>
          <div class="stat-info">
            <h3>Single Non-AC</h3>
            <p class="stat-number">${security}</p>
          </div>
        </div>
        <div class="stat-card">
			<div class="stat-icon purple">
			  <i class="fas fa-shield-alt"></i>
			</div>

          <div class="stat-info">
            <h3>Double Ac</h3>
            <p class="stat-number">${maintenance}</p>
          </div>
        </div>
        <div class="stat-card">
          <div class="stat-icon green">
				<i class="fas fa-puzzle-piece"></i>
          </div>
          <div class="stat-info">
            <h3>Double Non-AC</h3>
            <p class="stat-number">${others}</p>
          </div>
        </div>
      </div>

      <!-- Complaints Table -->
      <div class="table-container">
        <table class="admin-table">
          <thead>
            <tr>
              <th>Room Type</th>
              <th>Check Date</th>
              <th>Count</th>

            </tr>
          </thead>
		   <tbody>
		    <c:forEach var="bookstats" items="${dailyBookingStats}">
		      <tr>
		        <td>${bookstats.roomType}</td>
		      
		
		        <td>
		          <fmt:formatDate value="${bookstats.bookingDate}" pattern="MMMM dd, yyyy"/>
		        </td>
		        
		          <td>${bookstats.totalBookings}</td>
		      
		      </tr>
		    </c:forEach>
		  </tbody>
        </table>
      </div>

      </div>
      </div>



  
  <!-- IMPORTANT: DO NOT REMOVE THIS SCRIPT TAG OR THIS VERY COMMENT! -->
  <script src="https://cdn.gpteng.co/gptengineer.js" type="module"></script>
</html>