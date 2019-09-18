package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dao.EmailVerify;


@WebServlet("/userid")
public class Login_Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user= request.getParameter("user");
		
		int result=EmailVerify.verify2(user);
		
		
		if(result==2)
		{

			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("*Not Available");
		}
		else{

			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("");
		
		}
		
		
	}

}
