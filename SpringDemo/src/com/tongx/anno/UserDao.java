package com.tongx.anno;

import org.springframework.stereotype.Component;

//value可以省略不写  @Component("userDao")
@Component(value="userDao")  
public class UserDao {
	public void add() {
		System.out.println("dao...");
	}
}












