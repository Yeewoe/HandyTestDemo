package org.yeewoe.handytestdemo;

import android.app.Application;

/**
 * 核心Application
 *
 * Created by ivo on 2017/3/28.
 */

public class HandyApplication extends Application {
    private static HandyApplication mInstance;

    @Override public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static HandyApplication getInstance() {
        return mInstance;
    }
}
