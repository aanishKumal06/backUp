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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

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

</style>


</head>
<body>
  <c:set var="activePage" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>


>
<!-- Main Content -->
<section class="main-content">
  <div class="container">
    <h1 class="section-title">Update Password</h1>


	<c:if test="${not empty updatePasswordError}">
			 
			  <div id="modalOverlay"></div>
			
			 
			  <div id="successModal">
			   <c:forEach var="errorlist" items="${updatePasswordError}">
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

    <div class="form-container">
      <form action="${pageContext.request.contextPath}/UserUpdatePasswordServlet"  method="POST"  >

          <div class="form-group">
            <label for="password">New Password</label>

          </div>
          
          <div class="password-wrapper">
			  <input class="form-control" type="password" name="password" placeholder="New Password" id="passwordField" />
			  <i class="fa-solid fa-eye toggle-eye" id="togglePasswordIcon" onclick="togglePasswordVisibility()"></i>
			</div>
        
        <div class="form-actions">
          <a href="${pageContext.request.contextPath}/Pages/UserPages/student-dashboard.jsp" class="btn update-profile-btn">Cancel</a>
          <button type="submit" class="btn btn-primary">Update Password</button>
        </div>
      </form>
    </div>
  </div>
</section>
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
  
  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
  
 
  
</body>
</html>