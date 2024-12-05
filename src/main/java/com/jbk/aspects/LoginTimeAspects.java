package com.jbk.aspects;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoginTimeAspects {

	Logger logger = LoggerFactory.getLogger(LoginTimeAspects.class);
		
	
//	@Before("execution(* com.jbk.*.*.*(..))")
//	public void captureStartTime() {
//		System.out.println("StartTime ="+LocalDateTime.now());
//	}
//	
//	@After("execution(* com.jbk.*.*.*(..))")
//	public void captureendTime() {
//		System.out.println("endTime ="+LocalDateTime.now());
//	}

@Around("execution(* com.jbk.controller.*.*(..))")
public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	
	long startTime = System.currentTimeMillis();
	 Object obj = joinPoint.proceed();
	 long endTime = System.currentTimeMillis();
	
	logger.info("Excecution time :"+(endTime - startTime));
	 return obj;
   }
	
}
