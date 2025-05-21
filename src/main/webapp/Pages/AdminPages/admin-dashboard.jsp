<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<title>Hostel Admin Dashboard</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

	
</head>
<body>


  <div class="hostel-admin">
   <c:set var="activePage" value="dashboard" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>

      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>
       
      <div class="page-header">
        <h1>Dashboard</h1>
      </div>
      
      <c:if test="${empty roomStatusCounts}">
        <c:redirect url="/AdminDashboardMangementServlet" />
    </c:if>


     <c:set var="application" value="${applicationStatusCounts}" />
     <c:set var="conmplaints" value="${conmplaintsStatusCounts}" />
     <c:set var="room" value="${roomStatusCounts}" />
    
	<c:set var="pendingApplications" value="${not empty application.pending ? application.pending : 0}" />
	<c:set var="maintenanceComplaint" value="${not empty conmplaints.Maintenance ? conmplaints.Maintenance : 0}" />
    <c:set var="vacantRoom" value="${not empty room.vacant ? room.vacant : 0}" />

      <!-- Dashboard Stats -->
      <div class="dashboard-stats">
        <div class="stat-card">
          <div class="stat-icon blue">
            <i class="fas fa-user"></i>
          </div>
          <div class="stat-info">
            <h3>Total User</h3>
            <p class="stat-number">${totalusers}</p>
          </div>
        </div>
        <div class="stat-card">
          <div class="stat-icon amber">
            <i class="fas fa-clipboard-check"></i>
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
            <h3>Vacant Rooms</h3>
            <p class="stat-number"> ${vacantRoom}</p>
        </div>
    </div>

        <div class="stat-card">
          <div class="stat-icon amber">
              <i class="fas fa-tools"></i>
          </div>
          <div class="stat-info">
            <h3>Maintenance Complaint</h3>
            <p class="stat-number">${maintenanceComplaint}</p>
          </div>
        </div>
      </div>

      <!-- Quick Actions -->
      <div class="section-title">
        <h2>Quick Actions</h2>
      </div>
      <div class="quick-actions">
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/application-management.jsp" class="action-card">
          <i class="fas fa-clipboard-list"></i>
          <h3>View Applications</h3>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp" class="action-card">
          <i class="fas fa-bed"></i>
          <h3>Manage Rooms</h3>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/notice.jsp" class="action-card">
          <i class="fas fa-bell"></i>
          <h3>Post Notice</h3>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/complaint-management.jsp" class="action-card">
          <i class="fas fa-exclamation-circle"></i>
          <h3>View Complaints</h3>
        </a>
      </div>

      <!-- Recent Applications -->
      <div class="section-title">
        <h2>Recent Applications</h2>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/application-management.jsp" class="view-all">View All</a>
      </div>
      <div class="table-container">
        <table class="admin-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Gender</th>
              <th>Contact</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>



		<tbody>
		  <c:forEach var="app" items="${applicationList}">
		    <tr>
		      <td>${app.fullName}</td>
		      <td>${app.gender}</td>
		      <td>${app.contactNumber}

		      </td>
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
		       	 <input type="text" name="application_id" value="${app.applicationId}" style="display:none">
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