package com.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.RegisterUser;
import com.JavaSolTest.Dto.LoginDto;

@WebServlet("/edit")
public class Update_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession(false);
		LoginDto ldto= new LoginDto();
		String id= request.getParameter("id");
		String name= request.getParameter("name");
		String lname= request.getParameter("lname");
		String  mobno= request.getParameter("mobno");
		String email= request.getParameter("email");
		String state=request.getParameter("state");
		String city= request.getParameter("city");
		String path= request.getParameter("image");
		String pass= request.getParameter("pass");
		
		 
		ldto.setId(id);
		ldto.setName(name);
		ldto.setPass(pass);
		ldto.setLname(lname);
		ldto.setEmail(email);
		ldto.setMobno(mobno);
		ldto.setCity(city);
		ldto.setPath(path);
		ldto.setState(state);
		
		RegisterUser update= new RegisterUser();
		LoginDto ldto1 =update.studentEdit(ldto);
		session.setAttribute("stuinfo", ldto1);
		
		RequestDispatcher rd= request.getRequestDispatcher("studentedit.jsp");
		rd.include(request, response);
	}
}
