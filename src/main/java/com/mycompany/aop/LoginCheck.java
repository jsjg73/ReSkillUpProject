package com.mycompany.aop;

import org.aspectj.lang.JoinPoint;

public class LoginCheck {
	public void loginSessionCheck(JoinPoint jp) {
		String name = jp.getArgs()[0].getClass().getName();
		System.out.println("[사전 처리 ] : 첫번째 인자 클래스 이름"+name);
	}
}
