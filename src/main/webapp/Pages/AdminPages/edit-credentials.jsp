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

  .password-wrapper {
  position: relative;
  width: 100%;
}

.password-wrapper input {
  padding-right: 2.5rem; /* Add room for icon inside */
  width: 100%;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 0.7rem;
  box-sizing: border-box;
}

.toggle-eye {
  position: absolute;
  right: 0.9rem;
  top: 50%;
  transform: translateY(-50%);
  cursor: pointer;
  color: #888;
  font-size: 1rem;
}

.toggle-eye:hover {
  color: #173a71; /* Highlight color on hover */
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
  
  
  #erroModalButton {
    padding: 8px 16px;
    font-size: 14px;
    border: none;
    border-radius: 4px;
    background: #FF0000;
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
   <c:set var="activePage" value="editCredentials" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>


   <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>
       


 <div class="page-header">
        <h1>Edit Credentials</h1>
        <div class="actions">
          <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/admin-dashboard.jsp" class="btn btn-primary"><i class="fas fa-times"></i> Cancel</a>
        </div>
      </div>
  <!-- Add Room Modal -->


	    <div class="add-body">
	    
	
	      
	      <div class="form-group span-2">
	      
		<c:if test="${not empty updateCredentialsError}">
		    <ul class="error-list">
		        <h2>Error</h2><br>
		        <c:forEach var="error" items="${updateCredentialsError}">
		            <li>${error}</li>
		        </c:forEach>
		    </ul>
		</c:if>

	
				<c:if test="${not empty updateMessage}">
			
			  <div id="modalOverlay"></div>
			
		
			  <div id="successModal">
			    <p style="color: green;" >${updateMessage}</p>
			    <button id="closeModalButton">Close</button>
			  </div>
			
			  <script>
			    var contextPath = '${pageContext.request.contextPath}';
			    window.onload = function () {
			      var closeBtn = document.getElementById('closeModalButton');
			      if (closeBtn) {
			        closeBtn.onclick = function () {
			          window.location.href = contextPath + '/Pages/AdminPages/admin-dashboard.jsp';
			        };
			      }
			    };
			  </script>
			</c:if>
	       
	       <c:if test="${not empty updateError}">
 			   <div class="error-list">${updateError}</div>
			</c:if>
			
	       </div>
	        
	          <form action="${pageContext.request.contextPath}/UpdateAdminCredentials" method="post" class="form-grid">
	    <div  >
	          <label for="username" class="form-label">Usrename</label>
	           <div class="password-wrapper">
	          <input type="text" id="username" name="username" class="form-input" value="${sessionScope.currentUser.username}">
	          </div>
	        </div>
	               <input type="hidden" id="oldUsername" name="oldUsername" class="form-control" 
                   value="${sessionScope.currentUser.fullName}">
	        	    <div class="form-group">
	          <label for="password" class="form-label">Password</label>
	          <div class="password-wrapper">
	          <input type="password" id="passwordField" name="password" class="form-input" >
			  <i class="fa-solid fa-eye toggle-eye" id="togglePasswordIcon" onclick="togglePasswordVisibility()"></i>
			</div>
	        </div>
	        

	
	        <!-- Modal Footer -->
	        <div class="form-group span-2">
	          <div class="modal-footer">
	            <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/admin-dashboard.jsp" class="btn btn-outline"> Cancel</a>
	            <button class="btn btn-primary" >Edit Credentials</button>
	          </div>
	        </div>
	      </form>
	    </div>
	  </div>
	</div>




 
  <script>
  function togglePasswordVisibility() {
    const passwordInput = document.getElementById("passwordField");
    const icon = document.getElementById("togglePasswordIcon");

    if (passwordInput.type === "password") {
      passwordInput.type = "text";
      icon.classList.remove("fa-eye");
      icon.classList.add("fa-eye-slash");
    } else {
      passwordInput.type = "password";
      icon.classList.remove("fa-eye-slash");
      icon.classList.add("fa-eye");
    }
  }
</script>
 
  

</body>
</html>