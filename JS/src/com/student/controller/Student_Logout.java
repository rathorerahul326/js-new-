package com.student.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class Student_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Session destroy with id = "+request.getSession(false).getId());
		HttpSession httpSession=request.getSession(false);
		
		Map<String,HttpSession> map=(Map<String,HttpSession>)getServletConfig().getServletContext().getAttribute("sessionMap");
		map.remove(httpSession.getAttribute("userid"));
		
		request.getSession(false).invalidate();
			
		request.getRequestDispatcher("home.jsp").include(request, response);
	
	}

}
