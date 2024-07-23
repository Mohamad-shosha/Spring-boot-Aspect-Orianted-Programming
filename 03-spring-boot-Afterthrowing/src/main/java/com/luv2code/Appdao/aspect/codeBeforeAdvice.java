package com.luv2code.Appdao.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class codeBeforeAdvice {
    @Before("com.luv2code.Appdao.aspect.myLoggingAspectDemo.forDaoPackageNotGetterAndSetter()")
    public void codeBeforeAdvice(){
        System.out.println("\n >>>>>> before advice on addAccount ");

    }
}
