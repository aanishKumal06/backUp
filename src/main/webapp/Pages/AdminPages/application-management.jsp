<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        
    
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
<body>
 
 <div class="hostel-admin">
   <c:set var="activePage" value="applications" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>



      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>


 <div class="page-header">

       
      </div>
  <!-- Add Room Modal -->
		
	      <div class="page-header">
        <h1> Applications Management</h1>
        <div class="actions">
          <div class="filter-group">
           <form action="${pageContext.request.contextPath}/ApplicationDetailsServlet" method="get">
		  <label for="status-filter">Filter by:</label>
	
			<select id="status-filter" class="form-select" name="applicationStatus">
			  <option value="all" <%= "all".equals(request.getAttribute("selectedApplicationType")) ? "selected" : "" %>>All Applications</option>
			  <option value="pending" <%= "pending".equals(request.getAttribute("selectedApplicationType")) ? "selected" : "" %>>Pending</option>
			  <option value="approved" <%= "approved".equals(request.getAttribute("selectedApplicationType")) ? "selected" : "" %>>Approved</option>
			  <option value="rejected" <%= "rejected".equals(request.getAttribute("selectedApplicationType")) ? "selected" : "" %>>Rejected</option>
			  <option value="checkout" <%= "checkout".equals(request.getAttribute("selectedApplicationType")) ? "selected" : "" %>>Checkout</option>
			</select>

		  <button type="submit" class="btn btn-primary">Apply</button>
		</form>
          </div>
        </div>
      </div>
      
            <c:if test="${empty applicationStatusCounts}">
        <c:redirect url="/ApplicationDetailsServlet" />
    </c:if>


     <c:set var="application" value="${applicationStatusCounts}" />
     
     <c:set var="allApplications" value="${not empty application.Total ? application.Total : 0}" />
     <c:set var="pendingApplications" value="${not empty application.pending ? application.pending : 0}" />
     <c:set var="approvedApplications" value="${not empty application.approved ? application.approved : 0}" />
     <c:set var="rejectedApplications" value="${not empty application.rejected ? application.rejected : 0}" />
     <c:set var="checkoutApplications" value="${not empty application.checkout ? application.checkout : 0}" />
     
	  <div class="dashboard-stats">
	  <div class="stat-card">
	    <div class="stat-icon blue">
	      <i class="fas fa-layer-group"></i>
	    </div>
	    <div class="stat-info">
	      <h3>All Applications</h3>
	      <p class="stat-number">${allApplications}</p>
	    </div>
	  </div>
	
	  <div class="stat-card">
	    <div class="stat-icon amber">
	      <i class="fas fa-hourglass-half"></i>
	    </div>
	    <div class="stat-info">
	      <h3>Pending Applications</h3>
	      <p class="stat-number">${pendingApplications}</p>
	    </div>
	  </div>
	
	  <div class="stat-card">
	    <div class="stat-icon green">
	      <i class="fas fa-check-circle"></i>
	    </div>
	    <div class="stat-info">
	      <h3>Approved Applications</h3>
	      <p class="stat-number">${approvedApplications}</p>
	    </div>
	  </div>
	
	  <div class="stat-card">
	    <div class="stat-icon red">
	      <i class="fas fa-times-circle"></i>
	    </div>
	    <div class="stat-info">
	      <h3>Rejected Applications</h3>
	      <p class="stat-number">${rejectedApplications}</p>
	    </div>
	  </div>
	
	  <div class="stat-card">
	    <div class="stat-icon purple">
	      <i class="fas fa-sign-out-alt"></i>
	    </div>
	    <div class="stat-info">
	      <h3>Checkout</h3>
	      <p class="stat-number">${checkoutApplications}</p>
	    </div>
	  </div>
	</div>
      
      <!-- Applications Table -->
      <div class="table-container">
        <table class="admin-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Gender</th>
              <th>Email</th>
              <th>Contact</th>
              <th>Room Type</th>
              <th>Date Applied</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
         <tbody>
		  <c:forEach var="app" items="${applicationList}">
		    <tr>
		      <td>${app.fullName}</td>
		      <td>${app.gender}</td>
		      <td>${app.email}</td>
		      <td>${app.contactNumber}</td>
		      <td>${app.roomType}</td>
		      <td><fmt:formatDate value="${app.applicationCreatedAt}" pattern="MMMM dd, yyyy" /></td>
		      <td>
		        <c:choose>
		          <c:when test="${app.status eq 'pending'}">
		            <span class="badge badge-pending">Pending</span>
		          </c:when>
		          <c:when test="${app.status eq 'approved'}">
		            <span class="badge badge-approved">Approved</span>
		          </c:when>
		          <c:when test="${app.status eq 'rejected'}">
		            <span class="badge badge-rejected">Rejected</span>
		          </c:when> 
		          <c:when test="${app.status eq 'checkout'}">
		            <span class="badge badge-checkout">checkout</span>
		          </c:when>
		        </c:choose>
		      </td>
		      <td>
		        <form action="ApplicationDetailsByIdServlet" method="get">
		          <input type="hidden" name="application_user_id" value="${app.applicationUserId}">
  				  <input type="hidden" name="user_id" value="${app.userId}">
				  <button class="btn-icon" type="submit">
				    <i class="fas fa-eye"></i>
				  </button>
				</form>

		        <c:if test="${app.status eq 'pending'}">
		        
		         <form action="ApprovedApplicationServlet" method="post">
		       		 <input type="hidden" name="application_id" value="${app.applicationId}">
		          <button class="btn-icon success"><i class="fas fa-check"></i></button>
		        </form>

				<form action="RejectApplicationServlet" method="post" >
		       	 <input type="text" name="application_id" value="${app.applicationId}" style="display:none" >
	             <input type="text" name="roomNumber" value="${app.roomNumber}" style="display:none" />
			     <input type="text" name="roomType" value="${app.roomType}" style="display:none" />
			      <input type="text" name="currentOccupancy" value="${app.currentOccupancy}" style="display:none" />
		            <button class="btn-icon danger"><i class="fas fa-times"></i></button>
		        </form>

		        </c:if>
		      </td>
		    </tr>
		  </c:forEach>
		</tbody>


        </table>
      </div>

    </div>
  </div>
 

 
  

</body>
</html>