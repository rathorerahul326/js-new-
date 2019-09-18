package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.JavaSolTest.Dto.CreateTestDto;

public class CreateTestSubtopicDao {
	
	public String GetSubtopic(String topicID){
		Connection con=null;
		con=Connect.get();
		JSONArray array=new JSONArray();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT stid,subtopic_name FROM subtopic WHERE tid IN ("+topicID+")");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				JSONObject obj=new JSONObject();
				obj.put("stid", rs.getInt(1));
				obj.put("Subtopic",rs.getString(2));
				PreparedStatement ps1=con.prepareStatement("SELECT COUNT(Question) FROM question WHERE stid=?");
				ps1.setInt(1,rs.getInt(1));
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					obj.put("noq", rs1.getInt(1));
				}
				array.add(obj);	
			}
			String str=array.toJSONString();
			return str;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<CreateTestDto> getsubtopic(String testid) {
		// TODO Auto-generated method stub
	//	int testime= Integer.parseInt(duration);
		
		List<CreateTestDto> list= new ArrayList<>();
		
		Connection con=null;
		con=Connect.get();
		try {
			PreparedStatement ps=con.prepareStatement("select subtopic_id,no_of_question from test_topics where test_id='"+testid+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CreateTestDto subdto= new CreateTestDto();
				subdto.setSubtid(rs.getInt("subtopic_id"));
				subdto.setNoq(rs.getInt("no_of_question"));
				
				
				list.add(subdto);
				
			}
		} catch (SQLException e) {

			
			e.printStackTrace();
		}
		return list;
		
	}
	
}
