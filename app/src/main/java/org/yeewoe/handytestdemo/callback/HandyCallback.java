package org.yeewoe.handytestdemo.callback;

import java.util.List;

/**
 * 全局专用Callback接口
 * Created by ivo on 2017/3/29.
 */

public interface HandyCallback<T> {
    void onSuccess(T entity, List<T> entities);

    void onFail(int errorCode);
}
