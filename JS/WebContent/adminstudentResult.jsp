<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			    pageEncoding="ISO-8859-1"%>
			     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
			<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
	
	table, td, th {
	border-collapse: collapse;
	width: auto;
	margin-left: 50px;
	border: 1px solid black;
	padding: 8px;
}
	
	</style>
	
	
			</head>
			<body>
			<%@include file="header.jsp" %>
			<div class="w3-container">
			  
			  <div class="w3-card-4">
			    <div class="w3-container w3-green">
			      <h2>Student Records</h2>
			    </div>

			<form action="" style="margin: 4%">
				<center>
						
						
						
							<table>
		
		
		
		<tr>
			
			<td><span> Test Name</span></td>
			<td><span> Date</span></td>
			<td><span>Appeared Student</span></td>
			<td><span>Status</span></td>
			
		</tr>

		<c:forEach items="${studentRecords}" var="testDetails">
			<tr>
				<td><span> ${testDetails.getTest_name()}</span></td>
				<td><span> ${testDetails.getDate() }</span></td>
				<td><span> ${testDetails.getCount() }</span></td>
				<td><span> <a href="viewAllStudentrecords?testname=${testDetails.getTest_name()}&date=${testDetails.getDate() }"style="text-decoration:none">View</a></span></td>
			</tr>

		</c:forEach>
	</table>
					
      
					
						
				</center>
			</form>
			</div>
			</div>

			</body>
			</html>
	
	