package com.hemlata.app.aop;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.hemlata.app.entity.ExpenseStorage;
import com.hemlata.app.support.ExpenseRecorder;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = Logger.getLogger("LoggingAspect.Logger"); 

	@Before("execution(public * com.springboot.expense_tracker.controller.*.*(..))")
	public void beforeExpenseStorageRelatedMethod(JoinPoint theJoinPoint) {		 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();		
		logger.info("Method = " + methodSig);
		Object[] args = theJoinPoint.getArgs();

		for(Object tempArg: args) {			 			 
			if(tempArg instanceof ExpenseStorage) { 
				ExpenseStorage theExpenseStorage = (ExpenseStorage) tempArg;
				logger.info("Object = " + theExpenseStorage.toString());
			}
			if(tempArg instanceof HttpServletRequest) { 
				HttpServletRequest request = (HttpServletRequest) tempArg;
				logger.info("Object = " + request.getRequestURI());
			}
		}
	}
	
	@Before("execution(public * com.springboot.expense_tracker.controller.*.*(..))")
	public void beforeExpenseRecorderRelatedMethod(JoinPoint theJoinPoint) {		 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();		
		logger.info("Method = " + methodSig);
		Object[] args = theJoinPoint.getArgs();

		for(Object tempArg: args) {			 			 
			if(tempArg instanceof ExpenseRecorder) { 
				ExpenseRecorder theExpenseRecorder = (ExpenseRecorder) tempArg;
				logger.info("Object = " + theExpenseRecorder.toString());
			}
			if(tempArg instanceof HttpServletRequest) { 
				HttpServletRequest request = (HttpServletRequest) tempArg;
				logger.info("Object = " + request.getRequestURI());
			}
		}
	}
	
	@After("execution(public * com.springboot.expense_tracker.service.*.*(..))")
	public void afterServicesMethod(JoinPoint theJoinPoint) {		 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();		
		logger.info("Method = " + methodSig);
	}
}
