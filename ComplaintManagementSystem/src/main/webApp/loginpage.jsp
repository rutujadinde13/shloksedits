<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Login</title>
<style>
.req,.error {
    color: red;
}
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

.wrapper{
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  display: flex;
}

.registration_form{
  border-radius: 5px;
  width: 400px;
  background: white;
  padding: 25px;
}

.registration_form .title{
  color: white;
  background:rgb(13, 98, 215);
  letter-spacing: 2px;
  font-weight: 700;
  text-align: center;
  font-size: 25px;
  text-transform: uppercase;
  margin-top: -25px;
  margin-left:-25px;
  margin-right:-25px;
}

.form_wrap{
  margin-top: 35px;
}

.form_wrap .input_wrap{
  margin-bottom: 15px;

  
}

.form_wrap .input_wrap:last-child{
  margin-bottom: 0;
}

.form_wrap .input_wrap label{
  margin-bottom: 3px;
  color: #1a1a1f;
  display: block;
}

.form_wrap .input_grp{
  display: flex;
  justify-content: space-between;
}

.form_wrap .input_grp  input[type="text"]{
  width: 165px;
}

.form_wrap  input[type="text"]{
  width: 100%;
  padding: 10px;
  outline: none;
  border-radius: 3px;
  border: 1.3px solid #9597a6;
}

.form_wrap  input[type="text"]:focus{
  border-color: #063abd;
}

.form_wrap ul{
  padding: 8px 10px;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  border:1px solid rgb(115, 185, 235);
  width:70%;
  background: rgb(206, 238, 242);
  margin-left: 15%;
}

.form_wrap ul li:first-child{
  margin-right: 15px;
}

.form_wrap ul .radio_wrap{
  position: relative;
  margin-bottom: 0;
}

.form_wrap ul .radio_wrap .input_radio{
  position: absolute;
  top: 0;
  right: 0;
  opacity: 0;
}

.form_wrap ul .radio_wrap span{
  display: inline-block;
  font-size: 17px;
  padding: 3px 15px;
  border-radius: 15px;
  color: #101749;
}

.form_wrap .input_radio:checked ~ span{
  background: #105ce2;
  color:white;
}

/* Submit Button */
.form_wrap .submit_btn{
  font-size:17px;
  border-radius: 3px;
  text-transform: uppercase;
  letter-spacing: 2px;
  cursor: pointer;
  width: 100%;
  background: #0d6ad7;
  padding: 10px;
  border: 0;
  color:white;
}

/* Button Hover effect */
.form_wrap .submit_btn:hover{
  background: #051c94;
}
</style>
</style>
</head>
<body>
<%-- <% if((String)request.getParameter("errormsg")!=null)
{
	String message=(String)request.getParameter("errormsg");
%>
	<h4 class="error"><%=message%></h4>
<%} %>
<form action="loginuser" method="post">
	<div>
	Username: <span class="req">*</span>
	<br>
	<input name="username" type="text" placeholder="enter username" required>
	<br>
	<br>
	Password:<span class="req">*</span>
	<br>
	<input name="password" type="password" placeholder="enter password" required>
	<br>
	<br>
	<button type="submit">Login</button>
	</div>
</form> --%>

<div class="wrapper">

 <div class="registration_form">
<!-- Title -->
  <div class="title">
    Login Form
  </div>

<!-- Form -->
 <form action="loginuser" method="post">
  <div class="form_wrap">
  

<!-- Frist name input Place -->
     <div class="input_wrap">
  	<label for="username">username</label><span class="req">*</span>
  	<input type="text" id="uname" name="username" required>
     </div>

<!-- Email Id input Place -->
 <div class="input_wrap">
  <label for="password">Password</label><span class="req">*</span>
  <input type="text" id="password"  name="password" required>
 </div>

<!-- Submit button -->
 <div class="input_wrap">
   <input type="submit" value="Login" class="submit_btn">
 </div>

</div>
</form>
</div>
</div>
</body>
</html>