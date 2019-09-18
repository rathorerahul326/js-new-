package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dao.StudentRecordDao;
import com.JavaSolTest.Dto.FireTestDto;


@WebServlet("/viewAllStudentrecords")
public class ViewAllStudentrecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String testname= request.getParameter("testname");
		
		String date= request.getParameter("date");
		
		
		StudentRecordDao allRecord= new StudentRecordDao();
		
		
		List<FireTestDto> list=allRecord.getAllstudentResult(testname, date);
		
		
		
		request.setAttribute("allstudentRecords", list);
		request.getRequestDispatcher("viewStudentDiscrition.jsp").include(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
