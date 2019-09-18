package com.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dao.StudentRecordDao;
import com.JavaSolTest.Dto.FireTestDto;

@WebServlet("/studentRecord")
public class Student_RecordShow_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentRecordDao allrecord = new StudentRecordDao();

		List<FireTestDto> list = allrecord.getAllresult();

		request.setAttribute("studentRecords", list);
		request.getRequestDispatcher("adminstudentResult.jsp").include(request, response);

	}

}
