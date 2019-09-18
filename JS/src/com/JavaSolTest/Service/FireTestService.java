package com.JavaSolTest.Service;

import java.util.List;

import com.JavaSolTest.Dao.FireTestDao;
import com.JavaSolTest.Dto.FireTestDto;

public class FireTestService {
	FireTestDao fireTestDao=new  FireTestDao();
	public List<FireTestDto> getTest(){
		return fireTestDao.getTest();
	}
}
