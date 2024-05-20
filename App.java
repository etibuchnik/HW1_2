package com.example.hw_12;


import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //SharedPreferencesManagerV3.init(this);
        SignalManager.init(this);

    }
}