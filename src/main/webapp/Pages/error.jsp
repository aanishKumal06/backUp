<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<title>Error PAge</title>
	  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/b_logo.png" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminCss/styles.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background: rgb(255, 255, 255);
    }

    .container {
      display: flex;
      flex-direction: row;
      align-items: center;
      justify-content: center;
      padding: 20px;
      padding-top: 100px;
    }

    .container img {
      width: 350px;
      margin-right: 20px;
    }

    .text {
      max-width: 400px;
    }

    .text h1 {
      font-size: 25px;
      margin-bottom: 10px;
    }

    .text p {
      font-size: 15px;
      margin-bottom: 15px;
    }

    .text a {
      display: inline-block;
      padding: 8px 12px;
      background:  #1a3c5a;;
      color: white;
      text-decoration: none;
      border-radius: 4px;
    }

    .text a:hover {
      background:  #2c5a85;
    }

    /* Media query for smaller screens */
    @media (max-width: 600px) {
      .container {
        flex-direction: column;
        text-align: center;
        padding: 15px 10px;
        max-width: 100%;
      }

      .container img {
        margin-right: 0;
        margin-bottom: 10px;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <img src="${pageContext.request.contextPath}/img/monster.jpg">
    <div class="text">
      <h1>OOPS! PAGE NOT FOUND.</h1>
      <p>You must have picked the wrong door because I haven't been able to lay my eye on the page you've been searching for.</p>
      <a href="/">Back to Home</a>
    </div>
  </div>
</body>
</html>