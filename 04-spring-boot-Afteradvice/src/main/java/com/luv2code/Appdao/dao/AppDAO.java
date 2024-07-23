package com.luv2code.Appdao.dao;

import java.util.List;

public interface AppDAO {
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
    void addAccount(Account account , boolean check);
    void goSleep();
    public String getName() ;
    public void setName(String name) ;

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode) ;


}
