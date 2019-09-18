<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="my.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var topicID;
	//$("#SubTopicSelect").find("option").remove();
	$("#TopicSelect").change(function(){
		//alert("Event called");
		//alert($(this).find(':selected').val());
		$("#SubTopicSelect").find("option").remove();
		//$("#tid ").find("option").remove();
    	topicID=$(this).find(':selected').val();
   		// alert($(this).find(':selected').text());//this will give the selected option's text
    	SubTopicSelected(topicID);
	});
	$("#SubTopicSelect").change(function(){
		//$("#SubTopicSelect").find("option").remove();
		var stid=$("#SubTopicSelect").find(':selected').val()
		//alert(stid);
		$('#QuestionTable').find('tr').remove();
		GetQuestion(stid);
		
	});
	var SubTopicSelected=function(topicID){
			$.get("subTopicGetController",{'TopicID' : topicID},function(data, textStatus){		
		                var json=JSON.parse(data);
		                //alert(json);
		                $('#SubTopicSelect').append($('<option value="" disabled selected hidden>').text('Choose subtopic... '));
		                $.each(json,function(i,item){ 	
		                		$('#SubTopicSelect').append($('<option>').text(item.Subtopic).attr('value',item.stid));
		                });
		  	});
		}
	var GetQuestion=function(stid){
		$.get("questionGetController",{'SubTopicID' : stid},function(data, textStatus){		
            var json=JSON.parse(data);
            //alert(json);
            var html='';
            $.each(json,function(i,item){
            	//$('#divQuestion').append($('<option>').text(item.Subtopic).attr('value',item.stid));
            	if(i==0){
            		html='<tr class="w3-red"><th> S.no</th>'
                        +'<th>Questions</th>'
                        +'</tr>';
            	}
            	var no=i+1;
            	html+='<tr><td>Q'+no+'.</td>'
            			+'<td>'+item.Question+'</td></tr>';
            		//$('#QuestionTable').append($('<tr><td> ').text("Q"+no+". "+item.Question).attr('value',item.Question));
            
            });
            $('#QuestionTable').append(html);
		});
	}
	
});
</script>

<style type="text/css">
input[type=text] { width: 10%; }
/* textarea {
	width: 30%;
} */
</style>
</head>
<body>
<%@include file="header.jsp" %>
<center>
<div class="w3-container">
  
  <div class="w3-card-4">
    <div class="w3-container w3-green">
      <h2>Add Question</h2>
    </div>

<form action="addQuestionController"  style="margin: 2%">

	Topic:<select id="TopicSelect" name="topicId" pl>
		<option value="" disabled selected hidden>Please Choose...</option>
		<c:forEach  var="dto" items="${Topic}" >
  				<option value="${dto.topicId}">${dto.topic}</option>
  		</c:forEach>
  		</select><br>
				
		SubTopic:<select id="SubTopicSelect" name="stid" style="width: 120px; margin: 1%;">
				<option value="" disabled selected hidden>Please Choose...</option>
						
				</select><br>
				
		<label  style="align:left;">Add Question</label><br>
		
				<textarea  rows="5" cols="80" class="w3-input" name="Question"></textarea></br> 

				<input type="radio" name="Ans" value="A" checked="checked">A<input  type="text" name="A">
				<input type="radio" name="Ans" value="B">B<input type="text"name="B">
				<input type="radio" name="Ans" value="C">C<input type="text"name="C">
				<input type="radio" name="Ans" value="D">D<input type="text" name="D"></br>
				<!-- class="w3-input w3-animate-input" class="w3-input-->
				Marking:<select name="marking" style="margin: 1%">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="5">5</option>
				</select><br>
				
			    <input id="Question" type="submit" value="Add Question">
</form>
<table id="QuestionTable" class="w3-table w3-striped" style="width: 40%;">
	
</table>
</div>
</div>

</center></body>
</html>