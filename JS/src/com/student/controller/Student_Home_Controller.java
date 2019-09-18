
package com.student.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaSolTest.Dao.Fatchalluserrepo;
import com.JavaSolTest.Dto.LoginDto;
import com.JavaSolTest.Service.UserService;

@WebServlet("/home")
public class Student_Home_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		LoginDto ld = new LoginDto();
		ld.setId(id);
		ld.setPass(pass);

		UserService ls = new UserService();
		int result = ls.testlogin(ld);

		if (result == 1) {

			String str = "User Name And Password Should not be null";
			request.setAttribute("error1", str);
			request.getRequestDispatcher("home.jsp").include(request, response);

		} else if (result == 2) {
			String str = "Invalid User name and Password";

			request.setAttribute("error2", str);
			request.getRequestDispatcher("home.jsp").include(request, response);

		} else if (result == 3) {

			Map<String, HttpSession> map = (Map<String, HttpSession>) getServletConfig().getServletContext()
					.getAttribute("sessionMap");
			HttpSession session = null;
			session = map.get(id);

			if (session != null) {
				HttpSession hs = request.getSession(true);
				hs.setAttribute("userid", session.getAttribute("userid"));
				hs.setAttribute("stuinfo", session.getAttribute("stuinfo"));
				hs.setAttribute("fid", session.getAttribute("fid"));

				hs.setAttribute("testName", session.getAttribute("testName"));
				hs.setAttribute("testid", session.getAttribute("testid"));
				hs.setAttribute("testtime", session.getAttribute("testtime"));
				hs.setAttribute("testtimesecond", session.getAttribute("testtimesecond"));
				hs.setAttribute("noq", session.getAttribute("noq"));
				hs.setAttribute("index", session.getAttribute("index"));
				hs.setAttribute("question", session.getAttribute("question"));
				hs.setAttribute("submitTime", session.getAttribute("submitTime"));
				hs.setAttribute("timeStamp", session.getAttribute("timeStamp"));

				map.put(id, hs);

			}

			if (session == null) {

				session = request.getSession(true);

				map.put(id, session);

				Fatchalluserrepo studentinfo = new Fatchalluserrepo();
				LoginDto ldto = studentinfo.setStudentinfo(ld);

				session.setAttribute("userid", id);
				session.setAttribute("stuinfo", ldto);
			}

			request.getRequestDispatcher("studentProfile.jsp").include(request, response);

		}
	}

}
