package com.tongx.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	//xml方式
	@Test
	public void testBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
	
	//注解方式
	@Test
	public void testBook2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
		Book2 book2 = (Book2) context.getBean("book2");
		book2.add();
	}
}
