package com.linkcanary.xinjuewang.leakcanary.ThreadMemoryLeak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.linkcanary.xinjuewang.leakcanary.R;

public class ThreadMemoryLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_memory_leak_layout);

        //匿名内部类runnable，在thread执行完之前，它不会释放
        //所以Activity不会释放
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        });
        t.start();
    }
}
