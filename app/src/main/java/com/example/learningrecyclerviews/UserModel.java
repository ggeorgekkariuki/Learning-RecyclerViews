package com.example.learningrecyclerviews;

public class UserModel {
    /*
        This is a class that holds data objects and a constructor
         */
//    Set up constructor variables
    private String userName;

    public UserModel(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
