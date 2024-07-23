package com.luv2code.Appdao.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class preformApiAnalytics {
    @Before("com.luv2code.Appdao.aspect.myLoggingAspectDemo.forDaoPackageNotGetterAndSetter()")
    public void preformApiAnalytics(){System.out.println("\n >>>>>> Preforming API Analytics ");}
}
