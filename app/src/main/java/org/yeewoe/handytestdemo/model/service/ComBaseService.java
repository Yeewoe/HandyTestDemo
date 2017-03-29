package org.yeewoe.handytestdemo.model.service;

import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.model.vo.CityGuideLineResultVo;
import org.yeewoe.handytestdemo.util.ErrorCodeUtil;

import java.net.UnknownHostException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 公共业务接口基类
 * Created by ivo on 2017/3/29.
 */

public abstract class ComBaseService {

    protected Retrofit buildDefaultRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 公共處理異常方法
     */
    protected <T> void handleFailure(HandyCallback handyCallback, Throwable t, Call<List<T>> call) {
        if (t instanceof UnknownHostException) {
            handyCallback.onFail(ErrorCodeUtil.ERROR_NETWORK);
        } else {
            handyCallback.onFail(500);
        }
    }

}
