<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.marshmallowhaven.DAO.RoomDetailsDAO" %>
 <%@ page import="com.marshmallowhaven.DAO.RoomStatusCountDAO" %>
 
<%@ page import="com.marshmallowhaven.Model.Room" %>
<%@ page import="java.util.HashMap" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Room Management - Hostel Admin</title>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  
  
<style>
.dialog-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    z-index: 999;
}

.dialog-box {
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

.dialog-box button {
    margin: 10px;
    padding: 8px 16px;
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
    background: #28a745;
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

  #closeModalButton:hover {
    background: #218838;
  }


</style>
</head>
<body>
  <div class="hostel-admin">
   <c:set var="activePage" value="rooms" scope="request" />
 <jsp:include page="/Pages/AdminPages/Components/sidebar.jsp"/>

      <!-- Main Content -->
    <div class="content" id="content" >
       <jsp:include page="/Pages/AdminPages/Components/topbar.jsp"/>

      <div class="page-header">
        <h1>Room Management</h1>
        <div class="actions">
          <div class="filter-group">

		<form action="${pageContext.request.contextPath}/RoomManagementrServlet" method="get">
		  <label for="room-filter">Filter by:</label>
		  <select id="room-filter" class="form-select" name="roomStatus">
		    <option value="all" <%= "all".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>All Rooms</option>
		    <option value="vacant" <%= "vacant".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>Vacant</option>
		    <option value="occupied" <%= "occupied".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>Occupied</option>
		    <option value="maintenance" <%= "maintenance".equals(request.getAttribute("selectedStatus")) ? "selected" : "" %>>Under Maintenance</option>
		  </select>
		  <button type="submit" class="btn btn-primary">Apply</button>
		</form>


          </div>
          <a style = "text-decoration: none;"href="${pageContext.request.contextPath}/Pages/AdminPages/add-room.jsp" class="btn btn-primary"><i class="fas fa-plus"></i> Add New Room</a>
        </div>
      </div>
      
    <!--   Room Stat Cards -->
     

<c:set var="stats" value="${roomStatusCounts}" />
    
    <c:if test="${empty roomStatusCounts}">
        <c:redirect url="/RoomManagementrServlet" />
    </c:if>

	<c:set var="total" value="${not empty stats.Total ? stats.Total : 0}" />
	<c:set var="vacant" value="${not empty stats.vacant ? stats.vacant : 0}" />
	<c:set var="occupied" value="${not empty stats.occupied ? stats.occupied : 0}" />
	<c:set var="maintenance" value="${not empty stats.maintenance ? stats.maintenance : 0}" />


<div class="dashboard-stats">
    <div class="stat-card">
        <div class="stat-icon blue">
            <i class="fas fa-door-open"></i>
        </div>
        <div class="stat-info">
            <h3>Total Rooms</h3>
            <p class="stat-number"> ${total}</p>
        </div>
    </div>
    <div class="stat-card">
        <div class="stat-icon green">
            <i class="fas fa-check-circle"></i>
        </div>
        <div class="stat-info">
            <h3>Vacant Rooms</h3>
            <p class="stat-number"> ${vacant}</p>
        </div>
    </div>
    <div class="stat-card">
        <div class="stat-icon red">
            <i class="fas fa-bed"></i>
        </div>
        <div class="stat-info">
            <h3>Occupied Rooms</h3>
            <p class="stat-number">${occupied}</p>
        </div>
    </div>
    <div class="stat-card">
        <div class="stat-icon amber">
            <i class="fas fa-tools"></i>
        </div>
        <div class="stat-info">
            <h3>Under Maintenance</h3>
            <p class="stat-number">${maintenance}</p>
        </div>
    </div>
</div>
     

 
      

      <!-- Building/Block Tabs -->
      <div class="tab-nav">
        <button class="tab-button active">All Blocks</button>
      </div>
      
      <!-- Rooms Table -->
<div class="table-container"> 


    <table class="admin-table">
        <thead>
            <tr>
                <th>Room Number</th>
                <th>Floor</th>
                <th>Type</th>
                <th>Fee</th>
                <th>Status</th>
                <th>Occupant</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="room" items="${rooms}">
                <c:set var="statusClass" value="badge-default" />
                <c:choose>
                    <c:when test="${room.roomStatus eq 'occupied'}">
                        <c:set var="statusClass" value="badge-occupied" />
                    </c:when>
                    <c:when test="${room.roomStatus eq 'vacant'}">
                        <c:set var="statusClass" value="badge-vacant" />
                    </c:when>
                    <c:when test="${room.roomStatus eq 'maintenance'}">
                        <c:set var="statusClass" value="badge-maintenance" />
                    </c:when>
                </c:choose>

                <tr>
                    <td>${room.roomNumber}</td>
                    <td>${room.floor}</td>
                    <td>${room.roomType}</td>
                    <td>$${room.monthlyFee}</td>
                    <td><span class="${statusClass}">${room.roomStatus}</span></td>
                    <td>${room.currentOccupancy}</td>
				    <td>
				    
				    <form action="${pageContext.request.contextPath}/UpdateRoomServlet" method="get" class="form-grid">
					    <input type="hidden" name="roomId" value="${room.roomId}" />
					  <button class="btn-icon"><i class="fas fa-edit"></i></button>
					</form>
									     
		           
				    
				    
				
						<form action="AdminRoomDetailsByIdServlet" method="get">
				          <input type="hidden" name="roomId" value="${room.roomId}">

						  <button class="btn-icon" type="submit">
						    <i class="fas fa-eye"></i>
						  </button>
						</form>
						   
				
				    <c:if test="${room.currentOccupancy == 0 }">

				            <button type="button" class="btn-icon danger" onclick="showConfirmDialog('${room.roomId}')">
				                <i class="fas fa-trash"></i>
				            </button>
				     
				        <!-- Confirmation Dialog -->
				        <div id="confirmDialog${room.roomId}" class="dialog-overlay" style="display: none;">
				            <div class="dialog-box">
				                <p>Are you sure you want to delete room no ${room.roomNumber}?</p>
				                <button onclick="cancelDelete('${room.roomId}')">Cancel</button>
											        
							<form   action="delete-room" method="post">
							    <input type="hidden" name="roomId" value="${room.roomId}">
							    <button type="submit">Delete</button> <!-- This triggers the form submission automatically -->
							</form>

				            </div>
				        </div>
				     

				    </c:if>
				    
				    

			
				</td>
                </tr>
            </c:forEach>
            
            
        </tbody>
    </table>
    
    
    

			
			
		
	
			
</div>


 
</div>


      
</div>


 


  					<script>
					function showConfirmDialog(roomId) {
					    document.getElementById('confirmDialog' + roomId).style.display = 'block';
					}
					
					function cancelDelete(roomId) {
					    document.getElementById('confirmDialog' + roomId).style.display = 'none';
					}
					
				
					</script>

  

</body>
</html>