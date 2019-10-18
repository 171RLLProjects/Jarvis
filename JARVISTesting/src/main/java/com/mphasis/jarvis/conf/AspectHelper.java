package com.mphasis.jarvis.conf;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHelper {
	
	private static Logger logger =Logger.getLogger(AspectHelper.class);
	
	@Pointcut("execution(* com.mphasis.training.*.*.*(..))")
	public void getAll() {
		logger.debug("APp COnfig GetALL");
		
	}
	@Before("getAll()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("Before the Method "+joinPoint.getSignature().getName());
		logger.debug(Arrays.toString(joinPoint.getArgs()));
	}
	

	@After("getAll()")
	public void AfterMethod(JoinPoint joinPoint) {
		logger.debug("After the Method "+joinPoint);
		logger.debug(Arrays.toString(joinPoint.getArgs()));
	}

}
