package com.example.myapplication.models;



public class User {

    private String name;
    private String password;
    private String username;
    private String mail;
    private int coins;
    private String idUser;
    //public List<Item> itemList = new ArrayList<>();
    //private double numCoins;
    // private List<String> items;
    public User(String name, String username, String pass, String mail, int coins /*,String id*/) {
        this.name = name;
        this.password = pass;
        this.username = username;
        this.mail = mail;
        this.coins = coins;
        //this.idUser=id;
    }
    //public List<Item> getItemList(){
    //    return itemList;
    //}


    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {

    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
