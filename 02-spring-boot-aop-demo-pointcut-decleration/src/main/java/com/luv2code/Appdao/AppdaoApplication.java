package com.luv2code.Appdao;

import com.luv2code.Appdao.dao.Account;
import com.luv2code.Appdao.dao.AppDAO;
import com.luv2code.Appdao.dao.MemberDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AppdaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppdaoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appdao , MemberDAO memberDAO) {
        return runner -> {
            demoTheAfterReturningAdvice(appdao);
        };
    }

    private void demoTheAfterReturningAdvice(AppDAO appdao) {
        List<Account> list = appdao.findAccounts();

        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("----");

        System.out.println(list);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AppDAO appdao , MemberDAO memberDAO) {
        Account account = new Account("Mohamed","Intermediate");
        appdao.addAccount(account , true);

        appdao.setName("Mohamed");
        appdao.setServiceCode("luv2code");
        String name = appdao.getName();
        String ServiceCode = appdao.getServiceCode();

        memberDAO.addMembership();
        memberDAO.addMemberShip();
        appdao.goSleep();
    }


}
