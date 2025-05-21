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
      max-width: 300px;
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
    background: #1e3a8a;
    color: #fff;
    cursor: pointer;
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
  <!-- Header -->
  <c:set var="activePage" value="wishlists" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>


	  

	<c:choose>
 		 <c:when test="${not empty rooms}">
     
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
				  <p><strong>Floor:</strong> ${room.floor}</p>
		        </div>
                <div class="room-specs">
				       <p><strong>Capacity:</strong> ${room.capacity} Person</p><br>
				 </div>
				  <div class="room-specs">
				  <p><strong>Price:</strong> $${room.monthlyFee}/month</p>
		        </div>
		        <div class="room-description">
		          <strong>Description :</strong>${room.roomDescription}
		        </div>
		        <div class="room-facilities">
		          <c:forEach var="facility" items="${fn:split(room.roomFacilities, ',')}">
		            <span class="facility">${facility}</span>
		          </c:forEach>
		        </div>
		    
				<div style="margin: 0; padding: 0;">
			  <form class="form-actions" action="${pageContext.request.contextPath}/ApplicationEligibilityServlet" method="get" style="display: inline-block; margin: 0 3px 0 0; padding: 0;">
			    <input type="hidden" name="roomId" value="${room.roomId}">
			    <button type="submit" class="btn">Apply Now</button>
			  </form>
			
			  <form class="form-actions" action="${pageContext.request.contextPath}/DeleteWishServlet" method="post" style="display: inline-block; margin: 0; padding: 0;">
			    <input type="hidden" name="roomId" value="${room.roomId}">
			    <button type="submit" class="btn">Remove </button>
			  </form>
			  
			</div>

		
		      </div>
		    </div>
		  </div>
		</c:forEach>
		
	</c:when>
	  
	  <c:otherwise>
	    <p>There is no room in wishlist.</p>
	  </c:otherwise>
	</c:choose>

<c:if test="${not empty message}">
			
			  <div id="modalOverlay"></div>
			
		
			  <div id="successModal">
			    <p style="color: black;" >${message}</p>
			    <button id="closeModalButton">Close</button>
			  </div>
			
			  <script>
			    var contextPath = '${pageContext.request.contextPath}';
			    window.onload = function () {
			      var closeBtn = document.getElementById('closeModalButton');
			      if (closeBtn) {
			        closeBtn.onclick = function () {
			        	window.location.href = contextPath + '/WishlistDetailsServlet';
			        };
			      }
			    };
			  </script>
			</c:if>

	


  <jsp:include page="/Pages/UserPages/Components/footer.jsp"/>
</body>
</html>