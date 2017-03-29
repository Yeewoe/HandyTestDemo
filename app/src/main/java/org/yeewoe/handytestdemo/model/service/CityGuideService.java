package org.yeewoe.handytestdemo.model.service;

import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.model.net.CityGuideNet;
import org.yeewoe.handytestdemo.model.vo.CityGuideLineResultVo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * city guide 业务接口
 * <p>
 * Created by ivo on 2017/3/29.
 */

public class CityGuideService extends ComBaseService {

    public static final String URL_CITY_GUIDE = "https://api.github.com/";
    public static final String TEST_USER_NAME = "Yeewoe";

    private final CityGuideNet cityGuideNet;

    public CityGuideService() {
        Retrofit retrofit = buildDefaultRetrofit(URL_CITY_GUIDE);
        cityGuideNet = retrofit.create(CityGuideNet.class);
    }

    public void getLine(long startPageId, final int count, final HandyCallback<CityGuideLineResultVo.CityGuideLineEntityVo> callback) {
        Call<List<CityGuideLineResultVo>> call = cityGuideNet.listRepos(TEST_USER_NAME);
        call.enqueue(new Callback<List<CityGuideLineResultVo>>() {
            @Override public void onResponse(Call<List<CityGuideLineResultVo>> call, Response<List<CityGuideLineResultVo>> response) {
                /** 制造一些测试数据 **/
                List<CityGuideLineResultVo.CityGuideLineEntityVo> result = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    result.add(CityGuideLineResultVo.CityGuideLineEntityVo.buildTest());
                }
                callback.onSuccess(null, result);
            }

            @Override public void onFailure(Call<List<CityGuideLineResultVo>> call, Throwable t) {
                /** 临时错误处理 **/
                callback.onFail(404);
            }
        });
    }
}
