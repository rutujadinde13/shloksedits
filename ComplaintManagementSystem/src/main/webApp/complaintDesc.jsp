<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
</head>
<body>

	<% String desc = (String) request.getSession().getAttribute("desc");
	Integer id = (Integer) request.getSession().getAttribute("id");
	String status = (String) request.getSession().getAttribute("status");
	String comment = (String) request.getSession().getAttribute("comment"); %>

	<TABLE BORDER="1">
	<table>
		<tr>
			<th>Complaint Id</th>
			<th>Description</th>
			<th>Status</th>
			<th>Comments</th>
		</tr>
		<tr>
			<td><%=id%></td>
			<td><%=desc%></td>
			<td><%=status%></td>
			<td><%=comment%></td>
		</tr>
	</table>

	<a href="/customer/dashboard">Dashboard</a>
</body>
</html>