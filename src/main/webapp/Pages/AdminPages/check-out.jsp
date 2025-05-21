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



 /* Full-screen semi-transparent overlay */
  #modalOverlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    z-index: 999;
  }

  /* Centered modal box */
  #successModal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: #fff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 8px 16px rgba(0,0,0,0.3);
    text-align: center;
    z-index: 1000;
    max-width: 90%;
    width: 300px;
  }

  #successModal p {
    margin: 0 0 15px;
    font-size: 16px;
    color: #333;
  }

  #closeModalButton {
    padding: 8px 16px;
    font-size: 14px;
    border: none;
    border-radius: 4px;
    background: #28a745;
    color: #fff;
    cursor: pointer;
  }

  #closeModalButton:hover {
    background: #218838;
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
        <h1>Application Management</h1>
        <div class="actions">
          <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/application-management.jsp" class="btn btn-primary"><i class="fas fa-times"></i> Cancel</a>
        </div>
      </div>
  <!-- Add Room Modal -->


	    <div class="add-body">
	    
	      <form action="${pageContext.request.contextPath}/CheckoutRoomServlet" method="post" class="form-grid">
	      

	       <input type="text" name="applicationId" value="${param.applicationId}" style="display:none" />
	        <input type="date" name="checkInDate" value="${param.checkInDate}" style="display:none" />
	          <input type="text" name="roomNumber" value="${param.roomNumber}" style="display:none" />
	        <input type="text" name="roomType" value="${param.roomType}" style="display:none" />
	          <input type="text" name="currentOccupancy" value="${param.currentOccupancy}" style="display:none" />



	       
	      <div class="form-group span-2">
	      

	       <c:if test="${not empty errorMsg}">
 			   <div class="error-list">${errorMsg}</div>
			</c:if>
			
	   
	        
	        	
			<c:if test="${not empty infoMsg}">
			  <!-- Overlay -->
			  <div id="modalOverlay"></div>
			
			  <!-- Modal Box -->
			  <div id="successModal">
			    <p>${infoMsg}</p>
			    <button id="closeModalButton">Close</button>
			  </div>
			
			  <script>
			    var contextPath = '${pageContext.request.contextPath}';
			    window.onload = function () {
			      var closeBtn = document.getElementById('closeModalButton');
			      if (closeBtn) {
			        closeBtn.onclick = function () {
			          window.location.href = contextPath + '/Pages/AdminPages/application-management.jsp';
			        };
			      }
			    };
			  </script>
			</c:if>
    </div>
	
	        <!-- Room Number -->
	        <div class="form-group span-2">
	          <label for="chekOutDate" class="form-label">Check Out </label>
	          <input type="date" id="chekOutDate" name="checkOutDate" class="form-input" required >
	        </div>
	
	        
	
	        <!-- Modal Footer -->
	        <div class="form-group span-2">
	          <div class="modal-footer">
	            <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/application-management.jsp" class="btn btn-outline">Cancel</a>
	            <button class="btn btn-primary" >Checkout</button>
	          </div>
	        </div>
	      </form>
	    </div>
	  </div>
	</div>




 

 
  

</body>
</html>