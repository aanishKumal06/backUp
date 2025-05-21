<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.util.ArrayList" %>
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

  
  </style>
  

</head>
<body>
 
 <div class="hostel-admin">
   <c:set var="activePage" value="notices" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>



      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>

	
	      


	
				
  <!-- Add Room Modal -->
		
	      <div class="page-header">
        <h1> Notice Management</h1>
 		<div class="actions">
    <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/add-notice.jsp" class="btn btn-primary"><i class="fas fa-plus"></i> Create Notification</a>

        </div>
      </div>
          <c:if test="${empty notices}">
        <c:redirect url="/AdminNoticeDetails" />
    </c:if>
           <div class="left-pane">

     <c:forEach var="notice" items="${notices}">
  <div class="notification-card">
    <div class="notification-icon 
      <c:choose>
        <c:when test="${notice.type eq 'urgent'}">red</c:when>
        <c:when test="${notice.type eq 'information'}">blue</c:when>
        <c:when test="${notice.type eq 'event'}">green</c:when>
        <c:when test="${notice.type eq 'maintenance'}">amber</c:when>
        <c:otherwise>gray</c:otherwise>
      </c:choose>">
      <i class="fas 
        <c:choose>
          <c:when test="${notice.type eq 'urgent'}">fa-exclamation-circle</c:when>
          <c:when test="${notice.type eq 'information'}">fa-info-circle</c:when>
          <c:when test="${notice.type eq 'event'}">fa-calendar-alt</c:when>
          <c:when test="${notice.type eq 'maintenance'}">fa-tools</c:when>
          <c:otherwise>fa-bell</c:otherwise>
        </c:choose>"></i>
       </div>

	    <div class="notification-content">
	      <h4><c:out value="${fn:toUpperCase(notice.title)}" /></h4>
	      <p><c:out value="${notice.message}" /></p>
	      <div class="notification-meta">
	        <span class="date">
	          <fmt:formatDate value="${notice.createdAt}" pattern="MMMM dd, yyyy" />
	        </span>
	        
	        
	  </div>
	        <!-- Optional delete button -->
	        <form action="${pageContext.request.contextPath}/DeleteNoticeServlet" method="post" style="display:inline;">
			  <input type="hidden" name="noticeId" value="${notice.noticeId}" />
			  <button style="border: none; background-color: #ffe5e5; color: red; border-radius: 12px; padding: 6px 12px; margin-top: 10px;" type="submit">
			    Delete
			  </button>
			</form>
	    
	    </div>
	  </div>
</c:forEach>
            
          </div>
        </div>
		


     
      </div>


 
 

 
  

</body>
</html>