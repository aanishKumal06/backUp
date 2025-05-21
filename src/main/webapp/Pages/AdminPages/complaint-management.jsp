<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Room Management - Hostel Admin</title>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <style>
    .badge-security {
    background-color: #e0e7ff;
    color: #4f46e5;
  }
  
  .badge-other {
    background-color: #d1fae5;
    color: #059669;
  }
  </style>
  

</head>
<body>
  <div class="hostel-admin">
    <!-- Sidebar -->
          <c:set var="activePage" value="complaints" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>

      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>




      <div class="page-header">
        <h1>Complaints </h1>
        <div class="actions">
          <div class="filter-group">
		<form action="${pageContext.request.contextPath}/ComplaintManagementServlet" method="get">
		  <label for="filter-group">Filter by:</label>
		  <select id="filter-group" class="form-select" name="ComplaintType">
		    <option value="All" <%= "All".equals(request.getAttribute("selectedComplaint")) ? "selected" : "" %>>All Types</option>
		    <option value="Maintenance" <%= "Maintenance".equals(request.getAttribute("selectedComplaint")) ? "selected" : "" %>>Maintenance</option>
		    <option value="Security" <%= "Security".equals(request.getAttribute("selectedComplaint")) ? "selected" : "" %>>Security</option>
		    <option value="Other" <%= "Other".equals(request.getAttribute("selectedComplaint")) ? "selected" : "" %>>Others</option>
		  </select>
		  <button type="submit" class="btn btn-primary">Apply</button>
		</form>
          </div>
        </div>
      </div>
      
      
            
      <c:if test="${empty conmplaintsStatusCounts}">
        <c:redirect url="/ComplaintManagementServlet" />
    </c:if>



     <c:set var="conmplaints" value="${conmplaintsStatusCounts}" />

    <c:set var="total" value="${not empty conmplaints.Total ? conmplaints.Total : 0}" />
	<c:set var="security" value="${not empty conmplaints.Security ? conmplaints.Security : 0}" />
	<c:set var="maintenance" value="${not empty conmplaints.Maintenance ? conmplaints.Maintenance : 0}" />
    <c:set var="others" value="${not empty conmplaints.Other ? conmplaints.Other : 0}" />
    
    
    
      <!-- Complaints Summary Stats -->
      <div class="dashboard-stats">
        <div class="stat-card">
          <div class="stat-icon blue">
            <i class="fas fa-exclamation-circle"></i>
          </div>
          <div class="stat-info">
            <h3>Total Complaints</h3>
            <p class="stat-number">${total}</p>
          </div>
        </div>
        <div class="stat-card">
        <div class="stat-icon amber">
            <i class="fas fa-tools"></i>
        </div>
          <div class="stat-info">
            <h3>Maintenance</h3>
            <p class="stat-number">${maintenance}</p>
          </div>
        </div>
        <div class="stat-card">
			<div class="stat-icon purple">
			  <i class="fas fa-shield-alt"></i>
			</div>

          <div class="stat-info">
            <h3>Security</h3>
            <p class="stat-number">${security}</p>
          </div>
        </div>
        <div class="stat-card">
          <div class="stat-icon green">
				<i class="fas fa-puzzle-piece"></i>
          </div>
          <div class="stat-info">
            <h3>Others</h3>
            <p class="stat-number">${others}</p>
          </div>
        </div>
      </div>

      <!-- Complaints Table -->
      <div class="table-container">
        <table class="admin-table">
          <thead>
            <tr>
              <th>Complaint ID</th>
              <th>User</th>
              <th>Category</th>
              <th>Date Filed</th>
              <th>Actions</th>
            </tr>
          </thead>
		   <tbody>
		    <c:forEach var="complaint" items="${complaints}">
		      <tr>
		        <td>COMP-${complaint.complaintId}</td>
		        <td>${complaint.fullName}</td>
		        <td>
		          <span class="badge badge-${fn:toLowerCase(complaint.complaintType)}">
		            ${complaint.complaintType}
		          </span>
		        </td>
		        <td>
		          <fmt:formatDate value="${complaint.createdAt}" pattern="MMMM dd, yyyy"/>
		        </td>
		        <td>
		        
               <form action="${pageContext.request.contextPath}/CompliantDetailsServelt" method="get">
		          <input type="hidden" name="compliant_id" value="${complaint.complaintId}">
				  <button class="btn-icon" type="submit">
				    <i class="fas fa-eye"></i>
				  </button>
				</form>
		        </td>
		      </tr>
		    </c:forEach>
		  </tbody>
        </table>
      </div>

      </div>
      </div>



  
  <!-- IMPORTANT: DO NOT REMOVE THIS SCRIPT TAG OR THIS VERY COMMENT! -->
  <script src="https://cdn.gpteng.co/gptengineer.js" type="module"></script>
</body>
</html>