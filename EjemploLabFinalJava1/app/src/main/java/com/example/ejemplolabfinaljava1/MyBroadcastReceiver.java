package com.example.ejemplolabfinaljava1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if ("com.example.ejemplolabfinaljava1.ACTION_COUNTER_UPDATED".equals(intent.getAction())) {
                int counter = intent.getIntExtra("counter", 0);
                Toast.makeText(context, "Counter: " + counter, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
