package com.tongx.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook2 {
	@Before(value="execution(* com.tongx.aop.Book2.add(..))")
	public void before1() {
		System.out.println("before...");
	}
}
