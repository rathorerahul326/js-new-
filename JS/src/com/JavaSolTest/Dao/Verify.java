package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.JavaSolTest.Dto.LoginDto;


public class Verify {

	public static int verify(LoginDto ld) {
		

		String id = ld.getId();
		String pass= ld.getPass();
		int status=2;
		
		Connection con=null;
		con=Connect.get();

		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from studentinformation where id='"+id+"' and password='" + pass  + "'");

			if (rs.next()) {
				status= 3;

			} 
			con.close();
		}
		catch (Exception e) {

			System.out.println(e);

		}
	

		return status;

	}

public static int verifysignup(LoginDto ld) {
		

		String id = ld.getId();
		String email= ld.getEmail();
		
		Connection con=null;
		con=Connect.get();

		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select email= '" +  email + "'from studentinformation where id='" + id  + "'");

			if (rs.next()) {
				return 3;

			} 
			con.close();
		}
		catch (Exception e) {

			System.out.println(e);

		}
			return 2;
		
	}
}
	

