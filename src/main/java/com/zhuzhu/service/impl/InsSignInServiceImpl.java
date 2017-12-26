package com.zhuzhu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuzhu.dao.InsSignInDao;
import com.zhuzhu.entry.InsSignIn;
import com.zhuzhu.service.inte.InsSignInService;

@Service
public class InsSignInServiceImpl implements InsSignInService{

	@Autowired
	private InsSignInDao insSignInDao;
	
	public void save(InsSignIn insSingIn) {
		insSignInDao.save(insSingIn);
	}
    
    
}