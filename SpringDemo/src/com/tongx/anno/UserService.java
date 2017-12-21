package com.tongx.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
//	@Autowired
//	private UserDao userDao;
//	使用注解方式时不需要set方法
//	第二种注解方式,name属性值是注解方式创建的UserDao对象的value值
//	相当于xml方式中的注入对象属性<property name="userDao" ref="userDao"></property>中的ref属性
	@Resource(name="userDao")
	private UserDao userDao;
	public void add() {
		System.out.println("service...");
		userDao.add();
	}

}
