<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var topicID;
	$("#TopicSelect").change(function(){
		//alert("Event called");
		//alert($(this).find(':selected').val());
		$("#SubTopicSelect").find("option").remove();
		//$("#tid ").find("option").remove();
    	topicID=$(this).find(':selected').val();
   		// alert($(this).find(':selected').text());//this will give the selected option's text
    	SubTopicSelected(topicID);
    	//alert(topicID);
	});
	var SubTopicSelected=function(topicID){
			$.get("subTopicGetController",{'TopicID' : topicID},function(data, textStatus){		
		                var json=JSON.parse(data);
		                //alert(json);
		                var html='<option value="" disabled selected hidden>Please Choose...</option>';
		                $.each(json,function(i,item){
		                	html+='<option value='+item.stid+'>'+item.Subtopic+'</option> ';
		                		//$('#SubTopicSelect').append($('<option>').text(item.Subtopic).attr('value',item.stid));
		                });
		                $('#SubTopicSelect').append(html);
		  	});
		}
});
</script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="w3-container">
  
  <div class="w3-card-4">
    <div class="w3-container w3-green">
      <h2>Add Subtopic</h2>
    </div>

<form id="SubtopicForm" action="subtopicAddController" style="margin: 2%">
	<center>
			Topic Added:<select id="TopicSelect" name="topicId">
			<option value="" disabled selected hidden>Please Choose...</option>
			<c:forEach  var="dto" items="${Topic}">
  				<option value="${dto.topicId}">${dto.topic}</option>
  			</c:forEach>
  			</select><br>
  			SubTopic Added:<select id="SubTopicSelect" style="width: 120px; margin: 1%;">
  			</select><br>
				Topic :<input  type="text" name="SubTopic" ><br>
			    <input  type="submit" value="Add Topic">
	</center>
	</form>
</div>
</div>
</body>
</html>