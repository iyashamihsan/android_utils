package com.example.demoproject;

import android.app.Application;
import android.content.BroadcastReceiver;

import com.example.demoproject.receivers.NetworkChangeReceiver;

public class CustomApp extends Application {

    private BroadcastReceiver receiver;
    private NetworkChangeReceiver mR;

    @Override
    public void onCreate() {
        super.onCreate();

        //mR = new NetworkChangeReceiver();
        //receiver = DynamicReceiver.with(mR)
          //      .register(this);
    }
}
