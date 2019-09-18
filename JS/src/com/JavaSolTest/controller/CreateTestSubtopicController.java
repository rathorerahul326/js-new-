package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Service.CreateTestSubtopicService;

@WebServlet(name = "createTestSubtopicController", urlPatterns = { "/createTestSubtopicController" })
public class CreateTestSubtopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int topic=Integer.parseInt(request.getParameter("Topic"));
		//System.out.println(topic);
		String str=request.getParameter("json");
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(str);
		String input=new String();
		while (m.find()) {
		  input=input+m.group()+",";
		}
		input=input.substring(0, input.length()-1);
		
		CreateTestSubtopicService createTestSubtopicService=new CreateTestSubtopicService();
		String Subtopic=createTestSubtopicService.getSubtopic(input);
		
		response.getWriter().append(Subtopic);
		//JSONArray array = JSONArray.fromObject(str);
	}
}
