package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dto.FireTestDto;
import com.JavaSolTest.Service.FireTestService;

/**
 * Servlet implementation class FireTest
 */
@WebServlet(name = "fireTest", urlPatterns = { "/fireTestController" })
public class FireTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FireTestService fireTestService=new FireTestService();
		List<FireTestDto> List=fireTestService.getTest();
		
		request.setAttribute("Test", List);
		request.getRequestDispatcher("FireTest.jsp").forward(request, response);
	}
}
