package com.tongx.property;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestProperty {
	//使用类的有参数构造注入
	@Test
	public void testUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PropertyDemo1 demo1 = (PropertyDemo1) context.getBean("demo1");
		demo1.test1();
	}
	//使用set方法注入
	@Test
	public void testBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book = (Book) context.getBean("book");
		book.test();
	}
	//注入对象类型属性
	@Test
	public void testUserDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}
	//p名称空间注入
	@Test
	public void testPerson() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) context.getBean("person");
		person.test();
	}
	//复杂类型属性注入
	@Test
	public void testPerson1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person1 person1 = (Person1) context.getBean("person1");
		person1.test();
	}
}
