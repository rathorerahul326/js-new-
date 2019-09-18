package com.JavaSolTest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.FireTestDao;
import com.JavaSolTest.Dto.SaveFireTestDto;

@WebServlet("/teststart")
public class AvailableTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String uid = (String) session.getAttribute("userid");

		FireTestDao ftdao = new FireTestDao();

		List<SaveFireTestDto> list = ftdao.gettestid(uid);

		Object o = session.getAttribute("testid");
		int testId = 0;
		if (o != null) {
			testId = (Integer) o;
		}

		for (SaveFireTestDto dto : list) {
			if (dto.getTestId() == testId) {
				dto.setStatus("Resume");
			}
		}

		request.setAttribute("mylist", list);
		request.getRequestDispatcher("availableTest.jsp").include(request, response);
	}

}
