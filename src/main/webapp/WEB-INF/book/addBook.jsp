<%@page import="com.qiren.miniproj.tools.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qiren.miniproj.bean.BookBean"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Info</title>
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
	<form action="controller" method="post">
		<!--The table element represents data in a series of rows and columns. Tables should only be used for displaying tabular data, and never for page layout.-->
		<table>
			<!--The caption element <caption> represents the title of the table.-->
			<caption>Add Book</caption>
			<!--The table head element <thead> (not to be confused with the table header cell element) defines a set of rows that make up the header of a table.-->
			<thead>
				<!--The table row element <tr> defines a row of cells in a table. Table rows can be filled with table cells and table header cells.-->
				<tr>
					<!--The table header cell <th> helps label a group of cells in either a column or a row.-->
					<th scope="col">Heads</th>
					<th scope="col">Values</th>
				</tr>
			</thead>
			<!--The table body element <tbody> defines one or more rows that make up the primary contents (or "body") of a table.-->
			<tbody>
				<!-- <tr>
                <th scope="row">Salina Brown</th>
                <td>hello@salinabrown.com</td>
            </tr> -->
				<%-- <% BookBean bookBean=(BookBean) request.getAttribute(Constants.PARAM_BOOK_BEAN); %>
								--%>
				<tr>
					<th scope="row">ISBN</th>
					<td><input type="text" name="ISBN" pattern="[0-9]{10}"
						required></td>
				</tr>
				<tr>
					<th scope="row">Book Name</th>
					<td><input type="text" name="name"
						pattern="^[A-Za-z0-9\s\-_,\.;:()]+$" required></td>
				</tr>
				<tr>
					<th scope="row">Author</th>
					<td><input type="text" name="author"
						pattern="([A-Z][a-z]+\s?)+" required></td>
				</tr>
				<tr>
					<th scope="row">Publisher</th>
					<td><input type="text" name="publisher"
						pattern="([a-zA-Z0-9]+\s?)+" required></td>
				</tr>
				<tr>
					<th scope="row">Description</th>
					<td><input type="text" name="description" required></td>
				</tr>
				<tr>
					<th scope="row">In Stock</th>
					<td><input type="number" name="inStock" required></td>
				</tr>
			</tbody>
			<!--The table foot element <tfoot> contains a summary of the table. This might be totals for columns of numerical data or meta information about the source of data.-->
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

		<%-- <form action="controller" method="post">
						<input type="hidden" name="action" value="<%= Constants.ACTION_EDIT_BOOKS %>">
						<input type="hidden" name="<%= Constants.PARAM_BOOK_ID %>" value="<%=bookBean.getPkBook()%>">
						<button class="w3-button w3-right w3-light-gray"
							style="margin-right: 250px; margin-bottom: 120px;">Edit BOOK
							Info</button>
				</form> --%>
		<input type="hidden" name="action"
			value="<%=Constants.ACTION_ADD_BOOK%>">
		<button class="w3-button w3-right w3-light-gray"
			style="margin-right: 250px; margin-bottom: 120px;">Submit</button>
	</form>
</body>

</html>