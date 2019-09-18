
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" href="my.css">
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#TopicSelect :selected').each(function(i, sel){ 
	    GetSubtopictTable();
	});
	/*$("p").click(function(){
        alert("The paragraph was clicked.");
    });*/
	$("#getSubtopic").click(function(){
		//alert("Click Eve");
		$(this).remove();
		$("#hiddenDiv").show();
		var jsonarray=[];
		$('#TopicSelect :selected').each(function(i, sel){ 
		    jsonarray.push({TopicId:$(sel).val()});
		    
		});
		var array=JSON.stringify(jsonarray);
		GetSubtopictTable(array);
		//$("#hiddenDiv").hide();
	});
	
	var GetSubtopictTable=function(array){
		$.get("createTestSubtopicController",{"json":array},function(data){
			var json=JSON.parse(data);
			var html="";
			var hidden="";
			$.each(json,function(i,item){
				hidden+='<input type="hidden" name="subtopicid" value="'+item.stid+'" >';
				html+='<tr><td>'
					+item.Subtopic
					+'</td><td><input type="text" name="question"></td>'
					+'<td><input type="text" disabled="disabled" value="'+item.noq+'" ></td></tr>';
			});
			$('#hidden').append(hidden);
			$('#SubTable').append(html);
		});
	}
});
</script>
</head>
<body>
<%@ include file="header.jsp"%>
<center>
<div class="w3-container">
  
  <div class="w3-card-4">
    <div class="w3-container w3-green">
      <h2>Create  Test</h2>
    </div>

<form action="createTestAddController" method="post" style="margin: 3%; " class="w3-container" >
	Test Name<input class="w3-input" type="text" name="TestName" style="width: 20%"><br>
	<label>Select Topic</label><br>
	<select style="display: inline-block; margin: 2%; " id="TopicSelect" multiple="multiple" name="TopicSelect">
	<c:forEach var="dto" items="${Topic}" >
		<option  value="${dto.topicId}">${dto.topic}</input></option>
	</c:forEach>
	</select><br>
	
	No. of Questions:<input class="w3-input" type="text" name="Number" style="width: 10%;"><br>
	<input type="button" id="getSubtopic" value="Add Subtopic"> <br>
	
	<div  id="hiddenDiv" style="display:none;">
	<table id="SubTable"  class="w3-table w3-striped" style="width: 70%;">
		<tr class="w3-red"><th> SubTopics</th>
			<th>  No. of Question(per Subtopic)</th>
			<th>  Total(Subtopic)</th>
		</tr>
	</table><br>
	Time Period:<input type="text" name="Time"><br>
	<input  type="submit" value="Create Test"  style="margin: 3%">
	
	</div>
	<div id="hidden">
	</div>
	
</form>
</div></div>

</center>
</body>
</html>