	<!DOCTYPE html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
	</head>

	<body style="margin-left: auto; margin-right: auto;">
		<table border="1" class="styled-table" >
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
	            <td><a href="/admin/updateComplaint?complaintId=${complaint.complaintId}">Edit</a></td>
	        </tr>
	    </c:forEach>
	</table>
	</body>
	</html>