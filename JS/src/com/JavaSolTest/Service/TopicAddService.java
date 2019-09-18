package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.TopicAddDao;

public class TopicAddService {
	TopicAddDao topicAddDao=new TopicAddDao();
		public void TopicAdd(String topic){
			topicAddDao.TopicAdd(topic);
		}
}
