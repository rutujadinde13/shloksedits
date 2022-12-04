<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
.center {
	margin-top: 10%;
	text-align: center;
	line-height: 3em;
	font-size: 35px;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	list-style: none;
	font-family: 'Montserrat', sans-serif;
}

body {
	background-image: linear-gradient(95.2deg, rgba(173, 252, 234, 1) 26.8%,
		rgba(192, 229, 246, 1) 64%);
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0px;
	overflow: hidden;
	transition: 0.7s all;
	display: inline-block;
}

li {
	float: left;
}

li a {
	display: block;
	color: blue;
	font-size: 20px;
	text-align: center;
	padding: 10px 20px;
	text-decoration: none;
}

li a:hover {
	background-color: lightblue;
	color: white;
}
</style>
</head>
<body>
	<ul>
		<li><a href="/">Home</a></li>
		<li><a href="/loginuser">Login</a></li>
		<li><a href="/customer/register">Register</a></li>
	</ul>

	<div class="center">
		<h1>Complaint Management System</h1>
		<h1>Of</h1>
		<h1>Internet And DTH Service Provider</h1>

	</div>
</body>
</html>