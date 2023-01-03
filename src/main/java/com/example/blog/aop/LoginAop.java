package com.example.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LoginAop {

    @Pointcut("execution(* com.example.blog.controller.PageController.*(..))" +
            "&& @annotation(com.example.blog.aop.Login)")
    public void cut(){};


    @Around("cut()")
    public Object checkLogin(ProceedingJoinPoint joinPoint)throws Throwable{
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if(session.getAttribute("SESSION_NAME")==null){
            return "index";
        }else {
            return joinPoint.proceed();
        }
    }
}
