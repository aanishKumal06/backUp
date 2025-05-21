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
	        
	    
	      <div class="form-group span-2">
	          <label for="roomImage" class="form-label">Upload Room Image</label>
	          <input type="file"  name="roomImage" class="form-input">
	          
	        </div>
	
	        <!-- Modal Footer -->
	        <div class="form-group span-2">
	          <div class="modal-footer">
	            <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp" class="btn btn-outline"></i> Cancel</a>
	            <button class="btn btn-primary" >Edit Room</button>
	          </div>
	        </div>
	      </form>
	    </div>
	  </div>
	</div>




 

 
  

</body>
</html>