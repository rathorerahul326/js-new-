package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dto.QuestionDto;
import com.JavaSolTest.Dto.TopicGetDto;
import com.JavaSolTest.Service.AddQuestionService;
import com.JavaSolTest.Service.TopicGetService;

@WebServlet(name = "addQuestionServlet", urlPatterns = { "/addQuestionController" })
public class AddQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside AddQuestionController");
		int stid=Integer.parseInt(request.getParameter("stid"));
		
		QuestionDto questionDto=new QuestionDto();
		questionDto.setStid(stid);
		String question=request.getParameter("Question");
		questionDto.setQuestion(question);
		questionDto.setA(request.getParameter("A"));
		questionDto.setB(request.getParameter("B"));
		questionDto.setC(request.getParameter("C"));
		questionDto.setD(request.getParameter("D"));
		questionDto.setAns(request.getParameter("Ans"));
		questionDto.setMarking(request.getParameter("marking"));
		
		AddQuestionService addQuestionService=new AddQuestionService();
		addQuestionService.AddQuestion(questionDto);
		
		TopicGetService topicGetService=new TopicGetService();
		List<TopicGetDto> list=topicGetService.topicGet();
		
		request.setAttribute("Topic", list);
		request.getRequestDispatcher("AddQuestion.jsp").include(request, response);
		
	}

}
