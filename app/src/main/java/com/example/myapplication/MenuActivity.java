package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void buttonLOGOUT(android.view.View v) {
        SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void buttonRanking(android.view.View v) {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }

    public void buttonProfile(android.view.View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void buttonTienda(android.view.View v) {
        Intent intent = new Intent(this, TiendaActivity.class);
        startActivity(intent);
    }

    public void buttonInventory(android.view.View v) {
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }

}