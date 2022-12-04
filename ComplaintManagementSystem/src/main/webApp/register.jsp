<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>

<style>
.req {
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
	min-height: 80vh;
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

.form_wrap .input_grp  input[type="text"] {
	width: 165px;
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

.form_wrap .input_grp  input[type="tel"] {
	width: 165px;
}

.form_wrap  input[type="tel"] {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

.form_wrap  input[type="tel"]:focus {
	border-color: #063abd;
}

.form_wrap .input_grp  input[type="password"] {
	width: 165px;
}

.form_wrap  input[type="password"] {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

.form_wrap  input[type="password"]:focus {
	border-color: #063abd;
}

.form_wrap .input_grp  input[type="email"] {
	width: 165px;
}

.form_wrap  input[type="email"] {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

.form_wrap  input[type="email"]:focus {
	border-color: #063abd;
}

.form_wrap .input_grp  input[type="date"] {
	width: 165px;
}

.form_wrap  input[type="date"] {
	width: 100%;
	padding: 10px;
	outline: none;
	border-radius: 3px;
	border: 1.3px solid #9597a6;
}

.form_wrap  input[type="date"]:focus {
	border-color: #063abd;
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

input:invalid {
	border: 2px dashed red;
}

input:valid {
	border: 2px solid black;
}
</style>

</head>
<body>


	<div class="wrapper">

		<div class="registration_form">
			<!-- Title -->
			<div class="title">Registration Form</div>

			<!-- Form -->
			<form action="/customer/register" method="post" id="registerForm">
				<div class="form_wrap">
 
					<%
					if ((String) request.getParameter("error") != null) {
						String msg = (String) request.getParameter("error");
					%><h4 style="color: red"><%=msg%></h4>
					<%
					}
					%>
					<div class="input_wrap">

						<label for="username">Username <span class="req">*</span>
						</label> <input type="text" id="uname" name="customerUsername"> <span
							id="username_alert"></span>
					</div>

					<div class="input_wrap">
						<label for="name">Customer Full Name <span class="req">*</span></label>
						<input type="text" id="customerName" name="customerName"
							onkeyup="name_Validation()"> <span id="name_alert"></span>
					</div>

					<div class="input_wrap">
						<label for="contact">Mobile Number <span class="req">*</span></label>
						<input type="tel" id="contact" name="contact" minlength="10"
							maxlength="10" onkeyup="mobileNumber_Validation()"
							pattern="[0-9]{10}"> <span id="number_alert"></span>
					</div>
					<div class="input_wrap">
						<label for="email">Email <span class="req">*</span></label> <input
							type="email" id="email" name="email" onkeyup="email_Validation()">
						<span id="email_alert"></span>
					</div>
					<div class="input_wrap">
						<label for="dateOfBirth">Date Of Birth<span class="req">*</span></label>
						<input type="date" id="dateOfBirth" name="dateOfBirth"> <span
							id="birthdate_alert"></span>
					</div>

					<div class="input_wrap">
						<label for="password">Password<span class="req">*</span></label> <input
							type="password" id="password" name="password"> <span
							id="password_alert"></span>

					</div>
					<input type="checkbox" id="showPassword" /> <label
						for="showPassword">Show password</label>
					<!-- Submit button -->
					<div class="input_wrap">
						<input type="submit" value="Register Now" class="submit_btn">
					</div>

					<div>
						<p>
							Already have an account? <a href="/loginuser">Sign in</a>
						</p>
					</div>
				</div>
			</form>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>


	<script>
	
function email_Validation()
{
  value = document.getElementById('email').value;
  apos=value.indexOf("@"); 
  dotpos=value.lastIndexOf(".");
  lastpos=value.length-1;
  if (apos < 1 || dotpos-apos < 2 || lastpos-dotpos > 3 || lastpos-dotpos < 2){
	  document.getElementById("email_alert").style.color = "red";
      document.getElementById("email_alert").innerHTML = "Invalid Email Address";
      return false;
    } else {
    	 document.getElementById("email_alert").style.color = "green";
         document.getElementById("email_alert").innerHTML = "valid Email Address";
      return true;
  }
}

function onlyLetters(Name) {
	var regx = /^[a-zA-Z][a-zA-Z ]*$/;
	return !regx.test(Name);
}


function name_Validation(){
	
	
	
    var regName = /^[a-zA-Z]+ [a-zA-Z]+$/; 
    var regName1=/^[A-Za-z]+/;
    var name = document.getElementById('customerName').value;
    
    
/*     if(!(regName.test(name)||regName1.test(name))|| name==="") */
    
    if(onlyLetters(name))
    {
    	document.getElementById('name_alert').style.color = 'red';
		document.getElementById('name_alert').innerHTML = 'Please Enter Your Full Name (first & last name) Without Any Number';
        return false;
    }else{
    	console.log('reg match')
    	document.getElementById('name_alert').style.color = 'green';
		document.getElementById('name_alert').innerHTML = 'Your Name Is Matched';
        return true;
    }
}
    
    function mobileNumber_Validation(){
    var regName=/^\d{10}$/;
    var number=document.getElementById('contact').value;
  
    if(!(regName.test(number))){
    	document.getElementById('number_alert').style.color='red';
    	document.getElementById('number_alert').innerHTML='Please Enter Valid Number';
    	return false;
    }else{
    	document.getElementById('number_alert').style.color='green';
    	document.getElementById('number_alert').innerHTML='valid number';
    	return true;
       }
}
    
    
    $('#registerForm').on('submit',function(event){
    	event.preventDefault();
    	
    	console.log(checkforblank())
    	
     if(checkforblank())
    		{
    		$(this).unbind('submit').submit()
    		} 
    		
    })
    
    
$(function(){
	var dtToday=new Date();
	var month=dtToday.getMonth()+1;
	var day=dtToday.getDate();
	var year=dtToday.getFullYear();
	
	if(month<10)
	month='0'+month.toString();
	if(day<10)
	day='0'+day.toString();
	var maxdate=year+'-'+month+'-'+day;
	$('#dateOfBirth').attr('max',maxdate);
})
 

document.getElementById('showPassword').onclick = function() {
    if ( this.checked ) {
       document.getElementById('password').type = "text";
    } else {
       document.getElementById('password').type = "password";
    }
};


function checkforblank(){
	
	
	console.log("heck for blank method calll")
	let hasError=true
	if(document.getElementById('uname').value==""){
	
		document.getElementById('username_alert').style.color='red';
		document.getElementById('username_alert').innerHTML='Please fill this Field';
		hasError=false;
	}
	if(document.getElementById('customerName').value==""){
		document.getElementById('name_alert').style.color='red';
		document.getElementById('name_alert').innerHTML='Please fill this Field';
		hasError=false;
	}
	if(document.getElementById('contact').value==""){
		document.getElementById('number_alert').style.color='red';
		document.getElementById('number_alert').innerHTML='Please fill this Field';
		hasError=false;
	}
	if(document.getElementById('email').value==""){
		document.getElementById('email_alert').style.color='red';
		document.getElementById('email_alert').innerHTML='Please fill this Field';
		hasError=false;
	}
	if(document.getElementById('dateOfBirth').value==""){
		document.getElementById('birthdate_alert').style.color='red';
		document.getElementById('birthdate_alert').innerHTML='Please fill this Field';
		hasError=false;
	}
	if(document.getElementById('password').value==""){
		document.getElementById('password_alert').style.color='red';
		document.getElementById('password_alert').innerHTML='Please fill this Field';
		hasError=false;
	}
	return hasError
}

$("#uname").focus(function()
		{ $('#username_alert').hide() });
</script>
</body>
</html>