package com.example.myapplication.models;

public class CredentialsLogIn {

    private String username;
    private String password;

    public CredentialsLogIn(String username, String pass) {
        this.username = username;
        this.password = pass;
    }
    public CredentialsLogIn() {

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}


