package com.luv2code.Appdao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myLoggingAspectDemo {
    // @Before("execution(public void com.luv2code.Appdao.dao.AppDAO.addAccount(..))")// @Before("execution( void add*())")
    // @Before("execution( * add*(..))")
    // @Before("execution( void add*(com.luv2code.Appdao.dao.Account))")
    // @Before("execution( void add*(com.luv2code.Appdao.dao.Account,..))")
    // @Before("execution( void add*(..))")
    // @Before("execution( * add*(..))")
    // @Before("execution( void com.luv2code.Appdao.dao.*.*(..))")
    @Before("execution( * com.luv2code.Appdao.dao.*.*(..))")
    public void codeBeforeAdvice(){
        System.out.println("\n >>>>>> Execution @before advice on addAccount");
    }
}
