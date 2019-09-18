package com.JavaSolTest.Dto;

import java.util.List;

public class TestQuestionDto {

	
	private int stid;
	private int testid;
	private String question;
	private List<String> fetchQuestion;
	private int marking;
	private String a;
	private String b;
	private String c;
	private String d;
	private int duration; 
	private int qid;
	private String correctAns;
	private String fetchAns;
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public int getMarking() {
		return marking;
	}
	public void setMarking(int i) {
		this.marking = i;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public List<String> getFetchQuestion() {
		return fetchQuestion;
	}
	public void setFetchQuestion(List<String> fetchQuestion) {
		this.fetchQuestion = fetchQuestion;
	}
	public String getFetchAns() {
		return fetchAns;
	}
	public void setFetchAns(String fetchAns) {
		this.fetchAns = fetchAns;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	
	
}
