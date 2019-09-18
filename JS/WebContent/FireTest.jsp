<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<center>
<div class="w3-container">
  
  <div class="w3-card-4">
    <div class="w3-container w3-green">
      <h2>Fire Test</h2>
    </div>

	<form action="fireTestSaveController" >  
		Test:<select name="Test_ID">
		<c:forEach var="test" items="${Test}" > 
			<option value="${test.test_id}">${test.test_name}</option>
		</c:forEach>
		</select><br>
		
		date:<input type="date" name="date"><br>
		Start Time:<input type="time" name="startTime" step="2"><br>
		End Time:<input type="time" name="endTime" step="1"><br>
		<input type="submit" value="Fire Test">
	</form>
	</div>
	</div>
</center>
</body>
</html>