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
import com.JavaSolTest.Dto.TestQuestionDto;

/**
 * Servlet implementation class ViewAnswer
 */
@WebServlet("/viewAnswer")
public class ViewAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		 
		 
		 String u_id= (String)session.getAttribute("userid");
		
		String testid= request.getParameter("testId");
		
		int test_id= Integer.parseInt(testid);	
		
		StudentAnswerDao studentdao=  new StudentAnswerDao();
		
		List<TestQuestionDto> listdto= studentdao.studentAnswer(u_id,test_id);
		
		
		
		request.setAttribute("answerlist", listdto);
		
		request.getRequestDispatcher("viewAnswer.jsp").include(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
