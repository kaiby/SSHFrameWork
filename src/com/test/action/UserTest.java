package com.test.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.test.bean.User;
import com.test.service.UserService;

public class UserTest {
	
	private UserService userService;

	public void setUp() throws Exception {
		
		ApplicationContext ac = new FileSystemXmlApplicationContext ("WebRoot/WEB-INF/applicationContext.xml");
		userService = (UserService)ac.getBean("userService");
	}
	
	public void testItems(){
		User user = new User();
		user.setUserName("zoutao");
		user.setPassWord("111111");
		List<User> list = userService.getUserList(user);
		for (User user2 : list) {
			System.out.println(user2.getId());
		}
		System.out.println("--------------分隔符-------------");
		
		String loginName = "zoutao";
		String password = "111111";
		String result = "";
		User user2 = userService.queryUserByName(loginName);
		if (null != user2) {
			if (password.equals(user2.getPassWord())) {
				result = "登陆成功！";
			} else {
				result = "密码不正确！";
			}
		} else {
			result = "用户名不存在！";
		}
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		UserTest test=new UserTest();
		try {
			test.setUp();
			test.testItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
