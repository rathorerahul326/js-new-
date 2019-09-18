package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicAddDao {
	public void TopicAdd(String topic){
		Connection con=null;
		con=Connect.get();
		try {
			PreparedStatement ps=con.prepareStatement("insert into topic values ( null,?)");
			ps.setString(1,topic);
			boolean rowinsert=ps.execute();
			if(rowinsert)
				System.out.println("Topic Addred");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}