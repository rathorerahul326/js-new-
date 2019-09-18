package com.JavaSolTest.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.JavaSolTest.Dto.FireTestDto;
import com.JavaSolTest.Dto.ScoreDto;
import com.JavaSolTest.Dto.TestQuestionDto;

public class StudentAnswerDao {

	public void storeresult(TestQuestionDto dto, String user_id, int test_id) {

		Connection con = null;
		con = Connect.get();

		DateFormat date1 = new SimpleDateFormat("MM-dd-yyyy");
		String date = date1.format(new Date());

		try {

			PreparedStatement ps1 = con.prepareStatement("select * from studentanswer where id='" + user_id
					+ "'and testid='" + test_id + "'and qid='" + dto.getQid() + "' ");

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {

				PreparedStatement ps = con.prepareStatement(
						"update studentanswer set id=?, testid=?,qid=? ,Ans=?,CorrectAns=?,marks=? ,date=? where id=? and  testid=? and qid=? ");

				ps.setString(1, user_id);
				ps.setInt(2, test_id);
				ps.setInt(3, dto.getQid());
				ps.setString(4, dto.getFetchAns());
				ps.setString(5, dto.getCorrectAns());
				ps.setInt(6, dto.getMarking());
				ps.setString(7, date);
				ps.setString(8, user_id);
				ps.setInt(9, test_id);
				ps.setInt(10, dto.getQid());
				ps.executeUpdate();
			} else {

				PreparedStatement ps = con.prepareStatement("insert into studentanswer values(?,?,?,?,?,?,?)");
				ps.setString(1, user_id);
				ps.setInt(2, test_id);
				ps.setInt(3, dto.getQid());
				ps.setString(4, dto.getFetchAns());
				ps.setString(5, dto.getCorrectAns());
				ps.setInt(6, dto.getMarking());
				ps.setString(7, date);
				ps.executeUpdate();

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public ScoreDto showResult(String user_id, int testId, int noquest) {
		// TODO Auto-generated method stub

		int result = 0;
		int wrongresult = 0;
		int correctAnswer = 0;
		int noq = noquest;
		int notanswered = 0;
		ScoreDto sdto = new ScoreDto();

		Connection con = null;
		con = Connect.get();
		// System.out.println("invoked"+user_id+" "+testId);
		try {
			PreparedStatement ps = con.prepareStatement(
					"select * from studentanswer where id='" + user_id + "'and testid='" + testId + "' ");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String userAns = rs.getString("Ans");
				String correctAns = rs.getString("CorrectAns");
				/* marks=marks+(rs.getInt("marks")); */

				if (userAns.equals(correctAns)) {
					result = result + rs.getInt("marks");
					correctAnswer = correctAnswer + 1;
				}

				if (!userAns.equals("E") && !userAns.equals(correctAns)) {
					wrongresult++;
				}
				if (userAns.equals("E")) {

					notanswered++;
				}

			}

			sdto.setSkip(notanswered);
			sdto.setCorrectAnswer(correctAnswer);
			sdto.setTotalmarks(noq);
			sdto.setWrongAnswer(wrongresult);
			sdto.setResult(result);

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return sdto;
	}

	public void setResult(int testId, String user_id, int score_marks, int firetestid, int totmarks, String testname) {
		// TODO Auto-generated method stub
		Connection con = null;
		con = Connect.get();

		DateFormat date1 = new SimpleDateFormat("MM-dd-yyyy");
		String date = date1.format(new Date());

		try {
			PreparedStatement ps = con.prepareStatement("insert into scorecard values(?,?,?,?,?,?,?)");
			ps.setString(1, testname);
			ps.setInt(2, firetestid);
			ps.setString(3, user_id);
			ps.setInt(4, testId);
			ps.setInt(5, score_marks);
			ps.setInt(6, totmarks);
			ps.setString(7, date);

			ps.executeUpdate();

			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	/*
	 * public void StudentData(String user_id, int testId) { // TODO
	 * Auto-generated method stub
	 * 
	 * Connection con = null; con = Connect.get(); try { PreparedStatement ps =
	 * con.prepareStatement("delete from studentanswer where testid='" + testId
	 * + "' and id='" + user_id + "' "); ps.executeUpdate(); con.close(); }
	 * catch (Exception e) {
	 * 
	 * System.out.println(e); } }
	 */

	public List<FireTestDto> studentReport(String u_id) {
		// TODO Auto-generated method stub

		Connection con = null;
		con = Connect.get();
		List<FireTestDto> list = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from scorecard where id='" + u_id + "'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				FireTestDto dto = new FireTestDto();

				dto.setTest_id(rs.getInt("testid"));

				dto.setTest_name(rs.getString("TestName"));
				dto.setScore(rs.getInt("score"));
				dto.setTotalmarks(rs.getInt("total_marks"));
				dto.setDate(rs.getString("date"));

				list.add(dto);

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}

		return list;

	}

	public List<TestQuestionDto> studentAnswer(String u_id, int test_id) {
		// TODO Auto-generated method stub

		Connection con = null;
		con = Connect.get();
		List<TestQuestionDto> list = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(
					"select * from studentanswer where id='" + u_id + "'and testid='" + test_id + "'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				TestQuestionDto dto = new TestQuestionDto();

				int qid = rs.getInt("qid");

				dto.setFetchAns(rs.getString("Ans"));
				dto.setCorrectAns(rs.getString("CorrectAns"));

				PreparedStatement ps1 = con.prepareStatement("select * from question where qid='" + qid + "'");
				ResultSet rs1 = ps1.executeQuery();

				while (rs1.next()) {

					dto.setQuestion(rs1.getString("Question"));
					dto.setA(rs1.getString("A"));
					dto.setB(rs1.getString("B"));
					dto.setC(rs1.getString("C"));
					dto.setD(rs1.getString("D"));

				}

				list.add(dto);

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}

		return list;

	}

}
