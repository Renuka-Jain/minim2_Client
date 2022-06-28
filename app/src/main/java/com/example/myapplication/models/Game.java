package com.example.myapplication.models;

public class Game {
    private String username;
    private int coins;
    private int points;
    private String date;
    private String avatar;

    public Game(){
    }

    public Game(String username, int coins, int points, String date, String avatar){
        this.username=username;
        this.coins=coins;
        this.points=points;
        this.avatar=avatar;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
