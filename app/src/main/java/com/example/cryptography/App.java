package com.example.cryptography;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Locale;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration newConfig = new Configuration();
        newConfig.locale = Locale.ENGLISH;
        super.onConfigurationChanged(newConfig);
        Locale.setDefault(newConfig.locale);
        getBaseContext().getResources().updateConfiguration(newConfig,getResources().getDisplayMetrics());
    }
    public static void Loger(String m){
        Log.e("mip tag", m);
    }
    public static void ToastMaker

}
