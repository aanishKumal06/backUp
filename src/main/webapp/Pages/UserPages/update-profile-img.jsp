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
  
    #erroModalButton {
    padding: 8px 16px;
    font-size: 14px;
    border: none;
    border-radius: 4px;
    background: #FF0000;
    color: #fff;
    cursor: pointer;
  }
</style>


</head>
<body>
  <c:set var="activePage" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>


	<c:if test="${not empty updateImageError}">
			 
			  <div id="modalOverlay"></div>
			
			 
			  <div id="successModal">
			   <c:forEach var="errorlist" items="${updateImageError}">
			           <li style="color: red;  text-align: left;">${errorlist}</li>
			        </c:forEach>
			
			    <button id="erroModalButton">Close</button>
			  </div>
			
			  <script>
			    var contextPath = '${pageContext.request.contextPath}';
			    window.onload = function () {
			      var closeBtn = document.getElementById('erroModalButton');
			      if (closeBtn) {
			        closeBtn.onclick = function () {
			          window.location.href = contextPath + '/Pages/UserPages/student-dashboard.jsp';
			        };
			      }
			    };
			  </script>
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
			          window.location.href = contextPath + '/Pages/UserPages/student-dashboard.jsp';
			        };
			      }
			    };
			  </script>
			</c:if>
			
			<c:if test="${not empty updateError}">
	
			  <div id="modalOverlay"></div>
			
			
			  <div id="successModal">
			    <p style="color: red;" >${updateError}</p>
			    <button id="erroModalButton">Close</button>
			  </div>
			
			  <script>
			    var contextPath = '${pageContext.request.contextPath}';
			    window.onload = function () {
			      var closeBtn = document.getElementById('erroModalButton');
			      if (closeBtn) {
			        closeBtn.onclick = function () {
			          window.location.href = contextPath + '/Pages/UserPages/student-dashboard.jsp';
			        };
			      }
			    };
			  </script>
			</c:if>


<section class="main-content">
  <div class="container">
    <h1 class="section-title">Update Profile</h1>

    <div class="form-container">
      <form  action="${pageContext.request.contextPath}/UserUpdateProfileImageServlet"  method="POST" enctype="multipart/form-data">
        <div class="form-group">
            <h3>Profile Upload</h3>
            <p>Please upload the profile (PNG or JPG format only)</p>
          </div>
          
            <div class="form-group">
              <label for="photo">Profile Photo *</label>
              <input type="file" name="photo" class="form-control" accept=".jpg,.jpeg,.png" >
            </div>
        
        <div class="form-actions">
          <a href="${pageContext.request.contextPath}/Pages/UserPages/student-dashboard.jsp" class="btn update-profile-btn">Cancel</a>
          <button type="submit" class="btn btn-primary">Update Profile</button>
        </div>
      </form>
    </div>
  </div>
</section>
 
  
  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
  
 
  
</body>
</html>