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

    /**
     * 獲取city guide列表，異步網絡方法
     * @param startPageId 分頁條件
     * @param count 查詢數量
     * @param callback 異步回調
     */
    public void getLine(long startPageId, final int count, final HandyCallback<CityGuideLineResultVo.CityGuideLineEntityVo> callback) {
        final String METHOD_NAME = "getLine";
        logCall(METHOD_NAME, "startPageId=" + startPageId + ", count" + count);

        Call<CityGuideLineResultVo> call = cityGuideNet.listRepos(TEST_USER_NAME);
        call.enqueue(new Callback<CityGuideLineResultVo>() {
            @Override public void onResponse(Call<CityGuideLineResultVo> call, Response<CityGuideLineResultVo> response) {
                if (!handleSuccess(METHOD_NAME, response.body(), callback)) {
                    return ;
                }

                /** 制造一些测试数据 **/
                List<CityGuideLineResultVo.CityGuideLineEntityVo> result = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    result.add(CityGuideLineResultVo.CityGuideLineEntityVo.buildTest(i));
                }
                callback.onSuccess(null, result);
            }

            @Override public void onFailure(Call<CityGuideLineResultVo> call, Throwable t) {
                /** 临时错误处理 **/
//                handleFailure(METHOD_NAME, callback, t, call);

                /**  這裡只是為了測試， 總是返回成功的數據 **/
                List<CityGuideLineResultVo.CityGuideLineEntityVo> result = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    result.add(CityGuideLineResultVo.CityGuideLineEntityVo.buildTest(i));
                }
                callback.onSuccess(null, result);
            }
        });
    }
}
