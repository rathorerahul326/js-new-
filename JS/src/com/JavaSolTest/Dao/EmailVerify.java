package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class EmailVerify {
	
	public static int verify(String eml) {

		String s1= eml;
		int flag =1;
    
		Connection con=null;
		con=Connect.get();
    
		try {
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery("select * from studentinformation where email='" + s1  + "'");
				
				if (rs.next()) {
					flag= 2;
				} 
				
				con.close();
			}
		
			catch (Exception e) {

				System.out.println(e);
			}
			
			return flag;
		}
	
	
public static int verify2(String userid) {

		String s1= userid;
		int flag =1;
    
		Connection con=null;
		con=Connect.get();
    
		try {
		
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from studentinformation where id='" + s1  + "'");
			if (rs.next()) {
				flag= 2;
			} 
			
			con.close();
		}
		catch (Exception e) {

			System.out.println(e);
		}
		return flag;
	}

}
