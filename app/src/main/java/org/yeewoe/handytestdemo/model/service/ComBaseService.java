package org.yeewoe.handytestdemo.model.service;

import org.yeewoe.handytestdemo.HandyApplication;
import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.config.ErrorCodeConfig;
import org.yeewoe.handytestdemo.log.LogCore;
import org.yeewoe.handytestdemo.model.vo.ComResultVo;
import org.yeewoe.handytestdemo.util.ErrorCodeUtil;

import java.net.UnknownHostException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 公共业务接口基类，封裝了狀態處理，日誌動作等
 * Created by ivo on 2017/3/29.
 */

public abstract class ComBaseService {

    protected Retrofit buildDefaultRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
//                .callbackExecutor() // 這裡可以給配置特定的線程池，未簡單線程部分代碼，這裡用默認的線程池子
                .build();
    }

    /**
     * 公共判断是否成功的方法，只有当返回的{@link ComResultVo#status} 为null或者{@link ErrorCodeConfig#SUCCESS}时成功
     */
    protected boolean handleSuccess(String methodName, ComResultVo resultVo, HandyCallback handyCallback) {
        if (resultVo.status == null || resultVo.status == ErrorCodeConfig.SUCCESS) {
            return true;
        }
        logFail(methodName, resultVo.status);
        handyCallback.onFail(resultVo.status);
        return false;
    }

    /**
     * 公共處理異常方法
     */
    protected <T> void handleFailure(String methodName, HandyCallback handyCallback, Throwable t, Call<T> call) {
        logFail(methodName, t);
        if (t instanceof UnknownHostException) {
            handyCallback.onFail(ErrorCodeConfig.ERROR_NETWORK);
        } else {
            handyCallback.onFail(500);
        }
    }

    /**
     * 日誌：調用開始使用
     */
    protected void logCall(String methodName, String params) {
        LogCore.logService("methodName: " + methodName + ", params: " + params);
    }

    /**
     * 日誌：調用失敗使用
     */
    protected void logFail(String methodName, Throwable throwable) {
        LogCore.logService("methodName: " + methodName + ", call fail!!!", throwable);
    }

    /**
     * 日誌：調用失敗使用
     */
    protected void logFail(String methodName, int errorCode) {
        LogCore.logService("methodName: " + methodName + ", call fail!!! errorCode=" + errorCode + ", errorMsg=" + ErrorCodeUtil.parse(HandyApplication.getInstance(), errorCode));
    }

}
