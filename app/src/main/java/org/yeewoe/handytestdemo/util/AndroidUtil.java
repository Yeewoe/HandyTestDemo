package org.yeewoe.handytestdemo.util;

import android.content.Context;

import java.lang.reflect.Field;

/**
 * 系统工具类
 * Created by ivo on 2017/3/30.
 */

public class AndroidUtil {
    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusbarHeight(Context context) {

        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            int y = context.getResources().getDimensionPixelSize(x);
            return y;
        } catch (Exception e) {
            e.printStackTrace();
            return (int) (context.getResources().getDisplayMetrics().density * 20 + 0.5);
        }
    }
}
