package com.JavaSolTest.Dto;

public class CreateTestDto {
	private int testid;
	private String name;
	private int total;
	private int subtid;
	private int duration;
	private String stid[];
	private String subtopicnoq[];
	private int noq;
	
	public int getNoq() {
		return noq;
	}
	public void setNoq(int noq) {
		this.noq = noq;
	}
	public int getSubtid() {
		return subtid;
	}
	public void setSubtid(int subtid) {
		this.subtid = subtid;
	}
	public String[] getStid() {
		return stid;
	}
	public void setStid(String[] stid) {
		this.stid = stid;
	}
	public String[] getSubtopicnoq() {
		return subtopicnoq;
	}
	public void setSubtopicnoq(String[] subtopicnoq) {
		this.subtopicnoq = subtopicnoq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getDuration() {
		return duration;
	}
	public int getTestId() {
		return testid;
	}
	public void setTestId(int testid) {
		this.testid = testid;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
