<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Rules-Marshmallow Haven</title>

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/global_for_client.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserCss/rules.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
  <!-- Header -->
    <c:set var="activePage" value="rules" scope="request" />
<jsp:include page="/Pages/UserPages/Components/navbar.jsp"/>
  <!-- Main Content -->
  <section class="main-content">
    <div class="container">
      <h1 class="section-title">Hostel Rules and Policies</h1>
      
      <div class="rules-container">
        <div class="rule-section">
          <h2 class="rule-heading">General Code of Conduct</h2>
          <ul class="rule-list">
            <li>All residents must maintain a high standard of personal behavior and respect for fellow residents.</li>
            <li>Mutual respect and consideration for others is expected at all times.</li>
            <li>Ragging in any form is strictly prohibited and will lead to immediate expulsion.</li>
            <li>Residents are responsible for the cleanliness of their rooms and personal areas.</li>
            <li>Damaging hostel property is strictly prohibited. Compensation will be charged for any damages.</li>
            <li>Usage of electric appliances like heaters, irons, etc. requires prior permission from the warden.</li>
            <li>Students must carry their ID cards at all times within the hostel premises.</li>
          </ul>
        </div>
        
        <div class="rule-section">
          <h2 class="rule-heading">Guest Policy</h2>
          <ul class="rule-list">
            <li>Guests are allowed in the common areas only between 9 AM to 8 PM.</li>
            <li>All guests must register at the reception desk upon arrival.</li>
            <li>Overnight guests are not permitted without prior written approval from the hostel administration.</li>
            <li>Residents are responsible for the behavior and actions of their guests.</li>
            <li>The hostel reserves the right to deny entry to any guest without specifying any reason.</li>
            <li>Parents/Guardians can visit after obtaining permission from the warden.</li>
          </ul>
        </div>
        
        <div class="rule-section">
          <h2 class="rule-heading">Curfew and Entry/Exit Rules</h2>
          <ul class="rule-list">
            <li>The hostel main gate closes at 10:00 PM and reopens at 5:00 AM.</li>
            <li>Students arriving after curfew hours must provide a valid reason and obtain prior permission.</li>
            <li>Students planning to stay out overnight must fill out the "Night Out" form at least 24 hours in advance.</li>
            <li>For extended absences (more than 2 days), written permission from parents/guardians is required.</li>
            <li>Biometric attendance will be taken daily at 9:00 PM.</li>
          </ul>
        </div>
        
        <div class="rule-section">
          <h2 class="rule-heading">Prohibited Activities</h2>
          <ul class="rule-list">
            <li><strong>Noise:</strong> Excessive noise disturbing other residents is prohibited. Quiet hours are from 10:00 PM to 6:00 AM.</li>
            <li><strong>Smoking:</strong> Smoking is strictly prohibited in all areas of the hostel including rooms, corridors, and common areas.</li>
            <li><strong>Alcohol:</strong> Possession or consumption of alcohol is strictly prohibited within the hostel premises.</li>
            <li><strong>Drugs:</strong> Possession, use, or distribution of illegal drugs will lead to immediate expulsion and legal action.</li>
            <li><strong>Gambling:</strong> Any form of gambling is prohibited within the hostel premises.</li>
            <li><strong>Cooking:</strong> Cooking in rooms is not permitted. Designated kitchen areas must be used.</li>
          </ul>
        </div>
        
        <div class="rule-section">
          <h2 class="rule-heading">Consequences for Violations</h2>
          <ul class="rule-list">
            <li><strong>First Violation:</strong> Verbal warning and counseling.</li>
            <li><strong>Second Violation:</strong> Written warning with parental notification.</li>
            <li><strong>Third Violation:</strong> Fine and/or community service within the hostel.</li>
            <li><strong>Serious Violations:</strong> Suspension from the hostel for a specific period.</li>
            <li><strong>Repeated/Major Violations:</strong> Expulsion from the hostel and possible academic consequences.</li>
          </ul>
          <p><strong>Note:</strong> The severity of the consequence may vary based on the nature and seriousness of the violation. The hostel administration reserves the right to take appropriate action as deemed necessary.</p>
        </div>
        
        <div class="rule-section">
          <h2 class="rule-heading">Fee Payment Policy</h2>
          <ul class="rule-list">
            <li>Hostel fees must be paid by the 5th of each month.</li>
            <li>Late payments will incur a penalty of $10 per day.</li>
            <li>Fees can be paid online through the student portal or at the administrative office.</li>
            <li>A receipt will be issued for all payments made.</li>
            <li>In case of any financial constraints, students must approach the warden in advance.</li>
          </ul>
        </div>
      </div>
    </div>
  </section>
  
  <!-- Footer -->
</body>
</html>