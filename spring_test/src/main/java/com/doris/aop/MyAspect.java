package com.doris.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before(){
        System.out.println("前置增强");
    }

    public void afterReturning(){
        System.out.println("后置增强");
    }

    // ProceedingJoinPoint 正执行的连接点=切点
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        //切点方法执行
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
    }

    public void afterThrowing(){
        System.out.println("抛出异常增强");
    }

    public void after(){
        System.out.println("最终增强");
    }
}
