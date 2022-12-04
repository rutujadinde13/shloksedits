<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Login</title>
<style>
.req, .error {
	color: red;
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

.wrapper {
	justify-content: center;
	align-items: center;
	min-height: 85vh;
	display: flex;
}

.registration_form {
	border-radius: 5px;
	width: 400px;
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
	margin-bottom: 3px;
	color: #1a1a1f;
	display: block;
}

.form_wrap .input_grp {
	display: flex;
	justify-content: space-between;
}

.form_wrap .input_grp  input[type="text"], input[type="password"] {
	width: 165px;
}

.form_wrap  input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

.form_wrap  input[type="text"], input[type="password"] :focus {
	border-color: #063abd;
}

.form_wrap ul {
	padding: 8px 10px;
	border-radius: 20px;
	display: flex;
	justify-content: center;
	border: 1px solid rgb(115, 185, 235);
	width: 70%;
	background: rgb(206, 238, 242);
	margin-left: 15%;
}

.form_wrap ul li:first-child {
	margin-right: 15px;
}

.form_wrap ul .radio_wrap {
	position: relative;
	margin-bottom: 0;
}

.form_wrap ul .radio_wrap .input_radio {
	position: absolute;
	top: 0;
	right: 0;
	opacity: 0;
}

.form_wrap ul .radio_wrap span {
	display: inline-block;
	font-size: 17px;
	padding: 3px 15px;
	border-radius: 15px;
	color: #101749;
}

.form_wrap .input_radio:checked ~ span {
	background: #105ce2;
	color: white;
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

h1 {
	margin-top: 10px;
	text-align: center;
	font-size: 50px;
}
</style>

</head>
<body>


	<div class="wrapper">
		<div class="registration_form">
			<!-- Title -->
			<div class="title">Login Form</div>
			<h5 style="color: red">${errorMsg}</h5>
			<!-- Form -->
			<form action="loginuser" method="post" name="loginForm">
				<div class="form_wrap">


					<!-- Frist name input Place -->
					<div class="input_wrap">
						<label for="username">username<span class="req">*</span> </label><input
							type="text" id="uname" name="username" required>
					</div>

					<!-- Email Id input Place -->
					<div class="input_wrap">
						<label for="password">Password<span class="req">*</span></label> <input
							type="password" id="password" name="password" required>
					</div>

					<!-- Submit button -->
					<div class="input_wrap">
						<input type="submit" value="Login" class="submit_btn">
					</div>

					<div>
						<p>
							For New User <a href="/customer/register">Register</a>
						</p>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>