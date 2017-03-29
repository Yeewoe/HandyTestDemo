package org.yeewoe.handytestdemo.model.net;

import org.yeewoe.handytestdemo.model.vo.CityGuideLineResultVo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * city guide网络层接口
 * Created by ivo on 2017/3/29.
 */

public interface CityGuideNet {

    /**
     * 模仿获取city guide 列表的接口，这里先用GitHub的接口做测试
     *
     * @param user GitHub用户名
     * @return 结果
     */
    @GET("users/{user}/repos")
    Call<List<CityGuideLineResultVo>> listRepos(@Path("user") String user);
}
