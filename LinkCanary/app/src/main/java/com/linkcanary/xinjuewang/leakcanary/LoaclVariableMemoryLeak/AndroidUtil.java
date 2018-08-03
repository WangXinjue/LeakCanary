package com.linkcanary.xinjuewang.leakcanary.LoaclVariableMemoryLeak;

import android.util.Log;
import android.widget.Button;

/**
 * Created by xinjue.wang on 2018/4/24.
 * 一个工具类，工程里面有很多这种工具类，需要一个Context作为参数。
 * 完成一些通用功能，比如px到dp的转化，获取网络状态等等。
 * 这个工具类的目context如果是一个Activity，可能会导致内存泄漏
 * 即一个静态变量，持有了一个Activity的引用，导致Activity即使ondestroy了，也不会被回收
 */

public class AndroidUtil {

    public static AndroidUtil instance;
    Button mButton;

    public static AndroidUtil getInstance(Button b){
        if(instance == null){
            instance = new AndroidUtil(b);
        }
        return instance;
    }

    AndroidUtil(Button b){
        mButton = b;
    }

    public void setText(String s){
        Log.d("wxj", "setText: AndroidUtil mButton="+mButton);
        mButton.setText(s);
    }

}
