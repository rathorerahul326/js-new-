package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.CreateTestAddDao;
import com.JavaSolTest.Dto.CreateTestDto;

public class CreateTestAddService {
	CreateTestAddDao createTestAddDao=new CreateTestAddDao();
	public void Add(CreateTestDto createTestDto){
		createTestAddDao.Add(createTestDto);
	}

}
