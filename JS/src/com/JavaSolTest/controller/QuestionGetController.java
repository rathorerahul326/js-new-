package com.JavaSolTest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Service.QuestionGetService;

/**
 * Servlet implementation class QuestionGetController
 */
@WebServlet(name = "questionGetController", urlPatterns = { "/questionGetController" })
public class QuestionGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stid=Integer.parseInt(request.getParameter("SubTopicID"));
		
		QuestionGetService questionGetService=new QuestionGetService(); 
		String st=questionGetService.getQuestion(stid);
		
		
		response.getWriter().append(st);
	}
}
