package com.JavaSolTest.Service;

import com.JavaSolTest.Dao.Verify;
import com.JavaSolTest.Dto.LoginDto;

public class UserService {

	public int testlogin(LoginDto ld) {

		String id=  ld.getId();
		String pass= ld.getPass();
		if (id.equals("")||pass.equals(""))
		{
			return 1;
		}
		
		int value= Verify.verify(ld);
		return value;
	}
	
	public int testsignup(LoginDto ld) {
		// TODO Auto-generated method stub
		
		String id= ld.getId();
		
		if (id.equals(""))
		{
			return 1;
		}
	
	int value= Verify.verifysignup(ld);
	return value;
	}
	
	}


