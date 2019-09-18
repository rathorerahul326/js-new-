package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.AddQuestionDao;
import com.JavaSolTest.Dto.QuestionDto;

public class AddQuestionService {
	AddQuestionDao addQuestionDao=new AddQuestionDao();
	public void AddQuestion(QuestionDto questionDto){
		addQuestionDao.AddQuestion(questionDto);
	}
}
