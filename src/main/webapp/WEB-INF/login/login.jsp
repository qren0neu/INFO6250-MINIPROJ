<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<style>
			form {
				margin: 0 auto;
				width: 400px;
			}
		</style>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>

	<body>
		<div class="w3-container w3-light-grey" style="padding: 28px 16px" id="contact">
			<h3 class="w3-center">Login</h3>
			<div class="addEventForm" style="margin-top: 48px;">
				<form action="controller?action=login" method="post">
					<p>
						<input class="w3-input w3-border" type="text" placeholder="User Name" required
							name="username" />
					</p>
					<p>
						<input class="w3-input w3-border" type="password" placeholder="Password" required name="password" />
					</p>
					<p>
						<button class="w3-button w3-right" type="submit">
							<i class="fa fa-arrow-circle-right"></i> Submit
						</button>
					</p>
					<input type="hidden" name="action" value="login" />
					<p>
						<a href="./controller?action=register" class="w3-button"><i
								class="fa fa-envelope">Register</i></a>

					</p>
					<%if(request.getAttribute("error")!= null){%>
						<div class="w3-panel w3-pale-red w3-border">
							<p>${requestScope['error']}</p>
						</div>
						<%}%>
				</form>

			</div>
		</div>

	</body>

	</html>