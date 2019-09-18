package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dao.Fatchalluserrepo;
import com.JavaSolTest.Dto.LoginDto;


/**
 * Servlet implementation class Showuser
 */
@WebServlet("/showuser")
public class Show_All_Student_List_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out =response.getWriter();
		Fatchalluserrepo ft= new Fatchalluserrepo();
		List<LoginDto> user=ft.getAlluser();
		
	request.setAttribute("mylist", user);

	
	RequestDispatcher rd= request.getRequestDispatcher("showalluser.jsp");
	rd.forward(request, response);
		
		
		
	}
	
	
	}

	

