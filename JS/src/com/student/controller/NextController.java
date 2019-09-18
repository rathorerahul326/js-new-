package com.student.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.StudentAnswerDao;
import com.JavaSolTest.Dto.TestQuestionDto;

@WebServlet("/next")
public class NextController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String answer = request.getParameter("Ans");
		String minuts = request.getParameter("minute");
		String secondS = request.getParameter("second");

		String user_id = (String) session.getAttribute("userid");
		Integer noq = (Integer) session.getAttribute("noq");
		Integer index = (Integer) session.getAttribute("index");
		Integer min = (Integer) session.getAttribute("testtime");
		Integer sec = (Integer) session.getAttribute("testtimesecond");
		Timestamp oldtimeStamp = (Timestamp) session.getAttribute("timeStamp");
		int test_id = (Integer) session.getAttribute("testid");

		Timestamp now = new Timestamp(System.currentTimeMillis());
		long diff = now.getTime() - oldtimeStamp.getTime();
		diff = (long) (diff / 1000);

		long totalSeconds = (min * 60) + sec;
		long timeDifference = totalSeconds - diff;

		int seconds = (int) timeDifference % 60;
		int minutes = (int) timeDifference / 60;

		session.setAttribute("testtime", minutes);
		session.setAttribute("testtimesecond", seconds);
		session.setAttribute("timeStamp", new Timestamp(System.currentTimeMillis()));

		@SuppressWarnings("unchecked")
		List<TestQuestionDto> questionList = (List<TestQuestionDto>) session.getAttribute("question");
		TestQuestionDto testQuestionDto = questionList.get(index);
		testQuestionDto.setFetchAns(answer);
		session.setAttribute("question", questionList);

		String action = request.getParameter("action");
		StudentAnswerDao student = new StudentAnswerDao();

		if (minuts.equals("0") && secondS.equals("0")) {

			request.getRequestDispatcher("submitTest").forward(request, response);
		}

		if (action.equals("Next")) {
			index++;
			student.storeresult(testQuestionDto, user_id, test_id);

		}
		if (action.equals("Previous")) {
			index--;

		}

		if (action.equals("SaveNext")) {
			index++;
			student.storeresult(testQuestionDto, user_id, test_id);

		}
		if (action.equals("FinishTest")) {
			student.storeresult(testQuestionDto, user_id, test_id);

			request.getRequestDispatcher("submitTest").forward(request, response);

		}

		if (index <= noq - 1) {
			session.setAttribute("index", index);

			request.getRequestDispatcher("starttest.jsp").include(request, response);
		} else {

			request.getRequestDispatcher("submitTest").forward(request, response);
		}
	}
}
