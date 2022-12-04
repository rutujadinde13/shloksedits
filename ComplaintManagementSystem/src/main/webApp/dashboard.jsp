<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1" name="viewportikkjj">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
</head>
<body>

    <ul>
      <li><a class="active" href="/profile?customerId=${customerId}">Hello
      <b style="color:white;">${customerName}</b>
      </a></li>
      <li style="float:right"><a href="/logout">Logout</a></li>
    </ul>

	<h4>
		<a class="block" href="complaint">ADD COMPLAINT</a>
	</h4>
	<h4>
		<a class="block" href="complaintstatus">COMPLAINT STATUS</a>
	</h4>
	<h4>
		<a class="block" href="complainthistory">COMPLAINT HISTORY</a>
	</h4>

</body>
</html>

