package org.yeewoe.handytestdemo.callback;

import java.util.List;

/**
 * 专用Callback
 * Created by ivo on 2017/3/29.
 */

public interface HandyCallback<T> {
    void onSuccess(T entity, List<T> entities);

    void onFail(int errorCode);
}
