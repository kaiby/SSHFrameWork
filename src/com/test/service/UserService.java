package com.test.service;

import java.util.List;

import com.test.bean.User;

public interface UserService {
	
	public User login(User user);
	
	public List<User> getUserList(User user);
	
	public User queryUserByName(String loginName);
	
	public User queryUserById(String id);

}
