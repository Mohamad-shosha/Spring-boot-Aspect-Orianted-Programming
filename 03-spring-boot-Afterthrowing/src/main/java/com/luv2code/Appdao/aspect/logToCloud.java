package com.luv2code.Appdao.aspect;
import com.luv2code.Appdao.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(3)
public class logToCloud {
    @AfterThrowing(pointcut = "execution(* com.luv2code.Appdao.dao.AppDAO.findAccounts(..))" ,throwing = "exc")
    public void afterThrowingFindAccountsAdvic(JoinPoint joinPoint , Throwable exc ){
        Signature method = joinPoint.getSignature();
        System.out.println("execution After Throwing : "+method); // print signature ....
        System.out.println("Thr Exception is : "+exc); // print list of account ....
    }
     @AfterReturning( pointcut = "execution(* com.luv2code.Appdao.dao.AppDAO.findAccounts(..))" ,returning ="result" )
   public void afterReturningFindAccountsAdvic(JoinPoint joinPoint , List<Account> result){
       Signature method = joinPoint.getSignature();
       System.out.println("execution After returning : "+method); // print signature ....
       System.out.println("Thr result is : "+result); // print list of account ....
       convertAccountNameToUpperCase(result);
       System.out.println("The result is : "+result);
   }

    private void convertAccountNameToUpperCase(List<Account> result) {
         for (Account tempAccount : result){
             String theUpperCase = tempAccount.getName().toUpperCase();
             tempAccount.setName(theUpperCase);
         }
    }

    @Before("com.luv2code.Appdao.aspect.myLoggingAspectDemo.forDaoPackageNotGetterAndSetter()")
    public void logToCloud(JoinPoint joinPoint){
        System.out.println("\n >>>>>> Logging to the cloud in async fashion ");
        /*
        // methodSignature ......
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("The method signature is :- "+methodSignature);
        // The metadata of argument .....
        Object [] args =joinPoint.getArgs();
        for(Object o : args){
            System.out.println("Object is : "+  o );
        }*/
    }
}