package com.yjf.demoServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.demoServer.model.UserInfoModel;
import com.yjf.demoServer.service.UserInfoService;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {
 
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/get")
	public String get(String username,String password,ModelMap model){
		UserInfoModel userInfo = userInfoService.get("yjf");
		model.addAttribute("result", userInfo.getPassword());
		return "output";
	}
}
