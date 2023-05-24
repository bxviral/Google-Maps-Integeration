package com.example.googlemaps;


import static com.example.googlemaps.MyApplicationClass.a1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListOfAddressActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_address);

        recyclerView = findViewById(R.id.recyclerViewAddress);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        sharedPreferences = getSharedPreferences("Google", MODE_PRIVATE);
//        int length = sharedPreferences.getInt("value",0);
//        for (int i = 0; i < length; i++) {
//
//            String add = sharedPreferences.getString("address" + i, null);
//            String lat = sharedPreferences.getString("latitude" + i, null);
//            String log = sharedPreferences.getString("longitude" + i, null);
//            double latd = Double.parseDouble(lat);
//            double logd = Double.parseDouble(log);
//            s.add(new AddressData(add, latd, logd));
//        }
        a1 = Pref.readListFromPref(this);
        if (a1 == null) {
            Log.e("TAG", "a1 is null: ");
            a1 = new ArrayList<>();
        }

        recyclerViewAdapter = new RecyclerViewAdapter(this, a1);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}