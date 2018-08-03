package com.linkcanary.xinjuewang.leakcanary.RegisterMemoryLeak;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.linkcanary.xinjuewang.leakcanary.R;

public class RegisterMemoryLeakActivity extends Activity {

    DateChangedBroadCastReciver reciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_memory_leak);

        registerReceiver(reciver,new IntentFilter());

    }

    @Override
    protected void onDestroy() {
        Log.d("wxj", "onDestroy: RegisterMemoryLeakActivity");
        super.onDestroy();
    }
}
