package com.student.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.JavaSolTest.Dao.RegisterUser;
import com.JavaSolTest.Dto.LoginDto;
import com.JavaSolTest.Service.UserService;



/**
 * Servlet implementation class SignupController
 */
@MultipartConfig 
@WebServlet("/signup")

public class NewStudent_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String name = request.getParameter("name");
		String lname= request.getParameter("lname");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String state= request.getParameter("state");
		String city= request.getParameter("city");
		String mobno = request.getParameter("mobno");
		Part part=	request.getPart("photo");
		
		byte [] b=new byte[(int) part.getSize()];
		InputStream is=part.getInputStream();
	    	
		is.read(b);
		String fname=getFileName(part);
		
		//E:\My Projects\JS\JS\WebContent\pic
		//E:\\My Projects\\JS\\JS\\WebContent\\pic
		//media\\aman\\New Volume\\E\\My Projects\\JS\\JS\\WebContent\\pic
		///media/aman/New Volume/E/My Projects/JS/JS/WebContent/pic
	    	
		File f=new File("D:\\Java solutions\\JS\\JS\\WebContent\\pic\\"+fname);
		String f1= "/JS/pic/"+fname;
		
		FileOutputStream fileOutputStream=new FileOutputStream(f);
	    	
		fileOutputStream.write(b);
		fileOutputStream.close();
		
		
		LoginDto ld = new LoginDto();
		ld.setName(name);
		ld.setEmail(email);
		ld.setId(id);
		ld.setPass(pass);
		ld.setMobno(mobno);
		ld.setPath(f1);
		ld.setLname(lname);
		ld.setCity(city);
		ld.setState(state);
		
		UserService ls= new  UserService();

		int result= ls.testsignup(ld);
		
		if(result==1)
		 {
			 String str= "Field Should not be null";
			 request.setAttribute("errormsg", str);
			 request.getRequestDispatcher("signup.jsp").include(request, response);
			 
		 }
		 
		  if(result==2){
			 
			 RegisterUser.registration(ld);
			 String succes= "You are successfully regitered  "+ld.getName();
			 request.setAttribute("registered", succes);
			 request.getRequestDispatcher("home.jsp").include(request, response);
			 
		 }
		  if(result==3)
		 {
			 String str= "A User Already registered with same information try again ";
			 request.setAttribute("errormsg1", str);
			 request.getRequestDispatcher("signup.jsp").include(request, response);
		 }
		
	}
		
	
private String getFileName(final Part part) {

		final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
}
