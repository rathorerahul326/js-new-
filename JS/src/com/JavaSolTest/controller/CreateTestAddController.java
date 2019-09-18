package com.JavaSolTest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.JavaSolTest.Dto.CreateTestDto;
import com.JavaSolTest.Service.CreateTestAddService;

@WebServlet(name = "createTestAddController", urlPatterns = { "/createTestAddController" })
public class CreateTestAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreateTestDto createTestDto=new CreateTestDto();
		
		createTestDto.setName(request.getParameter("TestName"));
		createTestDto.setTotal(Integer.parseInt(request.getParameter("Number")));
		createTestDto.setDuration(Integer.parseInt(request.getParameter("Time")));
		
		createTestDto.setStid(request.getParameterValues("subtopicid"));
		createTestDto.setSubtopicnoq(request.getParameterValues("question"));
		
		
		CreateTestAddService createTestAddService =new CreateTestAddService();
		createTestAddService.Add(createTestDto);
		
		request.getRequestDispatcher("AdminHomePage.jsp").include(request, response);
	}
}
