package com.example.sd2020.demo.model;

public class UserFactory {

    public User getUser(String userType){

        if(userType == null){
            return null;
        }

        if(userType.equalsIgnoreCase("Client")){
            return new Client();

        }

        if(userType.equalsIgnoreCase("Book")){
            return new Book();

        }

        return null;
    }
}
