package com.JavaSolTest.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JavaSolTest.Dto.SaveFireTestDto;
import com.JavaSolTest.Service.FireTestSaveService;


@WebServlet(name = "fireTestSaveController", urlPatterns = { "/fireTestSaveController" })
public class FireTestSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int testID=Integer.parseInt(request.getParameter("Test_ID"));
		String dt=request.getParameter("date");
		String sTime=request.getParameter("startTime");
		String eTime=request.getParameter("endTime");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		SaveFireTestDto saveFireTestDto=new SaveFireTestDto();
		saveFireTestDto.setTestId(testID);
		
		try {
			//Date date = (Date) sdf.parse(dt);
		
			saveFireTestDto.setDate(dt);
			
			//Date startTime= new SimpleDateFormat("HH:mm").parse(sTime);
			
			saveFireTestDto.setStartTime(sTime);
			
			//Date endTime= new SimpleDateFormat("HH:mm").parse(eTime);
			saveFireTestDto.setEndTime(eTime);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FireTestSaveService fireTestSaveService=new FireTestSaveService();
		fireTestSaveService.saveTest(saveFireTestDto);
		
		request.getRequestDispatcher("fireTestController").forward(request, response);
	}
}
