package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dto.TopicGetDto;
import com.JavaSolTest.Service.TopicAddService;
import com.JavaSolTest.Service.TopicGetService;

@WebServlet(name = "topicAddServlet", urlPatterns = { "/topicAddController" })
public class TopicAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String topic=request.getParameter("Topic");
		
		TopicAddService topicAddService=new TopicAddService();
		topicAddService.TopicAdd(topic);
		
		TopicGetService topicGetService=new TopicGetService();
		List<TopicGetDto> list=topicGetService.topicGet();
		
		request.setAttribute("Topic", list);
		request.getRequestDispatcher("AddTopic.jsp").include(request, response);
	}
}
