package com.tongx.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tongx.bean.*;

public class TestIOC {
	//使用类的无参数构造创建
	@Test
	public void testUser() {
		//1. 加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 得到配置创建的对象
		User user = (User) context.getBean("user");
		System.out.println(user);
	}
	//使用静态工厂创建
	@Test
	public void testBean1() {
		//1. 加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 得到配置创建的对象
		Bean1 bean1 = (Bean1) context.getBean("bean1Factory");
		System.out.println(bean1);
	}
	//使用实例工厂创建
	@Test
	public void testBean2() {
		//1. 加载spring配置文件，根据创建对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 得到配置创建的对象
		Bean2 bean2 = (Bean2) context.getBean("bean2");
		System.out.println(bean2);
	}
}