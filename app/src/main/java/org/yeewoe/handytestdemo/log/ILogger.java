package org.yeewoe.handytestdemo.log;

/**
 * 日誌接口
 * Created by ivo on 2017/3/30.
 */

public interface ILogger {
    void i(String tag, String msg);
    void w(String tag, String msg);
    void w(String tag, String msg, Throwable throwable);
    void e(String tag, String msg);
    void e(String tag, String msg, Throwable throwable);
}
