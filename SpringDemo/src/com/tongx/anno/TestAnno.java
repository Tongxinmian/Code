package com.tongx.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {
	@Test
	public void testUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		User user = (User) context.getBean("user");
		user.add();
	}
	@Test
	public void testDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}
}
