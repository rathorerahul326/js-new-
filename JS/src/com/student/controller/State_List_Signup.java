package com.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/userstate1")
public class State_List_Signup
extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state=request.getParameter("state");
		JSONArray jarray=new JSONArray();
		JSONObject jobject=new JSONObject();
		
		if(state.equals("MadhyaPradesh"))
		{
			jobject.put("a", "Indore");
			jobject.put("b", "Ujjain");
			jobject.put("c", "Dewas");
			jobject.put("d", "Neemuch");
			
			jarray.add(jobject);
			
		}
		else if(state.equals("UttarPradesh"))
		{
			jobject.put("a", "Agra");
			jobject.put("b", "Aligarh");
			jobject.put("c", "Noida");
			jobject.put("d", "Lucknow");
			
			jarray.add(jobject);
			
		}
		
		else if(state.equals("Chattishgarh"))
		{
			jobject.put("a", "Raipur");
			jobject.put("b", "Bilaspur");
			jobject.put("c", "Jagdalpur");
			jobject.put("d", "Chirmiri");
			
			jarray.add(jobject);
			
		}
		
		String st=jarray.toJSONString();
		response.setContentType("application/json");
		response.getWriter().write(st);
	
	}

}
