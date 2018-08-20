package com.example.marcelo.aula2.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Marcelo on 15/12/2017.
 */

public class SecurityPreferences {

    private final SharedPreferences mSharedPrefences ;


    public SecurityPreferences(Context context)
    {
        this.mSharedPrefences = context.getSharedPreferences("Fim de ano", context.MODE_PRIVATE);
    }


    public void storeString(String key, String value){
        this.mSharedPrefences.edit().putString(key, value).apply();
    }

    public  String getStoredString(String key)
    {
        return this.mSharedPrefences.getString(key, "");
    }

}
