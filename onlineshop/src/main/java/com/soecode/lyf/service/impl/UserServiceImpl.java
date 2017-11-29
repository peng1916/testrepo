package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.UserDao;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖
	@Autowired
	private UserDao userDao;

	@Override
	public User getById(long id) {
		return userDao.queryById(id);
	}

	@Override
	public List<User> getList() {
		return userDao.queryAll(0, 1000);
	}
	
	@Override
	public User getByPass(String name, String password, int role) {
		return userDao.queryByPass(name, password, role);
	}
}
