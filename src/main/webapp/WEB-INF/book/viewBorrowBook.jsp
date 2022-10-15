<%@page import="com.qiren.miniproj.bean.BorrowBookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qiren.miniproj.tools.Constants"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* @import "compass/css3"; */
*, *:before, *:after {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: 'Nunito', sans-serif;
	color: #000000;
}

table {
	min-width: 720px;
	max-width: 960px;
	margin: 10px auto;
	max-width: 960px;
}

caption {
	font-size: 1.6em;
	font-weight: 400;
	padding: 10px 0;
}

thead th {
	font-weight: 400;
	background: #8a97a0;
	color: #FFF;
}

tr {
	background: #f4f7f8;
	border-bottom: 1px solid #FFF;
	margin-bottom: 5px;
}

tr:nth-child(even) {
	background: #e8eeef;
}

th, td {
	text-align: left;
	padding: 12px;
	font-weight: 300;
}

tfoot tr {
	background: none;
}

tfoot td {
	padding: 10px 2px;
	font-size: 0.8em;
	font-style: italic;
	color: #8a97a0;
}
</style>
</head>
<body>


	<form action="./controller" method="POST">
		<table>
			<!--The caption element <caption> represents the title of the table.-->
			<caption>Book List</caption>
			<thead>
				<tr>
					<th scope="col">Select</th>
					<th scope="col">Book</th>
					<th scope="col">Username</th>
					<th scope="col">From Date</th>
					<th scope="col">To Date</th>
					<th scope="col">Returned</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (BorrowBookBean bookBean : (ArrayList<BorrowBookBean>) request.getAttribute(Constants.PARAM_BORROW_LIST)) {
					
				%>
				<tr>
					<td><input type="radio" name="<%= Constants.PARAM_BORROW_ID %>"
						value="<%=bookBean.getPkBorrowBook()%>" /></td>
					<td><%=bookBean.getFkBook()%></td>
					<td><%=bookBean.getFkUser()%></td>
					<td><%=bookBean.getFromDate()%></td>
					<td><%=bookBean.getToDate()%></td>
					<td><%=(null != bookBean.getToDate()) ? "Returned" : "Not Returned"%></td>

				</tr>
				<%
				}
				%>
			
			<tbody>
			<tfoot>
				<tr>
					<!--The 'colspan' attribute contains a non-negative integer value that indicates for how many columns the cell extends. Its default value is 1; if its value is set to 0, it extends until the end of the <colgroup>, even if implicitly defined, that the cell belongs to. Values higher than 1000 will be considered as incorrect and will be set to the default value (1).-->
					<td colspan="3">Powered by <a
						href="https://codepen.io/jpespinal/pen/JozKMJ">CodePen</a>,
						Author: Juan Pablo Espinal
					</td>
				</tr>
			</tfoot>

		</table>
		<input type="hidden" name="action" value="returnBook">
		<button type="submit" class="w3-button w3-right w3-light-gray"
			style="margin-right: 250px; margin-bottom: 120px;">Return Book</button>
	</form>


</body>
</html>


