package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.JavaSolTest.Dto.LoginDto;

public class Fatchalluserrepo {
	
	public List<LoginDto> getAlluser() {

		List<LoginDto> l= new ArrayList<>();
		Connection con=null;
		con=Connect.get();
		try {
			
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select * from studentinformation ");
			while(rs.next())
			{
				LoginDto ldto= new LoginDto();
				
				ldto.setId(rs.getString(1));
				ldto.setName(rs.getString(2));
				ldto.setMobno(rs.getString(3));
				ldto.setEmail(rs.getString(4));
				ldto.setPass(rs.getString(5));
				ldto.setPath(rs.getString(6));
				
				l.add(ldto);
			}
			
			con.close();
		}
		catch (Exception e) {

			System.out.println(e);

		}
		return l;
	
		
		
		
	}

	public LoginDto setStudentinfo(LoginDto ldto) {
		// TODO Auto-generated method stub
		
	String id= ldto.getId();
	
		
		Connection con=null;
		con=Connect.get();
		try {
			
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select * from studentinformation where id='" + id  + "'");
			while(rs.next())
			{
				//LoginDto ldto= new LoginDto();
				
				ldto.setId(rs.getString(1));
				ldto.setName(rs.getString(2));
				ldto.setLname(rs.getString(3));
				ldto.setMobno(rs.getString(4));
				ldto.setEmail(rs.getString(5));
				ldto.setPass(rs.getString(6));
				ldto.setState(rs.getString(7));
				ldto.setCity(rs.getString(8));
				ldto.setPath(rs.getString(9));
				
			}
			
			con.close();
		}
		catch (Exception e) {

			System.out.println(e);

		}
	
		
		return ldto;
		
		
		
	}

}
