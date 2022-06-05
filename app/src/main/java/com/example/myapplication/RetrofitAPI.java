package com.example.myapplication;

import com.example.myapplication.models.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitAPI {
    public static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    @POST("user/login")
    Call<User> login(@Body UserData user);

    @POST("user/add")
    Call<User> add(@Body UserData user);

    @GET("user/")
    Call<List<User>> getAllUsers();

    @GET("stats/ranking")
    Call<List<Stats>> getRanking();


}