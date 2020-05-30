package com.example.learningrecyclerviews;

import java.io.Serializable;

public class UserModel implements Serializable {
    /*
    This is a class that holds data objects and a constructor
    To serialize an object means to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object.
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
