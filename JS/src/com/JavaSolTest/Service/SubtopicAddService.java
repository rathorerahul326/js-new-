package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.SubtopicAddDao;


public class SubtopicAddService {
	SubtopicAddDao subtopicAddDao=new SubtopicAddDao();
	public void SubTopicAdd(String subtopic,int tid){
		 subtopicAddDao.SubTopicAdd(subtopic,tid);
	}
}
