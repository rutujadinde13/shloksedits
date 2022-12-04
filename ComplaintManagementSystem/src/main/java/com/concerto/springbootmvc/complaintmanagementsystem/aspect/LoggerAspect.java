package com.concerto.springbootmvc.complaintmanagementsystem.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	private static Logger logger = Logger.getLogger(LoggerAspect.class);

	@Pointcut("execution(* com.concerto.springbootmvc.complaintmanagementsystem.controller..*.*(..)) || execution(* com.concerto.springbootmvc.complaintmanagementsystem.service..*.*(..))||execution(* com.concerto.springbootmvc.complaintmanagementsystem.entity..*.*(..))")
	public void pointcut() {
		// Do nothing because of X and Y.

	}

//Adding Controller logger 
	@Around(value = "pointcut()")
	public Object intercept(ProceedingJoinPoint pjp) throws Throwable {

		Signature name = pjp.getSignature();
		try {
			logger.info("started " + name);
			Object obj = pjp.proceed();
			logger.info("finished " + name + " successfully");
			return obj;
		} catch (Throwable t) {
			logger.error(name + " finished with Exception - " + t.getMessage());
			throw t;
		} finally {
			// Do nothing because of X and Y.
		}
	}
}