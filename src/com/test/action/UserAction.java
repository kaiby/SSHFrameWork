package com.test.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.test.base.BaseAction;
import com.test.bean.User;
import com.test.service.UserService;

public class UserAction extends BaseAction {

	private User user;

	private UserService userService;

	private String result;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String execute() throws Exception {
		User userInst = userService.queryUserByName(user.getLoginName());
		if (null != userInst) {
			if (user.getPassWord().equals(userInst.getPassWord())) {
				result = "登陆成功！";
			} else {
				result = "密码不正确！";
			}
		} else {
			result = "用户名不存在！";
		}
		System.out.println(result);
		return SUCCESS;
	}

	public String login() throws Exception {
		System.out.println("request login method.");
		User userInst = userService.queryUserByName(user.getLoginName());

		if (null != userInst) {
			if (user.getPassWord().equals(userInst.getPassWord())) {
				result = "登陆成功！";
			} else {
				result = "密码不正确！";
			}
		} else {
			result = "用户名不存在！";
		}

		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("user", userInst);
		return "success";
	}

}