package com.yjf.demoServer.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yjf.demoServer.dao.UserInfoDao;
import com.yjf.demoServer.model.UserInfoModel;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private Class<UserInfoModel> getEntityClass() {
		return UserInfoModel.class;
	}

	private RowMapper<UserInfoModel> getEntityRowMapper() {
		return new BeanPropertyRowMapper<UserInfoModel>(getEntityClass());
	}

	public UserInfoModel get(String username) {
		String sql = "select * from user_info where username=?";
		return  DataAccessUtils.singleResult(simpleJdbcTemplate.query(sql, getEntityRowMapper(), username));
	}

	public boolean insert(UserInfoModel model) {
		String sql = "insert into user_info(username,password) values(?,?)";
		return simpleJdbcTemplate.update(sql, model.getUsername(),model.getPassword())==1;
	}

}
