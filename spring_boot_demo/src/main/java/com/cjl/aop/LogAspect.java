package com.cjl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class LogAspect {
    @Before("execution(* com.cjl.service.UserServiceImpl.*(..))")
    public void before(JoinPoint jp) {
        System.out.println("jp.getSignature().getName() = " + jp.getSignature().getName());
    }
}