package com.tongx.anno;

import org.springframework.stereotype.Component;

@Component(value="user")  //<bean id="user" class=""></bean>
public class User {
	public void add() {
		System.out.println("add.....");
	}
}

