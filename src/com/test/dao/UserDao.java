package com.test.dao;

import java.util.List;

import com.test.base.BaseDao;
import com.test.bean.User;

public class UserDao extends BaseDao<User> {

	public List<User> getUserList(User user) {
		List<User> list = queryForList(
				"from User where userName = ? and passWord = ?", new Object[] {
						user.getUserName(), user.getPassWord() });
		return list;
	}

	public User queryUserByName(String loginName) {
		return this.queryForObject("from User where loginName = ?",
				new Object[] { loginName });
	}

	public User queryUserById(String id) {
		return this.queryById(User.class, new Integer(id));
	}

}
