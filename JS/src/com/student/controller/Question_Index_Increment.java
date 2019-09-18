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

import com.JavaSolTest.Dto.TestQuestionDto;

/**
 * Servlet implementation class IndexQuestionController
 */
@WebServlet("/indexQuestion")
public class Question_Index_Increment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(false);
		
		
		Integer min =(Integer)session.getAttribute("testtime");
		Integer sec =(Integer)session.getAttribute("testtimesecond");
		Timestamp oldtimeStamp=(Timestamp)session.getAttribute("timeStamp");
		
		
		
		 Timestamp now=new Timestamp(System.currentTimeMillis());
		   long diff=now.getTime()-oldtimeStamp.getTime();
		   diff=(long)(diff/1000);

		   long totalSeconds=(min*60)+sec;
		   long timeDifference=totalSeconds-diff;

		   int seconds=(int)timeDifference%60;
		   int minutes=(int) timeDifference/60;	
		   
		   session.setAttribute("testtime", minutes);
		   session.setAttribute("testtimesecond", seconds);
		   session.setAttribute("timeStamp", new Timestamp(System.currentTimeMillis()));
		
		
		
	
	int index=Integer.parseInt(request.getParameter("index"));
	

	
	
	request.getSession(false).setAttribute("index", index);
	request.getRequestDispatcher("starttest.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
