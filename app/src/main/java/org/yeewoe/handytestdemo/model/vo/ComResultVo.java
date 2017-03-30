package org.yeewoe.handytestdemo.model.vo;

import com.google.gson.annotations.SerializedName;

/**
 * 基础显示层模型
 * Created by ivo on 2017/3/29.
 */

public abstract class ComResultVo {

    /**
     * 狀態碼，為0是成功
     */
    @SerializedName("status")
    public Integer status;
}
