<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/global_for_client.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/rooms.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/home.css">
  <title>Marshmallow Haven</title>
  <link rel="icon" type="${pageContext.request.contextPath}/image/png" href="img/b_logo.png" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/UserCss/all.min.css">
</head>
<body>
<header>
    <div class="container header-content">

      <div class="logo-container">
        <a href="home.jsp" class="logo"> <img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
        <a href="home.jsp" class="logo-text">Marshmallow Haven</a>
      </div>
    
      <nav>
        <ul>
         <li><a href="${pageContext.request.contextPath}/Pages/UserPages/home.jsp" class="nav-link ${activePage == 'home' ? 'active' : ''}">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/Pages/UserPages/rooms.jsp" class="nav-link ${activePage == 'rooms' ? 'active' : ''}">Rooms</a></li>
		<li><a href="${pageContext.request.contextPath}/Pages/UserPages/hostel-rules.jsp" class="nav-link ${activePage == 'rules' ? 'active' : ''}">Rules</a></li>
		<li><a href="#" class="nav-link ${activePage == 'about' ? 'active' : ''}">About us</a></li>
	

          
          <li class="profile-icon">
            <div class="profile-container">
       
           	 <a href="#" class="nav-link ${activePage == 'profile' ? 'active' : ''}">My Profile</a>
   
              <div class="profile-dropdown">
                <div class="profile-header">
 
                  <div>
                   <h4>${sessionScope.currentUser.fullName}</h4>
                  
                  </div>
                </div>
                <ul class="profile-menu">
				<li><a href="${pageContext.request.contextPath}/Pages/UserPages/student-dashboard.jsp">My Profile</a></li>
				  <li><a href="${pageContext.request.contextPath}/Pages/UserPages/complaint.jsp">Complaint</a></li>
				  <li>
					  <form action="${pageContext.request.contextPath}/LogoutServlet" method="get" >
					    <button type="submit">Logout</button>
					  </form>
					</li>
				</ul>
            </div>
            </div>
          </li>
        </ul>
      </nav>
    </div>
  </header>

</body>
</html>