package com.example.myapplication.models;

public class Stats {
    private int id;
    private String user;
    private String date;
    private int score;
    private String avatar;

    public Stats(int id, String user, String date, int score, String avatar) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.score = score;
        this.avatar=avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
