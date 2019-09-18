package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubtopicAddDao {
	public void SubTopicAdd(String subtopic,int tid){
		Connection con=null;
		con=Connect.get();
		
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into subtopic values ( ?,null,?)");
			ps.setInt(1, tid );
			ps.setString(2, subtopic);
			boolean rowinsert=ps.execute();
			if(rowinsert)
				System.out.println("SubTopic Added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
