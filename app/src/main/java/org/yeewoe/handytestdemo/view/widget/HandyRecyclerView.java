package org.yeewoe.handytestdemo.view.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * 全局使用的RecyclerView，可進行簡單的日誌跟蹤
 * Created by ivo on 2017/3/30.
 */

public class HandyRecyclerView extends XRecyclerView {
    public HandyRecyclerView(Context context) {
        super(context);
    }

    public HandyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HandyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
