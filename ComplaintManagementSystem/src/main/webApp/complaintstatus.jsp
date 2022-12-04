<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>COMPLAINT STATUS</title>
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
	margin-top: 50px;
	width: 70%;
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
	<h1>Complaint Status</h1>
	<table border="1" class="styled-table" aria-describedby="mydesc">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>Status</th>
			<th>Comments</th>
		</tr>
		<c:forEach items="${complaintsStatusList}" var="complaintStatus">
			<tr class="active-row">
				<td>${complaintStatus.complaintId}</td>
				<td>${complaintStatus.complaintDescription}</td>
				<td>${complaintStatus.support.status}</td>
				<td>${complaintStatus.support.comments}</td>
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