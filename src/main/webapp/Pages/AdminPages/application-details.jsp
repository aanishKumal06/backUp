<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Applications - Hostel Admin</title>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  
  <style >  
  .add-body {
  background-color: #ffffff;         /* white background */
  padding: 1rem;                     /* inner spacing */
  border-radius: 10px;               /* rounded corners */
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15); /* soft shadow */
  max-width: 1400px;                  /* optional: limit width */
  margin: auto;                      /* center horizontally */
}

.app-card p, .app-card h2 {
  margin-bottom: 10px;
}

.app-card h2 {
color: #1e3a8a;
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
        <h1>Application Details</h1>
      </div>
      

	    <div class="add-body">
	    

     <c:forEach var="app" items="${applicationList}">
		  <div class="applicant-header">
		    <img src="${imgURL}${app.photoUrl}" alt="Applicant Photo" class="applicant-photo">
		    <div class = "app-card">
		      <h2>${app.fullName}</h2>
		     
		      <p>Applied on:  <fmt:formatDate value="${app.applicationCreatedAt}" pattern="MMMM dd, yyyy" /></p>
		      <p>
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
		      </p>
		    </div>
		  </div>
		
		  <div class="detail-section">
		    <h4>Personal Information</h4>
		    <div class="details-grid">
		      <div class="detail-item"><span class="label">Full Name</span><span class="value">${app.fullName}</span></div>
		      <div class="detail-item"><span class="label">Gender</span><span class="value">${app.gender}</span></div>
		      <div class="detail-item"><span class="label">Date of Birth</span><span class="value"> <fmt:formatDate value="${app.dateOfBirth}" pattern="MMMM dd, yyyy" /></span></div>
		      <div class="detail-item"><span class="label">Email</span><span class="value">${app.email}</span></div>
		      <div class="detail-item"><span class="label">Phone</span><span class="value">${app.contactNumber}</span></div>
		      <div class="detail-item"><span class="label">Address</span><span class="value">${app.address}</span></div>
		    </div>
		  </div>
		
		  <div class="detail-section">
		    <h4>Room Preference</h4>
		    <div class="details-grid">
		      <div class="detail-item"><span class="label">Room Type</span><span class="value">${app.roomType}</span></div>
		      <div class="detail-item"><span class="label">Room Number</span><span class="value">${app.roomNumber}</span></div>
		      <div class="detail-item"><span class="label">Duration</span><span class="value">${app.durationOfStay}</span></div>
		      <div class="detail-item"><span class="label">Special Requests</span><span class="value">${app.specialRequests}</span></div>
		      <div class="detail-item"><span class="label">Expected Check In Date </span><span class="value"> <fmt:formatDate value="${app.expectedCheckIn}" pattern="MMMM dd, yyyy" /></span></div>
		        <c:if test="${not empty app.checkOutDate}">
		        <div class="detail-item"><span class="label">Check Out Date </span><span class="value"> <fmt:formatDate value="${app.checkOutDate}" pattern="MMMM dd, yyyy" /></span></div>
			    </c:if>
		    
		    </div>
		  </div>
		
          
         <c:forEach var="contact" items="${emergencyContactList}">
		  <div class="detail-section">
		    <h4>Guardian Information</h4>
		    <div class="details-grid">
		      <div class="detail-item"><span class="label">Name</span><span class="value">${contact.name}</span></div>
		      <div class="detail-item"><span class="label">Relationship</span><span class="value">${contact.relationship}</span></div>
		      <div class="detail-item"><span class="label">Contact Number</span><span class="value">${contact.phoneNumber}</span></div>
		      <div class="detail-item"><span class="label">Email</span><span class="value">${contact.email}</span></div>
		    </div>
		  </div>
		</c:forEach>

      <div class="modal-footer">
		        <a href="${pageContext.request.contextPath}/Pages/AdminPages/application-management.jsp">
		  <button class="btn btn-outline">Close</button>
		</a>
		
		

        <c:if test="${app.status eq 'pending'}">
       
        		<form action="RejectApplicationServlet" method="post" style="display:none">
		       	 <input type="text" name="application_id" value="${app.applicationId}">
	             <input type="text" name="roomNumber" value="${app.roomNumber}" style="display:none" />
			     <input type="text" name="roomType" value="${app.roomType}" style="display:none" />
			      <input type="text" name="currentOccupancy" value="${app.currentOccupancy}" style="display:none" />
		            <button class="btn btn-danger">Reject</button>
		        </form>
		        
		                 <form action="ApprovedApplicationServlet" method="post">
		       		 <input type="hidden" name="application_id" value="${app.applicationId}">
		          <button class="btn btn-success">Approve</button>
		        </form>
        		
		 </c:if>
		 
		 <c:if test="${app.status eq 'approved'}">
		  <a href="${pageContext.request.contextPath}/Pages/AdminPages/check-out.jsp?applicationId=${app.applicationId}&checkInDate=${app.expectedCheckIn}&roomNumber=${app.roomNumber}&roomType=${app.roomType}&currentOccupancy=${app.currentOccupancy}">
			    <button class="btn btn-primary">Checkout</button>
			</a>

		        
		 </c:if>
 
 
      </div>
</c:forEach>
  </div>
    </div>
  </div>


  
  <!-- IMPORTANT: DO NOT REMOVE THIS SCRIPT TAG OR THIS VERY COMMENT! -->
  <script src="https://cdn.gpteng.co/gptengineer.js" type="module"></script>
</body>
</html>
