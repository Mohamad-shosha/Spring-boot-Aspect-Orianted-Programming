package com.luv2code.Appdao.TrafficService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Repository
public class TrafficServiceImp implements TrafficService{

    @Override
    public String getfortune() {
        // define the delay time  ....
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getfortune(boolean flag) {
       if(flag){
           throw new RuntimeException(" High way is closed  !");
       }
        return "Expect heavy traffic this morning";
    }
}
