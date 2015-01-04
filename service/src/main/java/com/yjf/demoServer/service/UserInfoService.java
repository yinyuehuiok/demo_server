package com.yjf.demoServer.service;

import com.yjf.demoServer.model.UserInfoModel;

public interface UserInfoService {
	
	UserInfoModel get(String username);
	
	boolean insert(UserInfoModel model);

}
