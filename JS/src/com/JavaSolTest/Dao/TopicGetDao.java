package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.JavaSolTest.Dto.TopicGetDto;

public class TopicGetDao {
	public List<TopicGetDto> topicget(){
		Connection con=null;
		con=Connect.get();
		
		List<TopicGetDto> list=new ArrayList<TopicGetDto>();
		try {
			int i=0;
			PreparedStatement ps=con.prepareStatement("select * from topic");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TopicGetDto topicGetDto=new TopicGetDto();
				topicGetDto.setTopicId(rs.getInt(1));
				topicGetDto.setTopic(rs.getString(2));
				list.add(topicGetDto);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
