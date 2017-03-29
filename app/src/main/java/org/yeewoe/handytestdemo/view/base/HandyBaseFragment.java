package org.yeewoe.handytestdemo.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础Fragment
 * Created by ivo on 2017/3/28.
 */

public abstract class HandyBaseFragment extends Fragment {

    private View mContentView;
    private Unbinder mUnBinder;

    /**
     * 获取布局文件
     */
    protected abstract int getContentViewLayoutId();

    /**
     * 同步加载数据
     */
    protected abstract void loadSyncData();

    /**
     * 异步加载数据
     */
    protected abstract void loadAsyncData();

    @Override final public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(getContentViewLayoutId(), null);
        mUnBinder = ButterKnife.bind(this, mContentView);
        initView(mContentView);
        bindViewListener(mContentView);

        return mContentView;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadSyncData();
        loadAsyncData();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    /**
     * 初始化View
     */
    protected void initView(View contentView) {

    }

    /**
     * 绑定View事件
     */
    protected void bindViewListener(View contentView) {

    }
}
