package com.JavaSolTest.Service;

import java.util.List;

import com.JavaSolTest.Dao.TopicGetDao;
import com.JavaSolTest.Dto.TopicGetDto;

public class TopicGetService {
	TopicGetDao topicGetDao=new TopicGetDao();
	public List<TopicGetDto> topicGet(){
		return topicGetDao.topicget();
	}
}
