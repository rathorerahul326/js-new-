package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dto.TopicGetDto;
import com.JavaSolTest.Service.TopicGetService;

/**
 * Servlet implementation class CreateTestButtonController
 */
@WebServlet(name = "createTestButtonController", urlPatterns = { "/createTestButtonController" })
public class CreateTestButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TopicGetService topicGetService=new TopicGetService();
		List<TopicGetDto> list=topicGetService.topicGet();
		
		request.setAttribute("Topic", list);
		request.getRequestDispatcher("CreateTest.jsp").include(request, response);
		
		
	}

}
