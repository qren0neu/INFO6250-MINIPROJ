<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="5;url=./" />
<title>Failure</title>
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
		<img src="https://i.imgur.com/qIufhof.png" />

		<h1>
			<span>Oops</span> <br /> Something wrong happened
		</h1>
		<p>
			<%=request.getAttribute("error")%>
		</p>
		<p>Go back to main page in 5 seconds...</p>
		<p class="info">
			Illustration taken from <a
				href="https://www.kapwing.com/404-illustrations" target="_blank">kapwing.com</a>
		</p>
		<p class="info">
			Powered by <a href="https://codepen.io/sheikh_ishaan/pen/abzgRxe"
				target="_blank">CodePen</a>, Author: Ishaan Sheikh
		</p>
	</div>
</body>

</html>