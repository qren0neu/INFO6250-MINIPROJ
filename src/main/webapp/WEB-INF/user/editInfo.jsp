<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qiren.miniproj.bean.UserBean"%>
<%@ page import="com.qiren.miniproj.bean.UserRegistrationBean"%>
<%@page import="com.qiren.miniproj.tools.Constants"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edit Personal Info</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
	rel='stylesheet' type='text/css'>
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link href="static/RegistrationForm.css" rel="stylesheet">
</head>

<body>
	<%
	UserBean userBean = (UserBean) request.getAttribute(Constants.PARAM_USER_BEAN);
	%>
	<%
	UserRegistrationBean regisBean = userBean.getUserBean();
	%>
	<div class="main-block">
		<form action="controller?action=register" method="post">
			<h1>Edit Personal Info</h1>
			<fieldset>
				<legend>
					<h3>Personal Details</h3>
				</legend>
				<div class="personal-details">
					<div>
						<div>
							<label>First Name*</label><input type="text" name="fname"
								value="<%=regisBean.getFname()%>" pattern="[A-Z][a-z]+" required>
						</div>
						<div>
							<label>Last Name*</label><input type="text" name="lname"
								value="<%=regisBean.getLname()%>" pattern="[A-Z][a-z]+" required>
						</div>
						<div>
							<label>Address Line*</label><input type="text" name="address1"
								value="<%=regisBean.getAddress1()%>"
								pattern="([a-zA-Z0-9]+\s?)+" required>
						</div>
						<div>
							<label>City*</label><input type="text" name="city"
								value="<%=regisBean.getCity()%>" required>
						</div>
						<div>
							<label>State*</label><input type="text" name="state"
								value="<%=regisBean.getState()%>" pattern="[A-Z]{2}" required>
						</div>
						<div>
							<label>Postal Code*</label><input type="text" name="postcode"
								pattern="([A-Z0-9]{3}\s?){2}"
								value="<%=regisBean.getPostalCode()%>" required>
						</div>
						<div>
							<label>Mobile Number*</label><input type="tel" name="mobile"
								pattern="(\(\+[0-9]+\))?\s?[0-9]{3}-[0-9]{3}-[0-9]{4}"
								value="<%=regisBean.getMobileNumber()%>" required>
						</div>
						<div>
							<label>Email*</label><input type="text" name="email"
								value="<%=regisBean.getEmail()%>"
								pattern="([a-zA-Z0-9]+)([\_\.\-{1}])?([a-zA-Z0-9]+)\@([a-zA-Z0-9]+)([\.])([a-zA-Z\.]+)"
								required>
						</div>
						<!-- Email Pattern reference: https://stackoverflow.com/questions/16200965/regular-expression-validate-gmail-addresses -->
						<div>
							<label>Gender*</label> <select name="gender" required>
								<option value="<%=regisBean.getGender()%>"><%=regisBean.getGender()%></option>
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
						</div>
						<div>
							<label>Birthday*</label><input type="date" name="birthday"
								value="<%=regisBean.getBirthday()%>" required>
						</div>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend>
					<h3>Account Details</h3>
				</legend>
				<div class="account-details">
					<div>
						<label>Username*</label><input type="text" name="username"
							value="<%=regisBean.getUsername()%>" pattern="[a-zA-Z0-9]{4,8}"
							required>
					</div>
					<div>
						<label>New Password*</label><input type="password" name="password"
							placeholder="Hint: length 8-16" pattern=".{8,16}">
					</div>
					<div>
						<label>Confirm New password*</label><input type="password"
							name="confirmpwd" pattern=".{8,16}">
					</div>
				</div>
			</fieldset>
			<p style="color: gray;">Page powered by w3docs:
				https://www.w3docs.com/learn-html/html-form-templates.html</p>
			<button type="submit" href="/">Submit</button>
		</form>
	</div>
</body>

</html>