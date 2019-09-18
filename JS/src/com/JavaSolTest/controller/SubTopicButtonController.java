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
 * Servlet implementation class SubTopicButtonController
 */
@WebServlet(name = "subTopicButtonController", urlPatterns = { "/subTopicButtonController" })
public class SubTopicButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SubTopicButtonController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TopicGetService topicGetService=new TopicGetService();
		List<TopicGetDto> list=topicGetService.topicGet();
		
		request.setAttribute("Topic", list);
		request.getRequestDispatcher("AddSubTopic.jsp").include(request, response);
	}


}
