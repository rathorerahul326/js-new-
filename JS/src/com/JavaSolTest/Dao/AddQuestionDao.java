package com.JavaSolTest.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.JavaSolTest.Dto.QuestionDto;
import com.JavaSolTest.Dto.TestQuestionDto;

public class AddQuestionDao {

	public void AddQuestion(QuestionDto questionDto) {
		Connection con = null;
		con = Connect.get();
		try {
			PreparedStatement ps = con.prepareStatement("insert into question values (?,?,?,?,?,?,?,?,null)");
			ps.setInt(1, questionDto.getStid());
			ps.setString(2, questionDto.getQuestion());
			ps.setString(3, questionDto.getA());
			ps.setString(4, questionDto.getB());
			ps.setString(5, questionDto.getC());
			ps.setString(6, questionDto.getD());
			ps.setString(7, questionDto.getAns());
			ps.setString(8, questionDto.getMarking());
			boolean rowaffect = ps.execute();
			if (rowaffect) {
				System.out.println("Question Added");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<TestQuestionDto> getQuestionid(int subtopicid, int numberofq) {

		Connection con = null;
		con = Connect.get();

		List<TestQuestionDto> listofQuestion = new ArrayList<>();

		List<Integer> list = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement("select qid from question where stid='" + subtopicid + "'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				list.add(rs.getInt("qid"));

			}

			Random random = new Random();
			Set<Integer> repeat = new HashSet<>();

			while (repeat.size() != numberofq) {
				int index = random.nextInt(list.size());

				boolean value = repeat.add(index);

				if (value) {
					int noqid = list.get(index);
					// System.out.println ("question id" +noqid);

					try {
						PreparedStatement ps1 = con
								.prepareStatement("select * from question where qid='" + noqid + "'");

						ResultSet rs1 = ps1.executeQuery();

						while (rs1.next()) {

							TestQuestionDto testQuestion = new TestQuestionDto();

							testQuestion.setQid(noqid);
							Blob blob = rs1.getBlob("Question");
							InputStream inputStream = blob.getBinaryStream();

							BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
							String lane = "";
							List<String> singleQuestion = new ArrayList<>();
							try {
								while ((lane = bufferedReader.readLine()) != null) {
									singleQuestion.add(lane);
									// System.out.println(lane);
								}

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							testQuestion.setFetchQuestion(singleQuestion);
							testQuestion.setA(rs1.getString("A"));
							testQuestion.setB(rs1.getString("B"));
							testQuestion.setC(rs1.getString("C"));
							testQuestion.setD(rs1.getString("D"));
							testQuestion.setMarking(rs1.getInt("marking"));
							testQuestion.setStid(rs1.getInt("stid"));
							testQuestion.setCorrectAns(rs1.getString("ans"));

							listofQuestion.add(testQuestion);

						}

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listofQuestion;

	}

}
