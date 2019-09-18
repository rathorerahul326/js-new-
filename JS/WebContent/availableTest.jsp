<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.JavaSolTest.Dto.*,com.JavaSolTest.Dao.*,com.JavaSolTest.Service.*,java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Student Profile</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="profileCSS/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="profileCSS/coin-slider.css" />
<script type="text/javascript" src="profileJS/cufon-yui.js"></script>
<script type="text/javascript"
	src="profileJS/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="profileJS/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="profileJS/script.js"></script>
<script type="text/javascript" src="profileJS/coin-slider.min.js"></script>
<style>
table, td, th {
	border-collapse: collapse;
	width: 60%;
	margin-left: 200px;
	border: 1px solid black;
	padding: 8px;
}

body {
	color: black;
	background-image:
		url("http://andygrimshaw.com/wp-content/uploads/2015/10/White-Blocks-Sphere.jpg");
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
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">

					<h1>
						<a href="studentProfile.jsp">Student<span> Profile</span> <small>Welcome
								 ${stuinfo.getName() }</small></a>
					</h1>
				</div>
				<div class="clr"></div>
				<div class="menu_nav">
					<div class="scrollmenu">
						<ul>

							<li><a href="studentProfile.jsp"><span>ViewProfile</span></a></li>
							<li><a href="studentedit.jsp"><span>Update
										Profile</span></a></li>
							<li><a href="teststart"><span>Available Test</span></a></li>
							<li><a href="scoreCard"><span>Score Card</span></a></li>
							<!--      <li><a href="adminhome.jsp"><span>Home Page</span></a></li>
          <li><a href="about.jsp"><span>About Us</span></a></li>
          <li><a href="contact.jsp"><span>Contact Us</span></a></li> -->
							<li><a href="logout"><span>Logout</span></a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- available Test here  -->

	<table>
		<center>
			<h2>Available test</h2>
		</center>
		<tr>
			<td><span> Date</span></td>
			<td><span> Test_Name</span></td>
			<td><span> Total_Question</span></td>
			<td><span> Start_Time</span></td>
			<td><span> End_Time</span></td>
			<td><span> Duration/Minute</span></td>
			<td><span> Action</span></td>
		</tr>

		<c:forEach items="${mylist}" var="testDetails">
			<tr>
				<td><span> ${testDetails.getDate1()}</span></td>
				<td><span> ${testDetails.getName()}</span></td>
				<td><span> ${testDetails.getTotal()}</span></td>
				<td><span> ${testDetails.getStartTime()}</span></td>
				<td><span> ${testDetails.getEndTime()}</span></td>
				<td><span> ${testDetails.getDuration()}</span></td>



				<td><span><a
	href="starttestcontroller?&fid=${testDetails.getFtid()}&testid=${testDetails.getTestId()}
	&duration=${testDetails.getDuration()}&total=${testDetails.getTotal()}
	&testname=${testDetails.getName()}"style="text-decoration:none">${testDetails.status}</a></span></td>
			</tr>

		</c:forEach>
	</table>
	</br>
	</br> 
	<center>
		<h3>
			<b><i>${notest}</i></b>
		</h3>
	</center>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<br />
	<br />
	<br />
	<br />

	<br />
	<br />
	<br />
	<br />

	<br />
	<br />
	<br />
	<br />


	<div class="clr"></div>
	<div class="footer">
		<div class="footer_resize">
			<p class="lf">
				&copy; Copyright <a href="#">ONLINE TEST</a>.
			</p>
			<p class="rf">
				Design by JAVA SOLUTION<a href="http://www.dreamtemplate.com/"></a>
			</p>
			<div style="clear: both;"></div>
		</div>
	</div>

</body>
</html>