<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qiren.miniproj.bean.SessionBean"%>

<!DOCTYPE html>
<html>

<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="static/MainStyle.css">
</head>

<body>

	<!-- Navbar (sit on top) -->
	<div class="topnav">
		<a href="controller?action=dashboard"
			class="w3-bar-item w3-button w3-wide">HOME</a>
		<!-- Right-sided navbar links -->
		<div class="w3-right w3-hide-small">
			<!-- <a href="#about" class="w3-bar-item w3-button">ABOUT</a> -->
			<a href="controller?action=viewUser"
				class="w3-bar-item w3-button"><i class="fa fa-user"></i> VIEW
				INFO</a> <a href="controller?action=userList"
				class="w3-bar-item w3-button"><i class="fa fa-th"></i> VIEW USERS</a> <a
				href="controller?action=logout" class="w3-bar-item w3-button"><i
				class="fa fa-envelope"></i> LOGOUT</a>
		</div>
		<!-- Hide right-floated links on small screens and replace them with a menu icon -->
	</div>

	<div
		class="bgimg w3-display-container w3-animate-opacity w3-text-white">
		<div class="w3-display-topleft w3-padding-large w3-xlarge">Logo
		</div>
		<%
		HttpSession session1 = request.getSession();
		SessionBean bean = (SessionBean) session.getAttribute("SESSION_KEY");
		%>
		<div class="w3-display-middle">
			<h1 class="w3-jumbo w3-animate-top w3-center">Northeastern Snell
				Library</h1>
			<hr class="w3-border-grey" style="margin: auto; width: 40%">
			<p class="w3-large w3-center">
				Welcome,
				<%=bean.getFname()%>
			</p>
		</div>
		<div class="w3-display-bottomleft w3-padding-large">
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				target="_blank">w3.css</a>
		</div>
	</div>

</body>

</html>