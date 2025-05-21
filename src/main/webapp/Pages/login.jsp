<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 <title>Login-Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/login_register.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style type="text/css">
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
  <div class="container">
    <div class="left-panel">
      <h2>Welcome to</h2>
      <img src="${pageContext.request.contextPath}/img/b_logo.png" alt="Marshmallow Icon" class="logo" />
      <h3>Marshmallow Haven</h3>
    </div>
    <div class="right-panel">
      <div class="login-box">
        <h2>Log in</h2>
       <c:if test="${not empty errorMessage}">
    	<div style="color: red;">${errorMessage}</div>
		</c:if>
        <form action="${pageContext.request.contextPath}/UserLoginServlet" method="post">

             <input class="form-group" type="text" name="username" placeholder="Username"  />
			<div class="password-wrapper">
			  <input class="form-group" type="password" name="password" placeholder="Password" id="passwordField" />
			  <i class="fa-solid fa-eye toggle-eye" id="togglePasswordIcon" onclick="togglePasswordVisibility()"></i>
			</div>
 

          <button type="submit">Login</button>
        </form>

        <p style="margin-top: 1rem; font-size: 0.9rem;">
          Don’t have an account?
          <a href="${pageContext.request.contextPath}/Pages/register.jsp">Register here</a>
        </p>
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
