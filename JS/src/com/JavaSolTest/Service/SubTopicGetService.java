package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.SubTopicGetDao;

public class SubTopicGetService {
	SubTopicGetDao subTopicGetDao=new SubTopicGetDao();
	public String GetData(int topicID){
		return subTopicGetDao.GetData(topicID);
	}
}