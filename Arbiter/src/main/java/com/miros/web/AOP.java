package com.miros.web;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// This is used in Walk.class

// Advice -> What? Before, After
//Pointcut -> Where?

@Aspect
@EnableAspectJAutoProxy
@Component
public class AOP {

	public AOP() {
		// TODO Auto-generated constructor stub
		System.out.println("AOP Created!");
	}
}
