<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%
String returnTo = (String) request.getAttribute("returnTo");
if (null == returnTo) {
	returnTo = "controller?action=dashboard";
}
%>
<title>Failure</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
@import
	url("https://fonts.googleapis.com/css?family=Fira+Code&display=swap");

* {
	margin: 0;
	padding: 0;
	font-family: "Fira Code", monospace;
}

body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #ecf0f1;
}

.container {
	text-align: center;
	margin: auto;
	padding: 4em;
}

img {
	width: 256px;
	height: 225px;
}

h1 {
	margin-top: 1rem;
	font-size: 35px;
	text-align: center;
}

p {
	margin-top: 1rem;
}

p.info {
	font-size: 12px;
}

a {
	text-decoration: none;
	color: rgb(84, 84, 206);
}
</style>
</head>

<body>
	<div class="container">
		<img src="static/images/warning.jpg" />

		<h1>
			<span>Warning</span> <br /> Are you sure to continue?
		</h1>
		<p>
			<%=request.getAttribute("warn")%>
		</p>
		<p class="info">
			Powered by <a href="https://codepen.io/sheikh_ishaan/pen/abzgRxe"
				target="_blank">CodePen</a>, Author: Ishaan Sheikh
		</p>
	</div>
	<div>
		<form action="controller" method="post">
			<input type="hidden" name="confirm"
				value="confirm">
			<input type="hidden" name="<%=request.getAttribute("key")%>"
				value="<%=request.getAttribute("value")%>">
			<input type="hidden" name="action"
				value="<%=request.getAttribute("action")%>">
			<button type="submit" class="w3-button w3-right w3-light-gray"
				style="margin-right: 36px; margin-bottom: 12px; width: 120px;">Confirm</button>
		</form>
		<form action="controller" method="post">
			<input type="hidden" name="action"
				value="dashboard">
			<button type="submit" class="w3-button w3-right w3-light-gray"
				style="margin-right: 36px; margin-bottom: 120px; width: 120px;">Back</button>
		</form>

		<!-- <a href="controller?action=dashboard" class="w3-button w3-left w3-light-gray"
			style="margin-left: 260px; margin-bottom: 120px;">Go Back</a> -->
	</div>
</body>

</html>