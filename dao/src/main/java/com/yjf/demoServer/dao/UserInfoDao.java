package com.yjf.demoServer.dao;

import com.yjf.demoServer.model.UserInfoModel;

public interface UserInfoDao {

	UserInfoModel get(String username);
	
	boolean insert(UserInfoModel model);
	
}
