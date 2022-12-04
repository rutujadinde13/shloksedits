<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>All Complaints</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
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
	text-align: center;
}

table.styled-table {
	margin-left: auto;
	margin-right: auto;
	margin-top: 10px;
	width: 70%;
}

table, th, td {
	border: 1px solid black;
}

.center {
	margin-top: 10%;
	text-align: center;
}

input[type=submit] {
	background-color: #04AA6D;
	border: none;
	color: white;
	padding: 10px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body style="margin-left: auto; margin-right: auto;" class="center">
	<h1>Complaint History</h1>
	<br>
	<table border="1" class="styled-table" aria-describedby="mydesc">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>Status</th>
			<th>Comments</th>
		</tr>
		<c:forEach items="${complaintList}" var="complaint">
			<tr class="active-row">
				<td>${complaint.complaintId}</td>
				<td>${complaint.complaintDescription}</td>
				<td>${complaint.support.status}</td>
				<td>${complaint.support.comments}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<a href="/customer/dashboard"><button>Dashboard</button></a>
	<br />
	<br />
	<form action="/logout" method="post">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>