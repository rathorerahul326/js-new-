package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.QuestionGetDao;

public class QuestionGetService {
	QuestionGetDao questionGetDao=new QuestionGetDao();
	public String getQuestion(int stid){
		return questionGetDao.GetQuestion(stid);
	}
}
