package com.nk.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class ValidationAdvice {

@Around(value = "execution(* com.nk.test.*.show(..))")
public void around(ProceedingJoinPoint pjb) throws Throwable{	
	System.out.println("sdfsafsa");
	Object[] methodArguments = pjb.getArgs();
	Data data = (Data)methodArguments[0];
	System.out.println(data.getName());
	System.out.println(methodArguments[1]);
   pjb.proceed();
}
	
}
