package com.example.management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.example.management.service.impl.*.user*())")
	public void getFnameAdvice() {
		logger.info("executing on find list of all users");
		System.out.println("this is from sysout for list");
	}
	
	@After("execution(* com.example.management.service.impl.UserServiceImpl.find*(*))")
	public void getAllAdvice(JoinPoint jp) {
		logger.info("before method "+jp);
		System.out.println("this is from sysout for list from "+jp);
		
	}
}
