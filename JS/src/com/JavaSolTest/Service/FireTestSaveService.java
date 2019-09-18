package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.FireTestDao;
import com.JavaSolTest.Dao.FireTestSaveDao;
import com.JavaSolTest.Dto.SaveFireTestDto;

public class FireTestSaveService {
	FireTestSaveDao fireTestSaveDao=new FireTestSaveDao();
	public void saveTest(SaveFireTestDto dto){
		fireTestSaveDao.saveTest(dto);
	}
}
