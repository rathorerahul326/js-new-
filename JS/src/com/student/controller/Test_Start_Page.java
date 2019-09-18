package com.student.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.AddQuestionDao;
import com.JavaSolTest.Dao.CreateTestSubtopicDao;
import com.JavaSolTest.Dto.CreateTestDto;
import com.JavaSolTest.Dto.TestQuestionDto;

@WebServlet("/starttestcontroller")
public class Test_Start_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession(false);
		Object o=session.getAttribute("testid");
		if(o!=null)
		{
			request.getRequestDispatcher("starttest.jsp").include(request, response);
		}
		else
		{
		Map<Integer, List<TestQuestionDto>> mapobject = new HashMap<>();
		
		List<TestQuestionDto> listquestion= new ArrayList<>();
		
		String firetestId= request.getParameter("fid");
		String testid= request.getParameter("testid");
		String testname= request.getParameter("testname");
		String duration = request.getParameter("duration");
		String noq= request.getParameter("total");
		
		
		Integer firetest_id= Integer.parseInt(firetestId);
		
		Integer numberofquestion= Integer.parseInt(noq);
		
		Integer testId= Integer.parseInt(testid);
		Integer testtime= Integer.parseInt(duration)-1;
		Integer testtimesecond= Integer.parseInt(duration);
		
		
	    session.setAttribute("timeStamp",new Timestamp(System.currentTimeMillis()));
		
		CreateTestSubtopicDao testsub = new CreateTestSubtopicDao();
		
		List<CreateTestDto> list_createTestDto  = testsub.getsubtopic(testid);

		AddQuestionDao addQuestionDao= new AddQuestionDao();
		
		for(CreateTestDto l: list_createTestDto)
		{
			
			mapobject.put(l.getSubtid() , addQuestionDao.getQuestionid(l.getSubtid() , l.getNoq()));
			
		}
		for(Map.Entry<Integer, List<TestQuestionDto>> entry : mapobject.entrySet())
		{
		 
		    listquestion.addAll(entry.getValue());
		    
		}
		
		
		Integer index=0;
	 	Integer defaultsecond=60;
	 	Integer testtimeforSubmit= 60000*testtimesecond;
		
		session.setAttribute("fid", firetest_id);
		session.setAttribute("testName", testname);
	 	session.setAttribute("testid", testId);
	 	session.setAttribute("testtime", testtime);
	 	session.setAttribute("testtimesecond", defaultsecond);
	 	session.setAttribute("noq", numberofquestion);
		session.setAttribute("index", index);
		session.setAttribute("question", listquestion);	
		session.setAttribute("submitTime", testtimeforSubmit);
		
		
		request.getRequestDispatcher("starttest.jsp").include(request, response);
		}
		
		}
	}
