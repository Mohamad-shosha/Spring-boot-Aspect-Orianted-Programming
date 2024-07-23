package com.luv2code.Appdao.aspect;
import com.luv2code.Appdao.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(3)
public class logToCloud {
    @Around("execution(* com.luv2code.Appdao.TrafficService.TrafficService.getfortune(..))")
    public Object Aroundgetfortune (ProceedingJoinPoint joinPoint) throws Throwable{
        Signature method = joinPoint.getSignature();
        System.out.println("\n >>>>>> execution Around Advice : "+method); // print signature ....
        Long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        }catch (Exception exc){
            System.out.println("The exception is : "+exc);
            result = "No resul to return it .....!";
        }

        Long end = System.currentTimeMillis();
        Long Delay = end - start;
        System.out.println("\n >>>>>> Finish execution by Around Advice "); // print signature ....
        System.out.println("\n Duration is : "+ Delay /1000 + " seconds" );
        return result;
    }
    @After("execution(* com.luv2code.Appdao.dao.AppDAO.findAccounts(..))")
    public void afterAdviceFindAccountsAdvic(JoinPoint joinPoint ){
        Signature method = joinPoint.getSignature();
        System.out.println("\n >>>>>> execution After (Finally) Advice : "+method); // print signature ....
    }
    @AfterThrowing(pointcut = "execution(* com.luv2code.Appdao.dao.AppDAO.findAccounts(..))" ,throwing = "exc")
    public void afterThrowingFindAccountsAdvic(JoinPoint joinPoint , Throwable exc ){
        Signature method = joinPoint.getSignature();
        System.out.println("\n >>>>>> execution After Throwing : "+method); // print signature ....
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