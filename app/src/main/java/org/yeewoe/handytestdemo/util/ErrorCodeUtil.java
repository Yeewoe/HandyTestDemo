package org.yeewoe.handytestdemo.util;

import android.content.Context;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.config.ErrorCodeConfig;

/**
 * 错误码处理工具
 * Created by ivo on 2017/3/29.
 */

public class ErrorCodeUtil {

    public static String parse(Context context, int errorCode) {
        /** 这里针对不同错误码转化成错误提示语 **/
        if (errorCode == ErrorCodeConfig.ERROR_NETWORK) {
            return context.getString(R.string.error_network);
        }

        return context.getString(R.string.error_unknown, errorCode);
    }
}
