package com.example.willisproject2cs360;

public class User
{
    int id;
    String userName;
    String pass;

    public User() {
        super();
    }

    // constructor
    public User(int id,String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.pass = password;
    }

    public User(String userName, String tempPass) {
        this.userName = userName;
        this.pass = tempPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPass() {
        return pass;
    }

    public void setUserPass(String password) {
        this.pass = pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {return userName;}
}
