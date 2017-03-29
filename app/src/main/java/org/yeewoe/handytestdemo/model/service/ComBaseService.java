package org.yeewoe.handytestdemo.model.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 公共业务接口基类
 * Created by ivo on 2017/3/29.
 */

public abstract class ComBaseService<T> {

    protected Retrofit buildDefaultRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
