package com.example.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAdvice {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.example.blog.main.controller.*Controller.*(..))"
            +" || execution(* com.example.blog.main.service.*Service.*(..))"
            +" || execution(* com.example.blog.main.repository.*Repository.*(..))")
    public Object logMainPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //객체명
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();

        //proceedingJoinPoint.getSignature().getName() <- 실행 메서드명
        log.info("[[START]]"+type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
        log.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));//<-파라미터
        log.info("================[[END : "+proceedingJoinPoint.getSignature().getName()+"()]]==================");

        return proceedingJoinPoint.proceed();
    }
    @Around("execution(* com.example.blog.xenium..controller.*Controller.*(..))"
            +" || execution(* com.example.blog.xenium.*.service.*Service*.*(..))"
            +" || execution(* com.example.blog.xenium.*.repository.*Repository.*(..))")
    public Object logXeniumPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //객체명
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();

        //proceedingJoinPoint.getSignature().getName() <- 실행 메서드명
        log.info("[[START]]"+type+"."+proceedingJoinPoint.getSignature().getName()+"() <=================");
        log.info("Argument/Parameter : "+ Arrays.toString(proceedingJoinPoint.getArgs()));//<-파라미터
        log.info("================[[END : "+proceedingJoinPoint.getSignature().getName()+"()]]==================");

        return proceedingJoinPoint.proceed();
    }

}
