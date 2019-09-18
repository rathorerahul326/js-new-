package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.JavaSolTest.Dto.LoginDto;


public class RegisterUser {

	public static void registration(LoginDto ld) {
		// TODO Auto-generated method stub
		

		String id = ld.getId();
		String password = ld.getPass();
		String name = ld.getName();
		String lname=ld.getLname();
		String email= ld.getEmail();
		String image= ld.getPath();
		String mobno= ld.getMobno();
		String state= ld.getState();
		String city= ld.getCity();
		
		
		Connection con=null;
		con=Connect.get();

		try {
			PreparedStatement ps= con.prepareStatement("insert into studentinformation values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,	id);
			ps.setString(2, name);
			ps.setString(3, lname);
			ps.setString(4, mobno);
			ps.setString(5, email);
			ps.setString(6, password);
			ps.setString(7, state);
			ps.setString(8, city);
			ps.setString(9, image);
			int i= ps.executeUpdate();
			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public LoginDto studentEdit(LoginDto ld) {

		
		String id = ld.getId();
		String password = ld.getPass();
		String name = ld.getName();
		String lname=ld.getLname();
		String email= ld.getEmail();
		String image= ld.getPath();
		String mobno= ld.getMobno();
		String state= ld.getState();
		String city= ld.getCity();
		
		Connection con=null;
		con=Connect.get();
		
		try {
	 		
	 		PreparedStatement ps= con.prepareStatement("update studentinformation set id=?, name=?,lname=? ,mobno=?,email=?,password=? ,state=?,city=?,image=? where id=? ");
	 		
	 		ps.setString(1,	id);
			ps.setString(2, name);
			ps.setString(3, lname);
			ps.setString(4, mobno);
			ps.setString(5, email);
			ps.setString(6, password);
			ps.setString(7, state);
			ps.setString(8, city);
			ps.setString(9, image);
			ps.setString(10, id);
			
			ps.executeUpdate();
				 	
	 		con.close();
	 	}
	 	catch (Exception e) {

	 		System.out.println(e);

	 	}
		
		return ld;
	}
	
}

	
	
	
	
	

