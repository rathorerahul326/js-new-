package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.StudentAnswerDao;
import com.JavaSolTest.Dto.ScoreDto;

@WebServlet("/submitTest")
public class Submit_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		int fId = (Integer) session.getAttribute("fid");
		int testId = (Integer) session.getAttribute("testid");

		String user_id = (String) session.getAttribute("userid");
		String testname = (String) session.getAttribute("testName");
	 
		int noq=(Integer)session.getAttribute("noq");

		StudentAnswerDao result = new StudentAnswerDao();
		
		ScoreDto score = result.showResult(user_id, testId, noq);
		

		result.setResult(testId, user_id, score.getResult(), fId, score.getTotalmarks(), testname);// For Save Score

		//result.StudentData(user_id, testId);// For truncate Answer Table
		
		request.setAttribute("totalmarks", score.getTotalmarks());
		request.setAttribute("score", score.getResult());
		request.setAttribute("skip", score.getSkip());
		request.setAttribute("wrong", score.getWrongAnswer());
		request.setAttribute("correctAnswer", score.getCorrectAnswer());
		request.getRequestDispatcher("score.jsp").include(request, response);
	}
}
