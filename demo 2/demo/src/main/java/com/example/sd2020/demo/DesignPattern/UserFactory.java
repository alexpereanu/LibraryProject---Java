package com.example.sd2020.demo.DesignPattern;

import com.example.sd2020.demo.arch.Client;

public class UserFactory {

    public User getUser(String userType){

        if(userType == null){
            return null;
        }

        if(userType.equalsIgnoreCase("Client")){
            return new Client();

        }

        return null;
    }
}
