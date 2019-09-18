<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <link rel="stylesheet" href="my.css">
</head>
<style>
h1{font-size:14;
height:80px;
background:yellow;
padding:5px;
color:black;
text-align:left;

}
a{
    text-decoration: none;
}
html,body,h2,h3,h4,h5,h6 {
    font-family: "Comic Sans MS", cursive, sans-serif;
}
</style>
<body>
<div class="header"><h1>JAVA SOLUTIONS ONLINE TEST</h1></div>
<div class="w3-container">
 	<button id="homeBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="AdminHomePage.jsp">Home</a></button>
		<button id="TopicBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="topicGetController">Add Topics</a></button>
		<button id="SubtopicBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="subTopicButtonController">Sub-Topics</a></button>
		<button id="QuestionsBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="questionButtonController">Add-Question</a></button>
		<button id="CreattestBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="createTestButtonController">Create Test</a></button>
		<button id="FsiretestBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="fireTestController">Fire Test</a></button>
			<button id="StudentrecordBtn"
			class="w3-button w3-border w3-black w3-hover-teal w3-round-large w3-animate-top"><a href="studentRecord">Student Records</a></button>
</div>	
<div class ="w3-container w3-blue"></div>
</body>
</html>