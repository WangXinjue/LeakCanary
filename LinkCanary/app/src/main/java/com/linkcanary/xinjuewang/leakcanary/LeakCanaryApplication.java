package com.linkcanary.xinjuewang.leakcanary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by xinjue.wang on 2018/4/24.
 */

public class LeakCanaryApplication extends Application{

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("wxj", "onCreate: LeakCanaryApplication");
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        LeakCanaryApplication application = (LeakCanaryApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
