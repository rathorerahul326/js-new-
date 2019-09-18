package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class SubTopicGetDao {
	public String GetData(int topicID){
		Connection con=null;
		con=Connect.get();
		try {
			PreparedStatement ps2=con.prepareStatement("select * from subtopic where tid=?");
			ps2.setInt(1,topicID);
			System.out.println("inside SubTopicGetDao");
			ResultSet rs2=ps2.executeQuery();
			JSONArray jarray=new JSONArray();
			while(rs2.next()){
				JSONObject jobject=new JSONObject();
				
				System.out.println(rs2.getString(3));
				jobject.put("stid", rs2.getInt(2));
				jobject.put("Subtopic", rs2.getString(3));
				jarray.add(jobject);
			}
			String st=jarray.toJSONString();
			return st;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
}
