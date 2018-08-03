package com.linkcanary.xinjuewang.leakcanary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.linkcanary.xinjuewang.leakcanary.InnerClassMemoryLeak.InnerClassMemoryLeakActivity;
import com.linkcanary.xinjuewang.leakcanary.LoaclVariableMemoryLeak.LoaclVariableMemoryLeakActivity;
import com.linkcanary.xinjuewang.leakcanary.PostRunnableMemoryLeak.PostRunnableMemoryLeakActivity;
import com.linkcanary.xinjuewang.leakcanary.RegisterMemoryLeak.RegisterMemoryLeakActivity;
import com.linkcanary.xinjuewang.leakcanary.SingletonLeak.SingletonMemoryLeakActivity;
import com.linkcanary.xinjuewang.leakcanary.ThreadMemoryLeak.ThreadMemoryLeakActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.singleton_memoryleak);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,SingletonMemoryLeakActivity.class);
                startActivity(i);
            }
        });

        Button btn2 = (Button) findViewById(R.id.inner_class_memoryleak);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,InnerClassMemoryLeakActivity.class);
                startActivity(i);
            }
        });

        Button btn3 = (Button) findViewById(R.id.inner_class_memoryleak);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,PostRunnableMemoryLeakActivity.class);
                startActivity(i);
            }
        });

        Button btn4 = (Button) findViewById(R.id.thead_runnable_memoryleak);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,ThreadMemoryLeakActivity.class);
                startActivity(i);
            }
        });

        Button btn5 = (Button) findViewById(R.id.local_ver_memoryleak);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,LoaclVariableMemoryLeakActivity.class);
                startActivity(i);
            }
        });

        Button btn6 = (Button) findViewById(R.id.broadcast_reciver_memoryleak);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,RegisterMemoryLeakActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d("wxj", "onDestroy: MainActivity");
        super.onDestroy();
    }
}
