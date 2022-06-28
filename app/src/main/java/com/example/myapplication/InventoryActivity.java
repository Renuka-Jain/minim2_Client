package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.RegisterCredentials;
import com.example.myapplication.models.Inventory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InventoryActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        username = sharedPref.getString("User",null);

        recyclerView = findViewById(R.id.recyclerviewdelinventory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        doRanking();

    }


    public void doRanking(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI API = retrofit.create(RetrofitAPI.class);
        Call<List<Inventory>> call = API.getInventoryUser(username);
        call.enqueue(new Callback<List<Inventory>>() {
            @Override
            public void onResponse(Call<List<Inventory>> call, Response<List<Inventory>> response) {

                if(response.isSuccessful()){
                    Log.d("onResponse", "lista ha llegado");
                    List<Inventory> listaItem = response.body();
                    recyclerView = findViewById(R.id.recyclerviewdelinventory);

                    RecyclerInventario myAdapter = new RecyclerInventario(getApplicationContext(), listaItem);
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<List<Inventory>> call, Throwable t) {
                Log.d("onFailure", "lista no ha llegado");
            }
        });



    }



}