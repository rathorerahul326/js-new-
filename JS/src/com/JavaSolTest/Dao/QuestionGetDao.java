package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




public class QuestionGetDao {
	public String GetQuestion( int stid){
		Connection con=null;
		con=Connect.get();
		try {
			JSONArray array=new JSONArray();
			PreparedStatement ps=con.prepareStatement("select Question from question where stid=?");
			ps.setInt(1, stid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				JSONObject obj=new JSONObject();
				obj.put("Question", rs.getString(1));
				array.add(obj);
			}
			String st=array.toJSONString();
			return st;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
