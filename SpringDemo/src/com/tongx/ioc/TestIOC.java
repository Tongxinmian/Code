package com.tongx.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tongx.bean.*;

public class TestIOC {
	@Test
	public void testUser1() {
		//1. 加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 得到配置创建的对象
		User user = (User) context.getBean("user");
		System.out.println(user);
	}
	@Test
	public void testUser2() {
		//1. 加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 得到配置创建的对象
		Bean1 bean1 = (Bean1) context.getBean("bean1Factory");
		System.out.println(bean1);
	}
	@Test
	public void testUser3() {
		//1. 加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 得到配置创建的对象
		Bean2 bean2 = (Bean2) context.getBean("bean2");
		System.out.println(bean2);
	}
}
