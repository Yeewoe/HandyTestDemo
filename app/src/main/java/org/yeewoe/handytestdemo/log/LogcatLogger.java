package org.yeewoe.handytestdemo.log;

import android.util.Log;

/**
 * Logcat日誌工具
 * Created by ivo on 2017/3/30.
 */

public class LogcatLogger implements ILogger {
    @Override public void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    @Override public void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    @Override public void w(String tag, String msg, Throwable throwable) {
        Log.w(tag, msg, throwable);
    }

    @Override public void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    @Override public void e(String tag, String msg, Throwable throwable) {
        Log.e(tag, msg, throwable);
    }
}
