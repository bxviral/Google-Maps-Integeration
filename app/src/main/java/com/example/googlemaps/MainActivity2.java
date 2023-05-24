package com.example.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {
    Button googleMap,listAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        googleMap = findViewById(R.id.googleMap);
        listAddress = findViewById(R.id.listAddress);

        googleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
//                startActivity(intent);
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity2.this);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();

            }
        });
        listAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,ListOfAddressActivity.class);
                startActivity(intent);
            }
        });

    }
}