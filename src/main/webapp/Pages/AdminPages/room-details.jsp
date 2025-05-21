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
  
 .profile-pic-wrapper {
  position: relative;
  display: inline-block;
}

.applicant-photo {
  width: 100px;
  height: 100px;
  border-radius: 100%;
}

.update-btn {
  position: absolute;
  bottom: 10px; 
  right: 10px;
  text-decoration: none;
}

.update-btn button {
  background-color: #1a3c5a;
  color: white;
  border: none;
  border-radius: 50%;
  width: 25px;
  height: 25px;
  font-size: 16px;
  cursor: pointer;
  box-shadow: 0 2px 6px rgba(0,0,0,0.3);
  transition: background-color 0.3s ease;
}

.update-btn button:hover {
  background-color: #2c5a85;
}

 
  .add-body {
  background-color: #ffffff;         /* white background */
  padding: 1rem;                     /* inner spacing */
  border-radius: 10px;               /* rounded corners */
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15); /* soft shadow */
  max-width: 1400px;                  /* optional: limit width */
  margin: auto;                      /* center horizontally */
}

.room-card p, .room-card h2 {
  margin-bottom: 10px;
}

.room-card h2 {
color: #1e3a8a;
}

</style>
</head>
<body>
  <div class="hostel-admin">
      <c:set var="activePage" value="rooms" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>

      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>


      <div class="page-header">
        <h1>Room Details</h1>
      </div>
      

	    <div class="add-body">
	    

     <c:forEach var="rooms" items="${rooms}">
		  
<div class="applicant-header">
		 <div class="profile-pic-wrapper">
			  <img src="${imgURL}${rooms.imageUrl}" alt="Room Photo" class="applicant-photo">
			  <a href="${pageContext.request.contextPath}/Pages/AdminPages/edit-room-image.jsp" class="update-btn">
			    <button type="button">
			      <i class="fas fa-plus"></i>
			    </button>
			  </a>
			</div>


		    
		    
		    <div class = "room-card">
		      <h2>${rooms.roomType}</h2>  
		       <p>
		    
		      <c:choose>
                    <c:when test="${rooms.roomStatus eq 'occupied'}">
                     <span class="badge badge-occupied">Occupied</span>
                      
                    </c:when>
                    <c:when test="${rooms.roomStatus eq 'vacant'}">
                    <span class="badge badge-vacant">Vacant</span>
                        <c:set var="statusClass" value="badge-vacant" />
                    </c:when>
                    <c:when test="${rooms.roomStatus eq 'maintenance'}">
                    <span class="badge badge-maintenance">Maintenance</span>
                        
                    </c:when>
                </c:choose>
                </p>
		    </div>
		  </div>
		

		
		  <div class="detail-section">
		    <h4>Room Information</h4>
		      <div class="details-grid">
				  <div class="detail-item"><span class="label">Room Type</span><span class="value">${rooms.roomType}</span></div>
				  <div class="detail-item"><span class="label">Room Number</span><span class="value">${rooms.roomNumber}</span></div>
				  <div class="detail-item"><span class="label">Description</span><span class="value">${rooms.roomDescription}</span></div>
				  <div class="detail-item"><span class="label">Facilities</span><span class="value">${rooms.roomFacilities}</span></div>
				  <div class="detail-item"><span class="label">Capacity</span><span class="value">${rooms.capacity}</span></div>
				  <div class="detail-item"><span class="label">Occupancy</span><span class="value">${rooms.currentOccupancy}</span></div>
				  <div class="detail-item"><span class="label">Monthly Fee</span><span class="value">$ ${rooms.monthlyFee}</span></div>
				  <div class="detail-item"><span class="label">Floor</span><span class="value">${rooms.floor}</span></div>
				  <div class="detail-item"><span class="label">Status</span><span class="value">${rooms.roomStatus}</span></div>
				  
				</div>

		  </div>
		  
				  
		
          
      

      <div class="modal-footer">

	   <a href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp">
			  <button class="btn btn-outline">Close</button>
			</a>

		
		       		
		       		 <a href="${pageContext.request.contextPath}/Pages/AdminPages/edit-room.jsp?roomId=${rooms.roomId}">
		           <button class="btn btn-primary">Edit Room</button>
		           </a>
		       
        		

		
 
 
      </div>
</c:forEach>
  </div>
    </div>
  </div>


  
  <!-- IMPORTANT: DO NOT REMOVE THIS SCRIPT TAG OR THIS VERY COMMENT! -->
  <script src="https://cdn.gpteng.co/gptengineer.js" type="module"></script>
</body>
</html>
