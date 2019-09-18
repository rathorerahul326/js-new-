package com.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.StudentAnswerDao;
import com.JavaSolTest.Dto.FireTestDto;

@WebServlet("/scoreCard")
public class ScoreCard_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		 HttpSession session = request.getSession(false);
		 
		 
		 String u_id= (String)session.getAttribute("userid");
		 
		 
		 StudentAnswerDao studentdao=  new StudentAnswerDao();
		 
		 List<FireTestDto> listdto= studentdao.studentReport(u_id);
		 
		 
		 request.setAttribute("scorelist", listdto);
		 
		 request.getRequestDispatcher("studentScorecard.jsp").include(request, response);
		
	
	}

}
