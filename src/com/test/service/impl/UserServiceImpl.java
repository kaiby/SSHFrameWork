package com.test.service.impl;

import java.util.List;

import com.test.bean.User;
import com.test.dao.UserDao;
import com.test.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(User user) {
		return null;
	}

	@Override
	public List<User> getUserList(User user) {
		return userDao.getUserList(user);
	}

	@Override
	public User queryUserByName(String loginName) {
		return userDao.queryUserByName(loginName);
	}

	@Override
	public User queryUserById(String id) {
		return userDao.queryUserById(id);
	}

}
