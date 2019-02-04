package com.user.mgmt.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	@Before("execution(* com.user.mgmt.service.UserManagementService.saveUser(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("Before Adding User record");
		System.out.println(joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.user.mgmt.service.UserManagementService.saveUser(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("After save user method execution : ");
		System.out.println(joinPoint.getSignature().getName());
	}

}
