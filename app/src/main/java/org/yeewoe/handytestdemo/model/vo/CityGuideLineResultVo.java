package org.yeewoe.handytestdemo.model.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * city guide 列表vo
 * Created by ivo on 2017/3/29.
 */

public class CityGuideLineResultVo extends ComResultVo {

    @SerializedName("data")
    public List<CityGuideLineResultVo> data;

    public static class CityGuideLineEntityVo extends ComEntityVo {

        @SerializedName("picture")
        public String picture;

        @SerializedName("title")
        public String title;

        @SerializedName("content")
        public String content;

        public static CityGuideLineEntityVo buildTest() {
            CityGuideLineEntityVo result = new CityGuideLineEntityVo();
            result.title = "a";
            result.content = "b";
            return result;
        }
    }

}
