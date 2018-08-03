package com.linkcanary.xinjuewang.leakcanary.InnerClassMemoryLeak;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.linkcanary.xinjuewang.leakcanary.R;

public class InnerClassMemoryLeakActivity extends Activity {

    //静态对象，不能让他持有Activity，以及Activity的内部类
    //点击监听l，监听两个按钮的点击
    private static InnerOnClickListener l;

    //这个对象就是为了看打印的
    InnerClassMemoryLeakActivity mInnerClassMemoryLeakActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //这个对象就是为了看打印的，把看看点击时候的this，和oncreate的this是否相同
        mInnerClassMemoryLeakActivity = this;

        Log.d("wxj", "onCreate: InnerClassMemoryLeakActivity mInnerClassMemoryLeakActivity="+mInnerClassMemoryLeakActivity);

        setContentView(R.layout.inner_class_memory_leak_layout);

        Button btn1 = (Button) findViewById(R.id.btn1);

        Button btn2 = (Button) findViewById(R.id.btn2);

        // 静态对象 l ，持有了一个内部类的引用
        // 当Activity进行ondestory的时候，由于l持有了new InnerOnClickListener()的引用
        // 而new InnerOnClickListener()持有了外部类Activity的引用
        // 所有Activity不会被释放
        // 这种情况和singlton不同，它不是第一个Activity不被释放，而是上一个不背释放
        // 因为每次都会给l重新赋值，导致之前的new InnerOnClickListener()，被释放。
        l = new InnerOnClickListener();

        // 这里使用了l，监听两个btn
        // 不过是否使用l，对内存泄漏已经无所谓了
        btn1.setOnClickListener(l);
        btn2.setOnClickListener(l);


    }

    //声明一个内部类
    //内部类会持有外部类的引用
    //一个点击的监听，监听所有按钮的点击，这个是一个比较常用做法
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn1){
                Log.d("wxj", "onClick: InnerOnClickListener btn1 mInnerClassMemoryLeakActivity = "+mInnerClassMemoryLeakActivity);
            }

            if(v.getId() == R.id.btn2){
                Log.d("wxj", "onClick: InnerOnClickListener btn2 mInnerClassMemoryLeakActivity = "+mInnerClassMemoryLeakActivity);
            }

        }
    }
}
