package com.example.myapplication;

import com.example.myapplication.models.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitAPI {
    public static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    @POST("user/login")
    Call<User> userLogIn(@Body CredentialsLogIn cdl);

    @POST("user/add")
    Call<User> addUser(@Body User user);

    @GET("user/")
    Call<List<User>> getAllUsers();

    @GET("user/{username}")
    Call<User> getUser(@Path("username") String username);

    @DELETE("user/delete/{username}")
    Call<Void> deleteUser(@Path("username") String username);

    @PUT("user/update/{username}")
    Call<User> updateUser(@Path("username") String oldUsername, @Body RegisterCredentials rCr);

    @GET("store/get")
    Call<List<Item>> getAllItem();

    @PUT("store/buy")
    Call<Void> getItem(@Body Item i);

    @PUT("store/use/{username}")
    Call<Void> useItem(@Path("username") String username, String nameitem);

    @POST("game/add")
    Call<Game> addGame(@Body Game g);

    @GET("game/rankingAll")
    Call<List<Game>> getRankingAll();

    @GET("game/{username}")
    Call<List<Stats>> getRankingUser(@Path("username") String username);

    @GET("user/userInventoryList/{username}")
    Call<List<Inventory>> getInventoryUser(@Path("username") String username);

}