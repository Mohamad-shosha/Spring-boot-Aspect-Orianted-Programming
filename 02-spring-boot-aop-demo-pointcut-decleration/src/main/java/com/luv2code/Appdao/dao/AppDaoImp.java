package com.luv2code.Appdao.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppDaoImp implements AppDAO {
    private String name;
    private String serviceCode ;

    public String getName() {
        System.out.println(getClass()+" Get Name !");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" Set Name !");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" Get ServiceCode !");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" Set ServiceCode !");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        List<Account> list = new ArrayList<>();
        Account account1 = new Account("Karim","easy");
        Account account2 = new Account("Mohamed","Hard");
        Account account3 = new Account("Fayes","Advanced");
        list.add(account1);
        list.add(account2);
        list.add(account3);
        return list;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account account , boolean check) {
        System.out.println(getClass()+" Doing my DB works : add my account in database");
    }

    @Override
    public void goSleep() {
        System.out.println(getClass()+" Go to sleep !");

    }
}
