package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.models.FAQs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFAQs extends AppCompatActivity {


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_faqs);

        recyclerView = findViewById(R.id.RecyclerViewListFAQS);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        //doRanking();

    }


    /*public void doRanking() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI API = retrofit.create(RetrofitAPI.class);
        Call<List<FAQs>> call = API.getFAQs();
        call.enqueue(new Callback<List<FAQs>>() {
            @Override
            public void onResponse(Call<List<FAQs>> call, Response<List<FAQs>> response) {

                if (response.isSuccessful()) {
                    Log.d("onResponse", "lista ha llegado");
                    List<FAQs> listaFAQ = response.body();
                    recyclerView = findViewById(R.id.RecyclerViewListFAQS);

                    RecyclerFAQ myAdapter = new RecyclerFAQ(getApplicationContext(), listaFAQ);
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<FAQs>> call, Throwable t) {
                Log.d("onFailure", "lista no ha llegado");
            }
        });


    }*/


}