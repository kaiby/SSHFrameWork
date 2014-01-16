package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.bean.User;
import com.test.service.UserService;

public class AjaxLoginAction extends ActionSupport{
	
	private String loginName;
	
	private String password;
	
	private UserService userService;
	
	private String result;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() throws Exception {
		User user = userService.queryUserByName(loginName);
		if (null != user) {
			if (password.equals(user.getPassWord())) {
				result = "登陆成功！";
			} else {
				result = "密码不正确！";
			}
		} else {
			result = "用户名不存在！";
		}
		return null;
	}
	

}
