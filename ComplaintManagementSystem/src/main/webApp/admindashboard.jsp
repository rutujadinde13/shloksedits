<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
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

h1 {
	margin-top: 10px;
	text-align: center;
	font-size: 50px;
}

.button1 {
	font-size: 20px;
}

input[type=submit] {
	background-color: #04AA6D;
	border: none;
	color: white;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body style="margin-left: auto; margin-right: auto;">
	<h1>Customer Complaints</h1>
	<table aria-describedby="mydesc" border="1" class="styled-table">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>Status</th>
			<th>Comments</th>
			<th>Customer Id</th>
		</tr>
		<c:forEach items="${listOfComplaints}" var="complaints">
			<tr class="active-row">
				<td>${complaints.complaintId}</td>
				<td>${complaints.complaintDescription}</td>
				<td>${complaints.support.status}</td>
				<td>${complaints.support.comments}</td>
				<td>${complaints.customer.customerId}</td>
				<td><a
					href="/admin/updateComplaint?complaintId=${complaints.complaintId}">UPDATE</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<form action="/logout" method="post" class="button1">
		<input type="submit" value="Logout" />
	</form>
	<br>
	<br>
	<button>
		<a href="/export/excel">export data to excel</a>
	</button>
</body>
</html>