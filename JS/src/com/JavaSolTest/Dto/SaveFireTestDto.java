package com.JavaSolTest.Dto;

import java.util.Date;

public class SaveFireTestDto {
	
	private int ftid;
	private int testId;
	private String date;
	private Date date1;
	private String startTime;
	private String endTime;
	private String name;
	private int total;
	private int duration;
	private String status="Start";
	
	
	public int getFtid() {
		return ftid;
	}
	public void setFtid(int ftid) {
		this.ftid = ftid;
	}
	public String getName() {
		return name;
	}
	public void setName(String testname) {
		this.name = testname;
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
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTestId() {
		return testId;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String sTime) {
		this.startTime = sTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String eTime) {
		this.endTime = eTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
