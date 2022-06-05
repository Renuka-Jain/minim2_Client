package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.myapplication.models.Stats;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Ranking extends AppCompatActivity {


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = findViewById(R.id.recyclerrrr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        doRanking();

    }


    public void doRanking(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI API = retrofit.create(RetrofitAPI.class);
        Call<List<Stats>> call = API.getRanking();
        call.enqueue(new Callback<List<Stats>>() {
            @Override
            public void onResponse(Call<List<Stats>> call, Response<List<Stats>> response) {

                if(response.isSuccessful()){
                    Log.d("onResponse", "lista ha llegado");
                    List<Stats> listaStats = response.body();
                    recyclerView = findViewById(R.id.recyclerrrr);

                    RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getApplicationContext(), listaStats);
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<List<Stats>> call, Throwable t) {
                Log.d("onFailure", "lista no ha llegado");
            }
        });



    }


}