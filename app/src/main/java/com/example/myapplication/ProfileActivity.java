package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.RegisterCredentials;
import com.example.myapplication.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    TextView textName;
    TextView textMail;
    TextView textUser;
    String username;
    User old;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textName = findViewById(R.id.editNameProfile);
        textMail = findViewById(R.id.editMailProfile);
        textUser=findViewById(R.id.editUserProfile);
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        username = sharedPref.getString("User",null);
        setDATA();

    }

    private void setDATA(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI API = retrofit.create(RetrofitAPI.class);
        Call<User> call = API.getUser(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int variable = response.code();
                Log.i("PROFILE CODE", ":"+variable);
                if(response.isSuccessful()){
                    User user = response.body();
                    old=user;
                    String userNom = user.getName();
                    Log.i("Name", ":"+ userNom);
                    textName.setText(userNom);
                    String userMail = user.getMail();
                    Log.i("Psw", ":"+ userMail);
                    textMail.setText(userMail);
                    textUser.setText(user.getUsername());

                }else {
                    Toast.makeText(ProfileActivity.this, "error profile setup", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("PROFILE", "ERROR",t);
                Toast.makeText(ProfileActivity.this, "Usuario no existe", Toast.LENGTH_LONG).show();
            }
        });


    }

    public void buttonGoBackProfile(android.view.View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void buttonChangeUser(android.view.View v) {
        Log.i("updaate"," onclick");
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        Log.i("updaate"," conn");

        RetrofitAPI API = retrofit.create(RetrofitAPI.class);
        Call<User> call = API.updateUser(username, new RegisterCredentials(textName.getText().toString(), textUser.getText().toString(), old.getPassword(), textMail.getText().toString()));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int variable = response.code();
                Log.i("REGISTER CODE", ":" + variable);
                if (response.isSuccessful()) {
                    User user = response.body();
                    Toast.makeText(ProfileActivity.this, "user updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ProfileActivity.this, "update error", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("REGISTER", "ERROR", t);
                Toast.makeText(ProfileActivity.this, "ERROR UPDATEAR USUARI", Toast.LENGTH_LONG).show();
            }

        });
    }

    public void buttonDeleteUser(android.view.View v) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI API = retrofit.create(RetrofitAPI.class);
        Call<Void> call = API.deleteUser(username);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int variable = response.code();
                Log.i("DELETE CODE", ":"+ variable);
                if(response.isSuccessful()){
                    Toast.makeText(ProfileActivity.this, "user profile properly deleted", Toast.LENGTH_LONG).show();
                    Log.e("DELETE", "OK");
                }else {
                    Toast.makeText(ProfileActivity.this, "error delete", Toast.LENGTH_LONG).show();
                    Log.e("DELETE", "ERROR");
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("DELETE", "ERROR",t);
                Toast.makeText(ProfileActivity.this, "Usuario no existe", Toast.LENGTH_LONG).show();
            }
        });
    }
}