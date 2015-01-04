package com.yjf.demoServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.demoServer.dao.UserInfoDao;
import com.yjf.demoServer.model.UserInfoModel;
import com.yjf.demoServer.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfoModel get(String username) {
		return userInfoDao.get(username);
	}

	public boolean insert(UserInfoModel model) {
		return userInfoDao.insert(model);
	}

}
