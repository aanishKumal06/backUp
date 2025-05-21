<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Register - Marshmallow Haven</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/login_register.css">
<style>
.password-wrapper {
  position: relative;
  display: flex;
  align-items: center;
}

.password-wrapper input {
  width: 100%;
  padding-right: 2.5rem; /* Space for icon */
}

.toggle-password {
  position: absolute;
  right: 1rem;
  top: 50%;
  transform: translateY(-50%);
  cursor: pointer;
  font-size: 1rem;
  color: #666;
  transition: color 0.2s;
}

.toggle-password:hover {
  color: #173a71; /* Highlight color on hover */
}


</style>
</head>
<body>
  <div class="container">
    <div class="left-panel">
      <h2>Welcome to</h2>
      <img src="${pageContext.request.contextPath}/img/b_logo.png" alt="Marshmallow Icon" class="logo" />
      <h3>Marshmallow Haven</h3>
    </div>
    <div class="right-panel">
      <div class="register-box">
        <h2>Register</h2>
	<c:if test="${not empty errors}">
	    <ul style="color: red;">
	        <c:forEach var="error" items="${errors}">
	            <li>${error}</li>
	        </c:forEach>
	    </ul>
	</c:if>

        <form action="${pageContext.request.contextPath}/UserRegisterServlet" method="post">

          <div class="form-row">
            <input class="form-group" type="text" name="fullname" placeholder="Full Name"  />
            <input class="form-group" type="email" name="email" placeholder="Email"  />
          </div>
        
          <div class="form-row">
            <input class="form-group" type="text" name="username" placeholder="Username"  />
            <select class="form-group" name="gender" >
              <option value="" disabled selected>Select Gender</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
              <option value="other">Other</option>
            </select>
          </div>
        
        <div class="form-row">
		  <div class="password-wrapper">
		    <input class="form-group" id="passwordField" type="password" name="password" placeholder="Password" />
		    <i id="togglePasswordIcon" class="fa-solid fa-eye toggle-password" onclick="togglePasswordVisibility('passwordField', 'togglePasswordIcon')"></i>
		  </div>
		
		  <div class="password-wrapper">
		    <input class="form-group" id="retypePasswordField" type="password" name="retypePassword" placeholder="Retype-password" />
		    <i id="toggleRetypeIcon" class="fa-solid fa-eye toggle-password" onclick="togglePasswordVisibility('retypePasswordField', 'toggleRetypeIcon')"></i>
		  </div>
		</div>

        
          <button type="submit">Register</button>
        </form>

        <p style="margin-top: 1rem; font-size: 0.9rem;">
            Already have an account? <a href="${pageContext.request.contextPath}/Pages/login.jsp">Log in here</a>
        </p>
      </div>
    </div>
  </div>
  <script>
  function togglePasswordVisibility(inputId, iconId) {
    const passwordInput = document.getElementById(inputId);
    const icon = document.getElementById(iconId);

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