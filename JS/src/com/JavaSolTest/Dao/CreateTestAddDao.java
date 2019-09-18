package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JavaSolTest.Dto.CreateTestDto;

public class CreateTestAddDao {	
	public void Add(CreateTestDto  createTestDto){
		Connection con=null;
		con=Connect.get();
		try {
			PreparedStatement ps=con.prepareStatement("Insert into test values (null,?,?,?)");
			ps.setString(1,createTestDto.getName());
			ps.setInt(2,createTestDto.getTotal());
			ps.setInt(3, createTestDto.getDuration());
			ps.executeUpdate();
			
			PreparedStatement ps1=con.prepareStatement("select max(test_id) from test");

			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				String stid[]=createTestDto.getStid();
				String noq[]=createTestDto.getSubtopicnoq();
				int test_id=rs.getInt(1);
					for(int i=0;i<stid.length;i++){
						
						
						if(!noq[i].equals(""))
						{
							PreparedStatement ps2=con.prepareStatement("insert into test_topics values(null,?,?,?)");
							ps2.setInt(1,test_id);
							ps2.setInt(2,Integer.parseInt(stid[i]));
							ps2.setInt(3, Integer.parseInt(noq[i]));
							ps2.executeUpdate();
							
						}
							
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
