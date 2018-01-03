package com.tongx.c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	@Test
	public void testService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}
	
}
