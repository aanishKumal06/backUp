<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin-Marshmallow Haven</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/sidebar.css">

<style type="text/css">

  </style>
</head>
<body>


    <div class="sidebar" id="sidebar">
      <div class="sidebar-header">
          <div class="sidebar-logo">
          <button id="toggleSidebar" class="toggle-sidebar">
            <img src="${pageContext.request.contextPath}/img/b_logo.png" alt="LOGO" class="logo">
          </button>
        </div>
      </div>
      <div class="sidebar-nav">
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/admin-dashboard.jsp" class="nav-item ${activePage == 'dashboard' ? 'active' : ''}">
          <i class="fas fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/application-management.jsp" class="nav-item ${activePage == 'applications' ? 'active' : ''}">
          <i class="fas fa-clipboard-list"></i>
          <span>Applications</span>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/room-management.jsp" class="nav-item ${activePage == 'rooms' ? 'active' : ''}">
          <i class="fas fa-bed"></i>
          <span>Rooms</span>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/notice.jsp" class="nav-item ${activePage == 'notices' ? 'active' : ''}">
          <i class="fas fa-clipboard-list"></i>
          <span>Notices</span>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/report.jsp" class="nav-item ${activePage == 'reports' ? 'active' : ''}">
          <i class="fas fa-gavel"></i>
          <span>Report</span>
        </a>
        <a href="${pageContext.request.contextPath}/Pages/AdminPages/complaint-management.jsp" class="nav-item ${activePage == 'complaints' ? 'active' : ''}">
          <i class="fas fa-exclamation-circle"></i>
          <span>Complaints</span>
        </a>
        
		<a href="${pageContext.request.contextPath}/Pages/AdminPages/edit-credentials.jsp"  class="nav-item ${activePage == 'editCredentials' ? 'active' : ''}">
		   <i class="fas fa-user-cog"></i>
		   <span>Edit Credentials</span>
		</a>

		 <a href="${pageContext.request.contextPath}/LogoutServlet" class="nav-item ${activePage == 'logout' ? 'active' : ''}">
		  <i class="fas fa-sign-out-alt"></i>
		  <span>Logout</span>
		</a>


      </div>
    </div>
    
<script src="${pageContext.request.contextPath}/js/sidebar-toggle.js"></script>
</body>
</html>