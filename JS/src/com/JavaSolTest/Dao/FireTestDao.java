package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.JavaSolTest.Dto.FireTestDto;
import com.JavaSolTest.Dto.SaveFireTestDto;

public class FireTestDao {
	public List<FireTestDto> getTest() {
		Connection con = null;
		con = Connect.get();
		List<FireTestDto> list = new ArrayList<FireTestDto>();
		try {
			PreparedStatement ps = con.prepareStatement("select test_id, test_name from test");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FireTestDto fireTestDto = new FireTestDto();
				fireTestDto.setTest_id(rs.getInt(1));
				fireTestDto.setTest_name(rs.getString(2));
				list.add(fireTestDto);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<SaveFireTestDto> gettestid(String uid) {

		List<SaveFireTestDto> list = new ArrayList<>();

		Connection con = null;
		con = Connect.get();
		int tid = 0;

		DateFormat date1 = new SimpleDateFormat("MM-dd-yyyy");
		String date = date1.format(new Date());

		try {

			PreparedStatement ps = con.prepareStatement(
					"select f_id,test_name,test_id,date,start_time,end_time,duration,total from test t natural join firetest");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				SaveFireTestDto dto = new SaveFireTestDto();

				Date dbDate = rs.getDate("date");
				String dbDate1 = date1.format(dbDate);

				tid = getDaytest(uid, date);

				if (date.equals(dbDate1) && tid == 0) {

					dto.setFtid(rs.getInt("f_id"));
					dto.setTestId(rs.getInt("test_id"));
					dto.setDate1(rs.getDate("date"));
					dto.setStartTime(rs.getString("start_time"));
					dto.setEndTime(rs.getString("end_time"));
					dto.setName(rs.getString("test_name"));
					dto.setTotal(rs.getInt("total"));
					dto.setDuration(rs.getInt("duration"));

					list.add(dto);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public int getDaytest(String uid, String dbDate1) {

		Connection con = null;
		con = Connect.get();
		int tid = 0;

		try {

			PreparedStatement ps = con
					.prepareStatement("select testid from scorecard where id='" + uid + "' and date='" + dbDate1 + "' ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				tid = rs.getInt("testid");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tid;

	}

}
