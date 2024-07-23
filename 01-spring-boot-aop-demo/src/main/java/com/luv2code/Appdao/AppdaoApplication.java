package com.luv2code.Appdao;

import com.luv2code.Appdao.dao.Account;
import com.luv2code.Appdao.dao.AppDAO;
import com.luv2code.Appdao.dao.MemberDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppdaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppdaoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appdao , MemberDAO memberDAO) {
        return runner -> {
            demoTheBeforeAdvice(appdao,memberDAO);
        };
    }

    private void demoTheBeforeAdvice(AppDAO appdao , MemberDAO memberDAO) {
        Account account = new Account("Mohamed","Intermediate");
        appdao.addAccount(account , true);
        memberDAO.addMembership();
        memberDAO.addMemberShip();
        appdao.goSleep();
    }


}
