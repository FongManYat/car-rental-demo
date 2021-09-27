package com.fwy.carrentaldemo.entity;

import java.util.Arrays;
import java.util.List;

public class User {

    private int userid;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
