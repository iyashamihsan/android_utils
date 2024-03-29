package com.example.demoproject.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.demoproject.eventsmodel.MessageEvent;
import com.example.demoproject.util.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        String status = NetworkUtil.getConnectivityStatusString(context);

        Toast.makeText(context, status, Toast.LENGTH_LONG).show();

        EventBus.getDefault().post(new MessageEvent(NetworkUtil.getConnectivity(context)));
    }
}