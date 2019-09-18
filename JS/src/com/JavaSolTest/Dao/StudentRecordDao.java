package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.JavaSolTest.Dto.FireTestDto;

public class StudentRecordDao {

	public List<FireTestDto> getAllresult() {
		// TODO Auto-generated method stub
		
		List<FireTestDto> list= new ArrayList<>();
		
		Connection con=null;
		con=Connect.get();
		

		try {
			PreparedStatement ps = con.prepareStatement("select TestName, date,f_id, count(id) as total from scorecard group by f_id  ");

			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				FireTestDto dto= new  FireTestDto();
				dto.setTest_name(rs.getString("TestName"));
				dto.setDate(rs.getString("date"));
				dto.setFid(rs.getInt("f_id"));
				dto.setCount(rs.getInt("total"));
				
				list.add(dto);
				
			}
			
			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return list;
	}

	public List<FireTestDto> getAllstudentResult(String testname, String date) {
		// TODO Auto-generated method stub
		
List<FireTestDto> list= new ArrayList<>();
		
		Connection con=null;
		con=Connect.get();
		

		try {
			PreparedStatement ps = con.prepareStatement("select * from scorecard where TestName='"+testname+"'and date='"+date+"'  ");

			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				FireTestDto dto= new  FireTestDto();
				dto.setScore(rs.getInt("score"));
				dto.setUid(rs.getString("id"));
				dto.setTotalmarks(rs.getInt("total_marks"));
				dto.setTest_name(rs.getString("TestName"));
				dto.setDate(rs.getString("date"));
				
				list.add(dto);
				
			}
			
			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return list;
		
		
	}

	
	
	
	
	
	
}
