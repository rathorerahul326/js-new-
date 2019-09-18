package com.JavaSolTest.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyServletContextListener implements ServletContextListener{




	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}


	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		System.out.println("Servlet context initialized");
	ServletContext context=	event.getServletContext();
	
	context.setAttribute("sessionMap", new HashMap<String,HttpSession>());
	
		
		
	}

}
