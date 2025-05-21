<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	    
	      <form action="${pageContext.request.contextPath}/UploadRoomServlet" method="post" enctype="multipart/form-data" class="form-grid">
	      
	      <div class="form-group span-2">
	      
		<c:if test="${not empty addRoomErrors}">
		    <ul class="error-list">
		        <h2>Error</h2><br>
		        <c:forEach var="error" items="${addRoomErrors}">
		            <li>${error}</li>
		        </c:forEach>
		    </ul>
		</c:if>

	        <c:if test="${not empty successMessage}">
 			   <div class="successMessage-list">${successMessage}</div>
			</c:if>
	       
	       <c:if test="${not empty addRoomError}">
 			   <div class="error-list">${addRoomError}</div>
			</c:if>
			
	       </div>
	        
	        <!-- Room Number -->
	        <div class="form-group">
	          <label for="roomNumber" class="form-label">Room Number</label>
	          <input type="text" id="roomNumber" name="roomNumber" class="form-input" placeholder="e.g. A-101" required>
	        </div>
	
	        <!-- Room Type -->
	        <div class="form-group">
	          <label for="roomType" class="form-label">Room Type</label>
	          <select id="roomType" name="roomType" class="form-select">
	          <option value="" disabled selected>Select RoomType</option>
	            <option value="Single AC">Single AC</option>
	            <option value="Single Non-AC">Single Non-AC</option>
	            <option value="Double AC">Double AC</option>
	            <option value="Double Non-AC">Double Non-AC</option>
	          </select>
	        </div>
	
	        <!-- Floor -->
	        <div class="form-group">
	          <label for="floor" class="form-label">Floor</label>
	          <select id="floor" name="floor" class="form-select">
	          <option value="" disabled selected>Select Floor</option>
	            <option value="1st Floor">1st Floor</option>
	            <option value="2nd Floor">2nd Floor</option>
	          </select>
	        </div>
	
	        <!-- Monthly Fee -->
	        <div class="form-group">
	          <label for="monthlyFee" class="form-label">Price/Month</label>
	          <input type="number" id="monthlyFee" name="monthlyFee" class="form-input" placeholder="e.g. 250">
	        </div>
	
	        <!-- Room Status -->
	        <div class="form-group">
	          <label for="roomStatus" class="form-label">Room Status</label>
	          <select id="roomStatus" name="roomStatus" class="form-select">
	          <option value="" disabled selected>Select RoomStatus</option>
	            <option value="vacant">Vacant</option>
	            <option value="occupied">Occupied</option>
	            <option value="maintenance">Under Maintenance</option>
	          </select>
	        </div>
	
	        <!-- Facilities -->
	        <div class="form-group span-2">
	          <label class="form-label">Facilities</label>
	          <div class="checkbox-group" id="roomFacilities">
	            <label><input type="checkbox" name="facilities" value="WiFi"> WiFi</label>
	            <label><input type="checkbox" name="facilities" value="TV"> TV</label>
	            <label><input type="checkbox" name="facilities" value="Refrigerator"> Refrigerator</label>
	            <label><input type="checkbox" name="facilities" value="Sofa"> Sofa</label>
	            <label><input type="checkbox" name="facilities" value="Study Table"> Study Table</label>
	            <label><input type="checkbox" name="facilities" value="Attached Bathroom"> Attached Bathroom</label>
	            <label><input type="checkbox" name="facilities" value="Wardrobe"> Wardrobe</label>
	            <label><input type="checkbox" name="facilities" value="Ceiling Fan"> Ceiling Fan</label>
	          </div>
	        </div>
	
	        <!-- Upload Room Image -->
	        <div class="form-group span-2">
	          <label for="roomImage" class="form-label">Upload Room Image</label>
	          <input type="file"  name="roomImage" class="form-input">
	          
	        </div>
	
	        <!-- Description -->
	        <div class="form-group span-2">
	          <label for="description" class="form-label">Description</label>
	          <textarea id="description" name="description" class="form-textarea" placeholder="Enter room description"></textarea>
	        </div>
	
	        <!-- Modal Footer -->
	        <div class="form-group span-2">
	          <div class="modal-footer">
	            <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp" class="btn btn-outline"></i> Cancel</a>
	            <button class="btn btn-primary" >Add Room</button>
	          </div>
	        </div>
	      </form>
	    </div>
	  </div>
	</div>




 

 
  

</body>
</html>