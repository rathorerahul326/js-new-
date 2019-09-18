package com.JavaSolTest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Service.SubTopicGetService;

@WebServlet(name = "subTopicGetServlet", urlPatterns = { "/subTopicGetController" })
public class SubTopicGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int topicID=Integer.parseInt(request.getParameter("TopicID"));
		
		SubTopicGetService subTopicGetService=new SubTopicGetService();
		String subtopic=subTopicGetService.GetData(topicID);
		response.getWriter().append(subtopic);
	}
}
