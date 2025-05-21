<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Room Details - Marshmallow Haven</title>
  <style>
    @charset "UTF-8";

    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f0f4f8;
      margin: 0;
      padding: 0;
      line-height: 1.6;
    }

    .main-content {
      max-width: 1100px;
      margin: 50px auto;
      padding: 0 20px;
    }

    .room-detail-container {
      display: flex;
      flex-wrap: wrap;
      gap: 30px;
      background-color: white;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
      align-items: flex-start;
    }

    .room-detail-image img {
      width: 100%;
      max-width: 450px;
      height: auto;
      border-radius: 12px;
      object-fit: cover;
    }

    .room-detail-info {
      flex: 1;
      min-width: 280px;
    }

    .room-detail-title {
      font-size: 2rem;
      color: #1a3c5a;
      margin-bottom: 15px;
      border-bottom: 2px solid #e6f2ff;
      padding-bottom: 8px;
    }


    
    .room-specs {
    margin-bottom: 10px; /* Adjust as needed */
          font-size: 1rem;
      color: #444;
  }

    .room-description {
      font-size: 1rem;
      color: #555;
      margin-bottom: 15px;
    }

    .room-facilities {
      display: flex;
      flex-wrap: wrap;
      gap: 10px;
      margin-bottom: 20px;
    }

    .facility {
      background-color: #e6f2ff;
      color: #1a3c5a;
      padding: 6px 12px;
      border-radius: 20px;
      font-size: 0.9rem;
    }

    .form-actions {
      margin-top: 20px;
    }

    .btn {
      display: inline-block;
      background-color: #1a3c5a;
      color: white;
      padding: 0.8rem 1.5rem;
      border-radius: 4px;
      text-decoration: none;
      font-weight: 500;
      transition: background-color 0.3s;
      border: none;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #2c5a85;
    }

.room-detail-image img {
  width: 450px;
  height: 350px;
  object-fit: cover;
  border-radius: 12px;
}



    @media (max-width: 768px) {
      .room-detail-container {
        flex-direction: column;
      }

      .room-specs {
        flex-direction: column;
      }
    }
  </style>
</head>
<body>
  <!-- Header -->
  <c:set var="activePage" value="rooms" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>


	  
	<c:if test="${not empty param.roomId}">
	    <input type="hidden" name="roomId" value="${param.roomId}" />
	</c:if>
	
     
		 <c:forEach var="room" items="${rooms}">
		  <div class="main-content">
		    <div class="room-detail-container">
		      <div class="room-detail-image">
		        <img src="${imgURL}${room.imageUrl}" alt="${room.roomType}" />
		      </div>
		      <div class="room-detail-info">
		        <h2 class="room-detail-title">${room.roomType}</h2>
		        <div class="room-specs">
                   <p><strong>Room No:</strong> ${room.roomNumber}</p>
                 </div>
                <div class="room-specs">
				       <p><strong>Capacity:</strong> ${room.capacity} Person</p><br>
				 </div>
				  <div class="room-specs">
				  <p><strong>Price:</strong> $${room.monthlyFee}/month</p>
		        </div>
		        <div class="room-description">
		          ${room.roomDescription}
		        </div>
		        <div class="room-facilities">
		          <c:forEach var="facility" items="${fn:split(room.roomFacilities, ',')}">
		            <span class="facility">${facility}</span>
		          </c:forEach>
		        </div>
		    
		        
		      <form class="form-actions" action="${pageContext.request.contextPath}/ApplicationEligibilityServlet" method="get" style="text-align: center; margin: 0 auto;">
			  <input type="hidden" name="roomId" value="${room.roomId}">
			  <button  type="submit" class="btn">Apply Now</button>
			</form>
			
		 <form class="form-actions" action="${pageContext.request.contextPath}/ApplicationEligibilityServlet" method="get" style="text-align: center; margin: 0 auto;">
			  <input type="hidden" name="roomId" value="${room.roomId}">
			  <button  type="submit" class="btn">Add Whislist</button>
			</form>
		      </div>
		    </div>
		  </div>
		</c:forEach>


	


  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
</body>
</html>