package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.CreateTestSubtopicDao;

public class CreateTestSubtopicService {
	CreateTestSubtopicDao createTestSubtopicDao=new CreateTestSubtopicDao();
	
	public String getSubtopic(String topicID){
		 return createTestSubtopicDao.GetSubtopic(topicID);
	}

}
