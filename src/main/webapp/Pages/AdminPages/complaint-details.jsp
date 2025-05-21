<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Applications - Hostel Admin</title>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  
  <style >  
  .add-body {
  background-color: #ffffff;         /* white background */
  padding: 1rem;                     /* inner spacing */
  border-radius: 10px;               /* rounded corners */
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.15); /* soft shadow */
  max-width: 1400px;                  /* optional: limit width */
  margin: auto;                      /* center horizontally */
}

.app-card p, .app-card h2 {
  margin-bottom: 10px;
}

.app-card h2 {
color: #1e3a8a;
}

</style>
</head>
<body>
  <div class="hostel-admin">
      <c:set var="activePage" value="complaints" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>

      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>


      <div class="page-header">
        <h1>Application Details</h1>
      </div>
      

	    <div class="add-body">
	    

     <c:forEach var="complaint" items="${complaints}">

		
		  <div class="detail-section">
		    <h4>Compliant Information</h4>
		    <div class="details-grid">
		      <div class="detail-item"><span class="label">Compliant Id</span><span class="value">${complaint.complaintId}</span></div>
		      <div class="detail-item"><span class="label">Submitted By</span><span class="value">${complaint.fullName}</span></div>
		      <div class="detail-item"><span class="label">Compliant Type</span><span class="value">${complaint.complaintType}</span></div>
		      <div class="detail-item"><span class="label">Date Submitted</span><span class="value"> <fmt:formatDate value="${complaint.createdAt}" pattern="MMMM dd, yyyy" /></span></div>
		      <div class="detail-item"><span class="label">Description</span><span class="value">${complaint.description}</span></div>
		    </div>
		  </div>
		
		  
		

      <div class="modal-footer">
		        <a href="${pageContext.request.contextPath}/Pages/AdminPages/complaint-management.jsp">
		  <button class="btn btn-outline">Close</button>

         </a>
 
 
      </div>
</c:forEach>
  </div>
    </div>
  </div>


  
  <!-- IMPORTANT: DO NOT REMOVE THIS SCRIPT TAG OR THIS VERY COMMENT! -->
  <script src="https://cdn.gpteng.co/gptengineer.js" type="module"></script>
</body>
</html>
