package com.luv2code.Appdao.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myLoggingAspectDemo {
    @Pointcut("execution( * com.luv2code.Appdao.dao.*.*(..))")
    public void forDaoPackage(){}
    @Pointcut("execution( * com.luv2code.Appdao.dao.*.get*(..))")
    public void getter(){}
    @Pointcut("execution( * com.luv2code.Appdao.dao.*.set*(..))")
    public void setter(){}
    @Pointcut("forDaoPackage() && !(getter()||setter())")
    public void forDaoPackageNotGetterAndSetter(){}

}
