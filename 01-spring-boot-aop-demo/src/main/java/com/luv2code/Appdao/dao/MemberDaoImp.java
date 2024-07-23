package com.luv2code.Appdao.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImp implements MemberDAO{
    @Override
    public void addMembership() {
        System.out.println(" Doing my DB works : add Membership in database");

    }

    @Override
    public boolean addMemberShip() {
        System.out.println("False");
        return false;
    }
}
