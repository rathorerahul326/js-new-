package com.JavaSolTest.Dao;

import java.sql.*;


public class Connect {
	private static Connect con;
	 static  String driver="com.mysql.jdbc.Driver";
	 static String  url="jdbc:mysql://localhost:3306/onlinetest";
	 static String uname="root";
	 static String pass="root";
	 static{
	 try{
		 Class.forName(driver);
	 }
	 catch(Exception e){}
	 }
	
	public static Connection get(){
		 Connection con=null;
		 try{
			 con=DriverManager.getConnection(url,uname,pass);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 finally{		  
			 return con;
		 }
	 }
}
