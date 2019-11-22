package com.example.demoproject.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.demoproject.R;
import com.example.demoproject.eventsmodel.MessageEvent;
import com.example.demoproject.receivers.NetworkChangeReceiver;
import com.example.demoproject.servercom.RetrofitClientInstance;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BaseActivity extends Activity {

    LinearLayout screenRootView;
    TextView errorTv;

    NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.base_network_error_layout);
        //registerReceiver(broadcastReceiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));

        networkChangeReceiver = new NetworkChangeReceiver();

        //registerReceiver(networkChangeReceiver,new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(networkChangeReceiver,intentFilter);

        screenRootView = (LinearLayout) findViewById(R.id.base_view);
        errorTv = (TextView) findViewById(R.id.network_error_tv);

        errorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BaseActivity.this, "Retry Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*@Override
    public void setContentView(int resId) {

        *//*screenRootView = new LinearLayout(this);
        screenRootView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        screenRootView.setOrientation(LinearLayout.VERTICAL);

        // Create your top view here
        TextView topView = new TextView(this); // Replace this topview with your view
        topView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        topView.setText("Base View Error!");
        topView.setTextColor(Color.BLACK);
        topView.setBackgroundColor(Color.RED);
        topView.setPadding(16,16,16,16);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View screenView = inflater.inflate(resId, null);
        topView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //You will get onclick here of your topview in whatever screen it is clicked
                RetrofitClientInstance.getRetrofitInstance();
            }
        });

        screenRootView.addView(topView);
        screenRootView.addView(screenView);


        screenRootView.setVisibility(View.GONE);*//*

        super.setContentView(R.layout.base_network_error_layout);

    }
*/
    public void showErrorUI(){

        if (screenRootView != null){

            screenRootView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {

        if (event.isNetworkAvailable()){

            if (screenRootView != null){

                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View screenView = inflater.inflate(R.layout.activity_main, null);

                screenRootView.setVisibility(View.GONE);

                setContentView(screenView);
            }
        }
        else {

            if (screenRootView != null){

                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View screenView = inflater.inflate(R.layout.activity_main, null);

                screenRootView.setVisibility(View.VISIBLE);

                setContentView(screenRootView);
            }
        }

    }
}
