package com.linkcanary.xinjuewang.leakcanary.LoaclVariableMemoryLeak;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.linkcanary.xinjuewang.leakcanary.R;

public class LoaclVariableMemoryLeakActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_memory_leak);

        Button btn = (Button) findViewById(R.id.test_btn);
        Log.d("wxj", "onCreate: LoaclVariableMemoryLeakActivity ");
        Log.d("wxj", "onCreate: btn = "+btn);
        AndroidUtil.getInstance(btn).setText("123456");
    }

    @Override
    protected void onDestroy() {
        Log.d("wxj", "onDestroy: LoaclVariableMemoryLeakActivity");
        super.onDestroy();
    }
}
