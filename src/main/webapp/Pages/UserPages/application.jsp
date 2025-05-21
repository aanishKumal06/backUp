<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <title>Application-Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/UserCss/global_for_client.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/UserCss/application.css">

<style>
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
  <c:set var="activePage" value="rooms" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>



  <!-- Main Content -->
  <section class="main-content">
    <div class="container">
      <h1 class="section-title">Hostel Application Form</h1>
      
      <div class="form-container">
        <form action="${pageContext.request.contextPath}/UploadApplicationServelt" method="post" enctype="multipart/form-data" >
        
        
          <div class="form-group">
            <h3>Personal Information</h3>
             <c:if test="${not empty applicationError}">
			    <ul style="color: red;">
			        <c:forEach var="error" items="${applicationError}">
			            <li>${error}</li>
			        </c:forEach>
			    </ul>
			</c:if>
			

            <c:if test="${not empty roomId}">
    				<input type="hidden" name="roomId" value="${roomId}"  />
			</c:if>
            
				
			<c:if test="${not empty infoMessage}">
			  <!-- Overlay -->
			  <div id="modalOverlay"></div>
			
			  <!-- Modal Box -->
			  <div id="successModal">
			    <p>${infoMessage}</p>
			    <button id="closeModalButton">Close</button>
			  </div>
			
			  <script>
			    var contextPath = '${pageContext.request.contextPath}';
			    window.onload = function () {
			      var closeBtn = document.getElementById('closeModalButton');
			      if (closeBtn) {
			        closeBtn.onclick = function () {
			          window.location.href = contextPath + '/Pages/UserPages/rooms.jsp';
			        };
			      }
			    };
			  </script>
			</c:if>

		
		
	
		

			
			       </div>
          
          <div class="form-row">
            <div class="form-group">
              <label for="fullname">Full Name *</label>
              <input type="text" name="fullname" class="form-control" required>
            </div>
            
          <div class="form-group">
              <label for="phone">Contact Number *</label>
              <input type="tel" name="phone" class="form-control" required>
            </div>
            
          </div>
          
          <div class="form-row">
          <div class="form-group">
              <label for="dob">Date of Birth *</label>
              <input type="date" name="dob" class="form-control" required>
            </div>
            
  
     		 <div class="form-group">
            <label for="address">Permanent Address *</label>
            <input type="text" name="address" class="form-control"  required></input>
          </div>
          
          </div>
          
        
          
      
          
          <div class="form-group">
            <h3>Emergency Contact</h3>
          </div>
          
          <div class="form-row">
            <div class="form-group">
              <label for="emergency-name">Contact Name *</label>
              <input type="text" name="emergency-name" class="form-control" required>
            </div>
            
            <div class="form-group">
              <label for="relationship">Relationship *</label>
              <input type="text" name="relationship" class="form-control" required>
            </div>
          </div>
          
          <div class="form-row">
            <div class="form-group">
              <label for="emergency-phone">Contact Number *</label>
              <input type="tel" name="emergency-phone" class="form-control" required>
            </div>
            
            <div class="form-group">
              <label for="emergency-email">Email Address</label>
              <input type="email" name="emergency-email" class="form-control">
            </div>
          </div>
          
          <div class="form-group">
            <h3>Room Preference</h3>
          </div>
          
          <div class="form-row">
            
            <div class="form-group">
              <label for="check-in">Expected Check-in Date *</label>
              <input type="date" name="check-in" class="form-control" required>
            </div>

            <div class="form-group">
              <label for="duration">Duration of Stay *</label>
              <select name="duration" class="form-control" required>
                <option value="" disabled selected>Select Duration</option>
                <option value="1-month">1 Month</option>
                <option value="3-months">3 Months</option>
                <option value="6-months">6 Months</option>
                <option value="1-year">1 Year</option>
              </select>
            </div>
          </div>
          
          <div class="form-row">
            
            
            <div class="form-group">
              <label for="special-requests">Special Requests</label>
              <input type="text" name="special-requests" class="form-control">
            </div>
          </div>
          
          <div class="form-group">
            <h3>Document Upload</h3>
            <p>Please upload the following documents (PDF or JPG format only, max size 2MB each)</p>
          </div>
          
  


          
            <div class="form-group">
              <label for="photo">Profile Photo *</label>
              <input type="file" name="photo" class="form-control" accept=".jpg,.jpeg,.png" required>
            </div>
            
          
          <div class="form-group">
            <input type="checkbox" id="terms" required>
            <label for="terms">I have read and agree to the <a href="hostel-rules.jsp">hostel rules and policies</a> *</label>
          </div>
          
          <div class="form-actions">
          <a href="${pageContext.request.contextPath}/Pages/UserPages/rooms.jsp"" class="btn" style="background-color: #6c757d; padding: 0.5rem 1rem; color: white; text-decoration: none; border-radius: 5px;">
  						Cancel Application
          </a>

            <button type="submit" class="btn">Submit Application</button>
          </div>
        </form>
      </div>
      </div>
  </section>
  
  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
  

  
</body>
</html>