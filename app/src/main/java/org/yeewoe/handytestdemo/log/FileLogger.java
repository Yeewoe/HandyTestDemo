package org.yeewoe.handytestdemo.log;

import android.util.Log;

/**
 * 文件日誌類
 *
 * 目前暫時不實現具體代碼<br />
 * 大致思路是使用一個線程池做文件輸出到sdcard
 *
 * Created by ivo on 2017/3/30.
 */

public class FileLogger implements ILogger {
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
