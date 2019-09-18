package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dto.TopicGetDto;
import com.JavaSolTest.Service.SubtopicAddService;
import com.JavaSolTest.Service.TopicAddService;
import com.JavaSolTest.Service.TopicGetService;

@WebServlet(name = "subtopicAddServlet", urlPatterns = { "/subtopicAddController" })
public class SubtopicAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subtopic=request.getParameter("SubTopic");
		int tid=Integer.parseInt(request.getParameter("topicId"));
		
		SubtopicAddService subtopicAddService=new SubtopicAddService();
		subtopicAddService.SubTopicAdd(subtopic,tid);
		
		TopicGetService topicGetService=new TopicGetService();
		List<TopicGetDto> list=topicGetService.topicGet();
		
		request.setAttribute("Topic", list);
		request.getRequestDispatcher("AddSubTopic.jsp").include(request, response);
	}

}
