package com.linkcanary.xinjuewang.leakcanary.PostRunnableMemoryLeak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.linkcanary.xinjuewang.leakcanary.R;


public class PostRunnableMemoryLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable_memory_leak);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);

        // 这个runnable,是一个匿名的内部类
        // 持有一个外部类的引用
        // 它被post到mainloop里面去了，在执行之前，这个Activity是不会释放的
        layout.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },999999999);

    }
}
