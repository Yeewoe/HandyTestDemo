package org.yeewoe.handytestdemo.model.vo;

import com.google.gson.annotations.SerializedName;

import org.yeewoe.handytestdemo.picture.ImageHelper;

import java.util.List;

/**
 * city guide 列表vo
 * Created by ivo on 2017/3/29.
 */

public class CityGuideLineResultVo extends ComResultVo {

    @SerializedName("data")
    public List<CityGuideLineResultVo> data;

    public static class CityGuideLineEntityVo extends ComEntityVo {

        /**
         * 發佈時間（一般都會有）
         */
        @SerializedName("time")
        public long time;

        /**
         * 版本號（如果有，可用於做本地數據和網絡數據的比對）
         */
        @SerializedName("version")
        public long version;

        @SerializedName("picture")
        public String picture;

        @SerializedName("title")
        public String title;

        @SerializedName("content")
        public String content;

        public static CityGuideLineEntityVo buildTest(int i) {
            CityGuideLineEntityVo result = new CityGuideLineEntityVo();
            int remainder = i % 3;
            if (remainder == 0) {
                result.title = "WoaW Store";
                result.content = "Lifestyle-fashion store WoaW is in the hip district of SOHO, surrounded by a slew of popular Lifestyle-fashion store WoaW is in the hip district of SOHO, surrounded by a slew of popular Lifestyle-fashion store Woaw is in the hip district of SOHO, surrounded by a slew of popular ";
                result.picture = ImageHelper.TEST_1;
            } else if (remainder == 1) {
                result.picture = ImageHelper.TEST_BIG;
            } else if (remainder == 2) {
                result.title = "Armoury";
                result.content = "This photogenic store offers everything from artisanal men's shoes and blazers, to shirts an This photogenic store offers everything from artisanal men's shoes and blazers, to shirts an This photogenic store offers everything from artisanal men's shoes and blazers, to shirts an";
                result.picture = ImageHelper.TEST_2;
            }
            return result;
        }
    }

}
