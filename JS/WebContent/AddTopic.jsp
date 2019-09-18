<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@include file="header.jsp" %>
<div class="w3-container">
  
  <div class="w3-card-4">
    <div class="w3-container w3-green">
      <h2>Add Topic</h2>
    </div>

<form action="topicAddController" style="margin: 4%">
	<center>
			Topic Added:<select style="width: 120px; margin: 1%;" >
			<c:forEach  var="index" items="${Topic}">
  				<option >${index.topic}</option>
  			</c:forEach>
  			</select><br>
				Topic :<input  type="text" name="Topic" ><br> 
			    <input  type="submit" value="Add Topic">
	</center>
</form>
</div>
</div>

</body>
</html>