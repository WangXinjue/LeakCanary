package com.linkcanary.xinjuewang.leakcanary.SingletonLeak;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.linkcanary.xinjuewang.leakcanary.R;

import java.util.ArrayList;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SingletonMemoryLeakActivity extends Activity {

    //就是单纯的要占用一块内存
    ArrayList mMemoryBlock = new ArrayList();

    TextView mPkgName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_singleton_memory_leak_layout);

        //内存已经占用了，看看是否能释放掉
        for(int i = 0;i<1000000;i++){
            mMemoryBlock.add("1234567890");
        }

        //获取包名的方法
        //AndroidUtil是一个单利模式，它的生命周期，基本跟进程是一样的
        //AndroidUtil持有了一个Activity的引用，那么在进程结束前，Activity是不会被回收
        //这里是人为制造的内存泄漏，退出这个Activity，或者横竖屏切换一次，就可以造成泄漏
        //AndroidUtil只有第一次初始化时候，会持有一个Activity，只有第一个Activity在ondestory之后释放不掉
        //反复进入这个Activity，不会导致内存反复的增加
        String name = AndroidUtil.getInstance(this).getPackageName();

        mPkgName = (TextView) findViewById(R.id.pkg_name);
        mPkgName.setText("包名是："+name);

    }
    @Override
    protected void onDestroy() {
        Log.d("wxj", "onDestroy: MainActivity");
        super.onDestroy();
    }
}
