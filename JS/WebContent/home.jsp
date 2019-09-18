
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<a href="signup.jsp"><img border="0" alt="Home"
src="https://www.bnhcrc.com.au/sites/default/files/register-now-button-yellow.png"
		width="100" height="35"> </a>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Student login</title>
<style type="text/css">

input[type=text], select, textarea {
    width: 10%; /* Full width */
    padding: 12px; /* Some padding */  
    border: 1px solid #ccc; /* Gray border */
    border-radius: 4px; /* Rounded borders */
    box-sizing: border-box; /* Make sure that padding and width stays in place */
    margin-top: 6px; /* Add a top margin */
    margin-bottom: 16px; /* Bottom margin */
    resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}


input[type=password], select, textarea {
    width: 10%; /* Full width */
    padding: 12px; /* Some padding */  
    border: 1px solid #ccc; /* Gray border */
    border-radius: 4px; /* Rounded borders */
    box-sizing: border-box; /* Make sure that padding and width stays in place */
    margin-top: 6px; /* Add a top margin */
    margin-bottom: 16px; /* Bottom margin */
    resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

/* Style the submit button with a specific background color etc */
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type=submit]:hover {
    background-color: #45a049;
}



</style>
<style>
.button {
  border-radius: 4px;
  background-color: #grey;
  border: none;
  color: #black;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>








<style>
input:focus {
    background-color: grey;
}
div {
	margin: 50px 100px 100px 100px;
}

table {
	border-collapse: collapse;
}

td {
	padding-top: 1.0em;
	padding-bottom: 1.0em;
}

p {
	margin: 10px 90px 90px 100px;
}

body {
	background-image: url("http://andygrimshaw.com/wp-content/uploads/2015/10/White-Blocks-Sphere.jpg") ;
	 background-size: 1800px 1500px;
    background-repeat: no-repeat center center;
    
    padding: 0;
    -webkit-background-size: cover;
    background-size: cover;
    background-attachment: fixed;
    
    
}
</style>
</head>
<body>
<div>
<center>
	<h1>
		<b><img border="0" alt="Home" src="http://laoblogger.com/images/clip-art-home-10.jpg" width="50" height="50">Student Login</b>
	</h1>
</center>
	<form action="home" method="Post">
		<center>
			<div>
				<h3>${error1}${error2}</h3>

				
				<div class="container">
<h2>
    <input type="text" id="fname" name="id" placeholder="User Name.."></br>

    
    <input type="password" id="lname" name="pass" placeholder="Password.."></h2></br>

   <button class="button"><span>Login </span></button>

 
</div>
				
				<p>
				
					<input type="hidden" value="Login">
					</td>
					</tr>
				</p>
			</div>
			<h1>${registered}</h1>
		</center>
		</div>
	</form>
</body>
</html>
