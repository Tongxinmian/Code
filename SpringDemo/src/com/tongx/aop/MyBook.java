package com.tongx.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {
	public void before1() {
		System.out.println("前置通知...");
	}
	public void after1() {
		System.out.println("后置通知...");
	}
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("方法之前...");
		proceedingJoinPoint.proceed();
		System.out.println("方法之后...");
	}
}
