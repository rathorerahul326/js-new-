package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.JavaSolTest.Dto.SaveFireTestDto;



public class FireTestSaveDao {
	public void saveTest(SaveFireTestDto dto){
		Connection con=null;
		con=Connect.get();
		
		java.sql.Date sqlDate = java.sql.Date.valueOf(dto.getDate());
		//java.sql.Date sTime = java.sql.Date.valueOf(dto.getStartTime());
		//java.sql.Date eTime = java.sql.Date.valueOf(dto.getEndTime());
		
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into firetest values(null,?,?,?,?)");
			ps.setInt(1, dto.getTestId());
			ps.setDate(2, sqlDate);
			ps.setString(3, dto.getStartTime());
			ps.setString(4, dto.getEndTime());
			ps.executeUpdate();
			
			
			
			//ps.setDate(2, );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
