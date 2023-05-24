package com.example.googlemaps;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Pref {

    public static void writeListInPref(Context context, ArrayList<AddressData> addressData) {

        String jsonString = new Gson().toJson(addressData);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("list_key", jsonString);
        editor.apply();
    }

    public static ArrayList<AddressData> readListFromPref(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString("list_key", "");
        return new Gson().fromJson(jsonString, new TypeToken<ArrayList<AddressData>>() {
        }.getType());
    }
}
