package com.JavaSolTest.Dto;

public class ScoreDto {

	
 private int totalmarks;
 private int result;
 private int skip;
 private int attempted;
 private int wrongAnswer;
 private int correctAnswer;
 
public int getTotalmarks() {
	return totalmarks;
}
public void setTotalmarks(int totalmarks) {
	this.totalmarks = totalmarks;
}
public int getResult() {
	return result;
}
public void setResult(int result) {
	this.result = result;
}
public int getWrongAnswer() {
	return wrongAnswer;
}
public void setWrongAnswer(int wrongAnswer) {
	this.wrongAnswer = wrongAnswer;
}

public int getCorrectAnswer() {
	return correctAnswer;
}
public void setCorrectAnswer(int correctAnswer) {
	this.correctAnswer = correctAnswer;
}
public int getAttempted() {
	return attempted;
}
public void setAttempted(int attempted) {
	this.attempted = attempted;
}
public int getSkip() {
	return skip;
}
public void setSkip(int skip) {
	this.skip = skip;
}
}
