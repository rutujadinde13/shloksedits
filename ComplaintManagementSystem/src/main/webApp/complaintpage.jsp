<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Complaint Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
  font-family: 'Montserrat', sans-serif;
}

body{
  background: linear-gradient(
     105deg,
     #88beee ,
     #0a2e73
 );
}
</style>
</head>
<body>
	<h2>Complaint Form</h2>
	<form action="/customer/complaintAdd" method="post">
		<br> <br>
		<h4>Complaint</h4>
		<textarea rows="8" cols="50" id="description"
			name="complaintDescription"
			placeholder="Add your complaint here......" required></textarea>
		<br> <br>
		<button onclick="addcomplaint">File Complaint</button>

		<script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous">
			
		</script>


		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			crossorigin="anonymous">
			
		</script>

		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

		<script>
			let registerComplaint = false;
			$(document).ready(function() {
				$('#addcomplaint').click(function(event) {
					event.preventDefault();
					let un = {
						"description" : $("#complaintDescription").val()
					}

					$.ajax({

						type : "POST",
						contentType : 'application/json; charset=utf-8',
						dataType : 'json',
						url : 'addcomplaint',
						data : JSON.stringify(un),
						success : function(result) {
							if (result) {
								$("#description").show();
							} else {
								$("#error").show();
							}

						},
						error : function(xhr, status, error) {
							console.log(error)
						},
					});
				})
			})
		</script>
	</form>
</body>
</html>