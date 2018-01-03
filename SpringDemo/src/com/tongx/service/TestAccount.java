package com.tongx.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
	@Test
	public void testAccount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext6.xml");
		OrdersService ordersService = (OrdersService) context.getBean("ordersService");
		ordersService.accountMoney();
	}
}
