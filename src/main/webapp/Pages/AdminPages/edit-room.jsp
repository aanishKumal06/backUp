<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <%@ page import="java.util.ArrayList" %>
    
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
   <c:set var="activePage" value="rooms" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>



      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>
       


 <div class="page-header">
        <h1>Edit Room</h1>
        <div class="actions">
          <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp" class="btn btn-primary"><i class="fas fa-times"></i> Cancel</a>
        </div>
      </div>
  <!-- Add Room Modal -->


	    <div class="add-body">
	    
	   
	      
	      <form action="${pageContext.request.contextPath}/UpdateRoomServlet" method="post" class="form-grid">
	     
	       
	      <div class="form-group span-2">
	      
		<c:if test="${not empty roomErrors}">
		    <ul class="error-list">
		        <h2>Error</h2><br>
		        <c:forEach var="error" items="${roomErrors}">
		            <li>${error}</li>
		        </c:forEach>
		    </ul>
		</c:if>


	       
	       <c:if test="${not empty roomError}">
 			   <div class="error-list">${roomError}</div>
			</c:if>
			
		
    
	       </div>
	       
	<c:forEach var="room" items="${roomDetails}">
	        <input type="hidden" name="status" value="${room.roomStatus}" >
	         <input type="hidden" name="roomId" value="${room.roomId}" >
	         <input type="hidden" name="oldRoomNum" value="${room.roomNumber}" >
	         
	         
     <!-- Room Number -->
          <div class="form-group">
            <label for="roomNumber" class="form-label">Room Number</label>
            <input type="text" id="roomNumber" name="roomNumber" class="form-input"
                   value="${room.roomNumber}" required>
          </div>
    

        
          <!-- Room Type -->
 		 <c:if test="${room.roomStatus != 'occupied'}">
          <div class="form-group">
            <label for="roomType" class="form-label">Room Type</label>
            <select id="roomType" name="roomType" class="form-select" required>
              <option value="" disabled>Select Room Type</option>
              <option value="Single AC" ${room.roomType == 'Single AC' ? 'selected' : ''}>Single AC</option>
              <option value="Single Non-AC" ${room.roomType == 'Single Non-AC' ? 'selected' : ''}>Single Non-AC</option>
              <option value="Double AC" ${room.roomType == 'Double AC' ? 'selected' : ''}>Double AC</option>
              <option value="Double Non-AC" ${room.roomType == 'Double Non-AC' ? 'selected' : ''}>Double Non-AC</option>
            </select>
          </div>
          </c:if>

          <!-- Floor -->
          <c:if test="${room.roomStatus != 'occupied'}">
          <div class="form-group">
            <label for="floor" class="form-label">Floor</label>
            <select id="floor" name="floor" class="form-select" required>
              <option value="" disabled>Select Floor</option>
              <option value="1st Floor" ${room.floor == '1st Floor' ? 'selected' : ''}>1st Floor</option>
              <option value="2nd Floor" ${room.floor == '2nd Floor' ? 'selected' : ''}>2nd Floor</option>
            </select>
          </div>
          </c:if>

          <!-- Monthly Fee -->
          <div class="form-group">
            <label for="monthlyFee" class="form-label">Price/Month (NPR)</label>
            <input type="number" id="monthlyFee" name="monthlyFee" class="form-input"
                   value="${room.monthlyFee}" min="0" required>
          </div>

          <!-- Room Status -->
         <c:if test="${room.roomStatus != 'occupied'}">
		  <div class="form-group">
		    <label for="roomStatus" class="form-label">Room Status</label>
		    <select id="roomStatus" name="roomStatus" class="form-select" required>
		      <option value="" disabled>Select Room Status</option>
		      <option value="vacant" ${room.roomStatus == 'vacant' ? 'selected' : ''}>Vacant</option>
		      <option value="occupied" ${room.roomStatus == 'occupied' ? 'selected' : ''}>Occupied</option>
		      <option value="maintenance" ${room.roomStatus == 'maintenance' ? 'selected' : ''}>Under Maintenance</option>
		    </select>
		  </div>
		</c:if>
		
		         <c:set var="facilitiesList" value="${fn:split(room.roomFacilities, ',')}" />

          <!-- Facilities -->
          <div class="form-group span-2">
       <label>
		  <input type="checkbox" name="facilities" value="WiFi"
		    <c:if test="${fn:contains(room.roomFacilities, 'WiFi')}">checked</c:if> /> WiFi
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="TV"
		    <c:if test="${fn:contains(room.roomFacilities, 'TV')}">checked</c:if> />  TV
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="Refrigerator"
		    <c:if test="${fn:contains(room.roomFacilities, 'Refrigerator')}">checked</c:if> />  Refrigerator
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="Sofa"
		    <c:if test="${fn:contains(room.roomFacilities, 'Sofa')}">checked</c:if> />  Sofa
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="Study Table"
		    <c:if test="${fn:contains(room.roomFacilities, 'Study Table')}">checked</c:if> />  Study Table
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="Attached Bathroom"
		    <c:if test="${fn:contains(room.roomFacilities, 'Attached Bathroom')}">checked</c:if> />  Attached Bathroom
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="Wardrobe"
		    <c:if test="${fn:contains(room.roomFacilities, 'Wardrobe')}">checked</c:if> />  Wardrobe
		</label>
		
		<label>
		  <input type="checkbox" name="facilities" value="Ceiling Fan"
		    <c:if test="${fn:contains(room.roomFacilities, 'Ceiling Fan')}">checked</c:if> />  Ceiling Fan
		</label>

            </div>
       

          <!-- Description -->
          <div class="form-group span-2">
            <label for="description" class="form-label">Description</label>
            <textarea id="description" name="description" class="form-textarea"
                      placeholder="Enter room description">${room.roomDescription}</textarea>
          </div>
          
         </c:forEach>
	
		
	        <!-- Modal Footer -->
	        <div class="form-group span-2">
	          <div class="modal-footer">
	            <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp" class="btn btn-outline"> Cancel</a>
	            <button class="btn btn-primary" >Edit Room</button>
	          </div>
	        </div>
	      </form>
	    </div>
	  </div>
	</div>




 

 
  

</body>
</html>