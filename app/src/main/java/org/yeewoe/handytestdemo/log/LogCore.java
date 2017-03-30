package org.yeewoe.handytestdemo.log;

import org.yeewoe.handytestdemo.BuildConfig;
import org.yeewoe.handytestdemo.config.LogTagConfig;

/**
 * 日誌調用核心類
 * Created by ivo on 2017/3/30.
 */

public class LogCore {

    /**
     * 網絡接口專用
     */
    public static void logNet(String msg) {
        i(LogTagConfig.NET, msg);
    }

    /**
     * 本地數據層接口專用
     */
    public static void logDB(String msg) {
        i(LogTagConfig.DB, msg);
    }

    /**
     * 業務接口層接口專用
     */
    public static void logService(String msg) {
        i(LogTagConfig.SERVICE, msg);
    }

    /**
     * 業務接口層接口專用
     */
    public static void logService(String msg, Throwable throwable) {
        w(LogTagConfig.SERVICE, msg, throwable);
    }

    public static void i(String tag, String msg) {
        ILogger logger;
        /** debug下打印到文件, 正式包只打印到Logcat減少性能損耗 **/
        if (BuildConfig.DEBUG) {
            logger = new FileLogger();
        } else {
            logger = new LogcatLogger();
        }
        logger.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        ILogger logger;
        /** debug下打印到文件, 正式包只打印到Logcat減少性能損耗 **/
        if (BuildConfig.DEBUG) {
            logger = new FileLogger();
        } else {
            logger = new LogcatLogger();
        }
        logger.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable throwable) {
        ILogger logger;
        /** debug下打印到文件, 正式包只打印到Logcat減少性能損耗 **/
        if (BuildConfig.DEBUG) {
            logger = new FileLogger();
        } else {
            logger = new LogcatLogger();
        }
        logger.w(tag, msg, throwable);
    }

    public static void e(String tag, String msg) {
        ILogger logger = new FileLogger();
        logger.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        ILogger logger = new FileLogger();
        logger.e(tag, msg, throwable);
    }

}
