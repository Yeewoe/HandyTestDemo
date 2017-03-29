package org.yeewoe.handytestdemo.callback;

import android.app.Activity;

import org.yeewoe.handytestdemo.util.ErrorCodeUtil;

import java.util.List;

/**
 * UI使用callback
 * Created by ivo on 2017/3/29.
 */

public abstract class UICallback<T> implements HandyCallback<T> {

    private final Activity activity;

    public UICallback(Activity activity) {
        this.activity = activity;
    }


    @Override public void onSuccess(final T entity, final List<T> entities) {
        if (this.activity != null && !this.activity.isFinishing()) {
            this.activity.runOnUiThread(new Runnable() {
                @Override public void run() {
                    onUISuccess(entity, entities);
                }
            });
        }
    }

    @Override public void onFail(final int errorCode) {
        if (this.activity != null && !this.activity.isFinishing()) {
            this.activity.runOnUiThread(new Runnable() {
                @Override public void run() {
                    onUIFail(errorCode, ErrorCodeUtil.parse(activity, errorCode));
                }
            });
        }
    }

    public abstract void onUISuccess(T entity, List<T> entities);

    public abstract void onUIFail(int errorCode, String errorMsg);
}
