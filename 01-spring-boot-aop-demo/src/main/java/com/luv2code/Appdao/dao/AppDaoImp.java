package com.luv2code.Appdao.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImp implements AppDAO {
    @Override
    public void addAccount(Account account , boolean check) {
        System.out.println(" Doing my DB works : add my account in database");
    }

    @Override
    public void goSleep() {
        System.out.println("Go to sleep !");
    }
}
