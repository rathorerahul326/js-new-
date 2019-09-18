<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="my.css">
<title>Insert title here</title>
</head>
<script src="jquery-3.2.1.min.js"></script>
<script>
/*$(document).ready(function(){
	var tid;
	var stid;
	var topic1;
	var subtopic1;
	//Function to get Topic
	var TopicSelected=function(id){
		$.get("topicGetServlet", function(data, textStatus){		
		                	//alert("Done, with the following status: " + textStatus + ". Here is the response: " + data);
		                var json=JSON.parse(data);
		                var Topic='';
		                $.each(json,function(i,item){
		                	//alert(item.Topic);
		                	$('#TopicSelect[name="'+id+'"]').append($('<option>').text(item.Topic).attr('value', item));
		                	//Topic+='<option>'+item.Topic+'</option>';
		                });
		               // $("TopicSelect").html(state);
		  });
	}
	//Function to get Subtopic
	var SubTopicSelected=function(name,topic){
		$.get("subTopicGetServlet",{Topic : topic},function(data, textStatus){		
		                	//alert("Done, with the following status: " + textStatus + ". Here is the response: " + data);
		                var json=JSON.parse(data);
		                $.each(json,function(i,item){
		                	if(i==0){
		                		tid=item.tid;
		                		//alert(tid);
		                		}
		                	else{
		                	$('#SubTopicSelect[name="'+name+'"]').append($('<option>').text(item.Subtopic).attr('value', item.Subtopic));
		                	}
		                });
		  });
	}
	
var SubTopicID=function(Subtopic){
		$.get("subTopicIdGetServlet",{'Subtopic' : Subtopic },function(data, textStatus){			
		                	//alert("Done, with the following status: " + textStatus + ". Here is the response: " + data);
		                var json=JSON.parse(data);
		                var Topic='';
		                $.each(json,function(i,item){
		                	//alert(item.Topic);
		                	$('#TopicSelect[name="'+id+'"]').append($('<option>').text(item.Topic).attr('value', item));
		                	//Topic+='<option>'+item.Topic+'</option>';
		                });
		               // $("TopicSelect").html(state);
		  });
	}*/
	/*	//Event of Topic buttton in Header
	$("#TopicBtn").click(function(){
		 $("#TopicSelect").find("option").remove();
		$("div[id!='Topic']").hide();
		TopicSelected('Topic');
		$("#TopicDiv").slideDown(1000);	
	}); 
	//$("#TopicAdd").click(function(){
	//Event of TopicAdd Button Submit
	$( "#formTopic" ).submit(function( event ) {
		event.preventDefault();
		$.post("topicAddServlet",{ Topic : $('#TopicInput').val()} ,function(data, textStatus){     
			   });
		alert("Topic Added: " );
		$("#TopicSelect").find("option").remove();
		TopicSelected('Topic');
		//$("#TopicDiv").slideDown(1000);
	});
	//Event of SubTopic Button in Header
	$("#SubtopicBtn").click(function(){
		$("#TopicSelect[name='SubTopic']").find("option").remove();
		$("div[id!='SubTopicDiv']").hide();
		$("#SubTopicDiv").slideDown(1000);
		TopicSelected('SubTopic');	
		
	});
	//Event of Geting Subtopic from Db
	$("#TopicSelect[name='SubTopic']").change(function(){
		//alert("changed Event Called");
		$("#SubTopicSelect[name='SubTopic']").find("option").remove();
	    topic1=$(this).find(':selected').text();
	   // alert($(this).find(':selected').text());//this will give the selected option's text
	    //alert(topic1);
	    SubTopicSelected('SubTopic',topic1);
	    //alert(tid);
	});
	//Event of adding Subtopic to Db
	$( "#formSubtopic" ).submit(function( event ) {
		event.preventDefault();
		//alert(tid);
		$.post('subtopicAddServlet',{ SubTopic : $('#SubTopicInput').val(),'tid':tid},function(data, textStatus){     
			   });
		alert("SubTopic Added: " );
		$("#SubTopicSelect").find("option").remove();
		SubTopicSelected('SubTopic',topic1);
		//$("#TopicDiv").slideDown(1000);
	});
	//Event when add question btn clicked
	$("#QuestionsBtn").click(function(){
		$("#TopicSelect[name='Question']").find("option").remove();
		$("div[id!='Question']").hide();
		$("#QuestionDiv").slideDown(1000);
		TopicSelected('Question');	
	});
	//Event when topic select in Add question
	$("#TopicSelect[name='Question']").change(function(){
		$("#SubTopicSelect[name='Question']").find("option").remove();
	    topic1=$(this).find(':selected').text();
	    SubTopicSelected('Question',topic1);
	});
	//Event When subtopic selected in Add Question
	$("#SubTopicSelect[name='Question']").change(function(){
		//$("#SubTopicSelect[name='Question']").find("option").remove();
	    subtopic1=$(this).find(':selected').text();
	    //SubTopicID(subtopic1);
	});
	
	//Event of adding Subtopic to Db
	$( "#formQuestion" ).submit(function( event ) {
		event.preventDefault();
		alert("Event Triggered");
		var question = $('textarea#QuestionInput').val();
		var A = $("input[type=text]#A").val();
		var B = $("input[type=text]#B").val();
		var C = $("input[type=text]#C").val();
		var D = $("input[type=text]#D").val();
		var answer = $("input[name='Question']:checked"). val();
		var marking=$("#marking option:selected").text();
		alert("got ALL DATA");
		$.post('addQuestionServlet',{ 'question' : Question,'a':A,'b':B,'c':C,'d':D,'ans':Answer,'marking':marking},function(data, textStatus){     
			   });
		alert("Question Added " );
		$('#formQuestion')[0].reset();
	});
	
}); */
</script>
<body>
	<%@include file="header.jsp" %>
	<div id="SubTopicDiv" style="display: none;" name="SubTopic" >
		<center>
			<form id="formSubtopic"style="margin: 5%;">
				Select Topic:<select	id="TopicSelect" name="SubTopic">
						
				</select><br>
				SubTopic Added:<select	id="SubTopicSelect" name=SubTopic style="width: 120px;">
						
				</select><br>
				Sub Topic:<input id="SubTopicInput" type="text" ><br> 
			    <input id="SubTopicAdd" type="submit" value="Add">
			</form>
		</center>
	</div>
	
	<div id="QuestionDiv" style="display: none;" name="Question" >
		<center>
			<form id="formQuestion"style="margin: 5%;">
				Select Topic:<select	id="TopicSelect" name="Question">
						
				</select><br>
				SubTopic:<select id="SubTopicSelect" name=Question style="width: 120px;">
						
				</select><br>
				Add Question:
				<textarea id="QuestionInput" type="text" ></textarea></br> 
				
				<input type="radio" name="Question" value="A" checked="checked">A<input id="A" type="text" name="Option"></br>
				<input type="radio" name="Question" value="B">B<input id="B" type="text" name="Option"></br>
				<input type="radio" name="Question" value="C">C<input id="C" type="text" name="Option"></br>
				<input type="radio" name="Question" value="D">D<input id="D" type="text" name="Option"></br>
				
				Marking:<select id="marking">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>5</option>
				</select><br>
			    <input id="Question" type="submit" value="Add Question">
			</form>
		</center>
	</div>
	
</body>
</html>