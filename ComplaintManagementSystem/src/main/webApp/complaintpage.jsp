<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

.wrapper {
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	display: flex;
}

.registration_form {
	border-radius: 5px;
	width: 470px;
	background: white;
	padding: 25px;
}

.registration_form .title {
	color: white;
	background: rgb(13, 98, 215);
	letter-spacing: 2px;
	font-weight: 700;
	text-align: center;
	font-size: 25px;
	text-transform: uppercase;
	margin-top: -25px;
	margin-left: -25px;
	margin-right: -25px;
}

.form_wrap {
	margin-top: 35px;
}

.form_wrap .input_wrap {
	margin-bottom: 15px;
}

.form_wrap .input_wrap:last-child {
	margin-bottom: 0;
}

.form_wrap .input_wrap label {
	margin-bottom: 5px;
	margin-right: 7px;
	color: #1a1a1f;
	display: block;
}

.form_wrap  input[type="text"] {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

.form_wrap  input[type="text"]:focus {
	border-color: #063abd;
}

.form_wrap textarea:focus {
	border-color: #063abd;
}

.form_wrap  textarea {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

/* Submit Button */
.form_wrap .submit_btn {
	font-size: 17px;
	border-radius: 3px;
	text-transform: uppercase;
	letter-spacing: 2px;
	cursor: pointer;
	width: 100%;
	background: #0d6ad7;
	padding: 10px;
	border: 0;
	color: white;
}

/* Button Hover effect */
.form_wrap .submit_btn:hover {
	background: #051c94;
}

input[type=submit] {
	background-color: rgb(13, 98, 215);
	border: none;
	color: white;
	padding: 10px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

.req {
	color: red;
}
#the-count {
  float: right;
  padding: 0.1rem 0 0 0;
  font-size: 0.875rem;
}
</style>
</head>
<body>

	<div class="wrapper">

		<div class="registration_form">
			<!-- Title -->
			<div class="title">Complaint Form</div>





			<!-- Form -->
			<form action="/customer/complaintAdd" method="post"
				id="complaintForm">
				<div class="form_wrap">

					<div class="input_wrap">
						<select id="planName" onchange="getPlanProvider(this)">
							<option>Select Plan Name</option>


							<%
							List<String> plans = (List<String>) request.getAttribute("plansName");
							for (String s : plans) {
							%>
							<option onclick="getPlanProvider(<%=s%>)"><%=s%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="input_wrap">
						<select id="planProvider" onchange="getPlanDescription(this)">
							<option>Select Plan Provider</option>
						</select>
					</div>
					<div class="input_wrap">
						<select id="planDescription" onchange="getPlanDuration(this)">
							<option>Select Plan Description</option>
						</select>
					</div>
					<div class="input_wrap">
						<select id="planDuration" onchange="getPlanAmount(this)">
							<option>Select Plan Duration</option>
						</select>
					</div>
					<div class="input_wrap">
						<select id="planAmount">
							<option>Select Plan Amount</option>
						</select>
					</div>
					<div class="input_wrap">
						<label for="description">Complaint Description <span class="req">*</span></label>
						<textarea rows="4" cols="40"
							onkeypress="if (this.value.length >= 256) { return false; }"
							maxlength="255" id="complaintDescription"
							name="complaintDescription"
							placeholder="Add your complaint here......" required></textarea>
						 <div id="the-count">
							<span id="current">0</span> <span id="maximum">/ 255</span>
							</div>
					</div>
					<br>
					<div class="input_wrap">
						<input type="submit">
					</div>
				</div>
			</form>
			<br> <a href="/"><button>Dashboard</button></a> <br> <br>
			<form action="/logout" method="post">
				<input type="submit" value="Logout" />
			</form>
		</div>
	</div>
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
					 
					let allData={}
					
					let registerComplaint = false;
					$('#complaintForm')
							.on(
									'submit',
									function(event) {
										event.preventDefault();
										console.log("submit button clicked")
										console.log($('#complaintDescription').val());
										allData={...allData,"complaintDescription": $("#complaintDescription").val()}

										$.ajax({
													type : "POST",
													contentType : 'application/json; charset=utf-8',
													dataType : 'json',
													url : '/customer/complaintAdd',
													data : JSON.stringify(allData),
													success : function(result) {
														console.log(result)
														if (result.message = "success") {
															window.location
																	.replace('http://localhost:8084/customer/complaintDesc')
														}
													},
													error : function(xhr, status, error) {
														console.log(error)
													},
												});
									})
							
									
									
						function getPlanProvider(planName){
						let temp=planName
						var text = temp.options[temp.selectedIndex].text;						
						allData={...allData,"planName":text}
						let planData={
								"planName":text
						
						}
						
						$.ajax({
							type : "POST",
							contentType : 'application/json; charset=utf-8',
							dataType : 'json',
							url : '/customer/planProvider',
							data : JSON.stringify(planData),
							success : function(result) {	
								$('#planProvider').html('')
									 $('#planProvider').append('<option id="selectprovider">Select Provider</option>');
							$.each(result.data,function(index,item){
								 $('#planProvider').append('<option>'+item+'</option>');
								
							})
							},
							error:function(xhr, status, error){
								
							},
							
						})
					}
					
					
					
						function getPlanDescription(planProvider){
							$('#selectprovider').attr('disabled', true);
							
							let temp=planProvider
							var text=temp.options[temp.selectedIndex].text;
							allData={...allData,"planProvider":text}
							console.log("submit button clicked")
							let planProviderData={
									"planProvider":text
							}
							$.ajax({
								type:"POST",
								contentType : 'application/json; charset=utf-8',
								dataType : 'json',
								url : '/customer/planDescription',
								data:JSON.stringify(planProviderData),
								success:function(result){
									$('#planDescription').html('')
									 $('#planDescription').append('<option id="selectprovider">Select Description</option>');
									$.each(result.data,function(index,item){
										$('#planDescription').append('<option>'+item+'</option>');
									})
								},
								error:function(xhr, status, error){
									
								},
							})
						}
						
						
						
						function getPlanDuration(planDescription){
							
							$('#selectprovider').attr('disabled', true);
							let temp=planDescription
							var text=temp.options[temp.selectedIndex].text;
							
							console.log("submit button clicked")
							let planDescriptionData={
									"planDescription":text
							}
							$.ajax({
								type:"POST",
								contentType : 'application/json; charset=utf-8',
								dataType : 'json',
								url : '/customer/planDuration',
								data:JSON.stringify(planDescriptionData),
								success:function(result){
								$('#planDuration').html('')
								$('#planDuration').append('<option id="selectprovider">Select Duration</option>');  
									$.each(result.data,function(index,item){
										
										$('#planDuration').append('<option>'+item+'</option>');
									})
									
								},
								error:function(xhr,status,error){
									
								},
							})
						}
						
					
						function getPlanAmount(planDuration){
							$('#selectprovider').attr('disabled', true);
							let temp=planDuration
							var text=temp.options[temp.selectedIndex].text;
							allData={...allData,"planDuration":text}
							console.log()
							
							$.ajax({
								type:"POST",
								contentType : 'application/json; charset=utf-8',
								dataType : 'json',
								url : '/customer/planAmount',
								data:JSON.stringify(allData),
								success:function(result){
									$('#planAmount').html('')
									$('#planAmount').append('<option id="selectprovider">Select Amount</option>'); 
									$('#planAmount').append('<option>'+result.data+'</option>');
									
								},
								error:function(xhr,status,error){
									
								},
							})
						}							
									
					
						$('textarea').keyup(function() {
						    
							  var characterCount = $(this).val().length,
							      current = $('#current'),
							      maximum = $('#maximum'),
							      theCount = $('#the-count');
							    
							  current.text(characterCount);
						});
	</script>
</body>
</html>