package org.yeewoe.handytestdemo.presenter;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dinuscxj.refresh.RecyclerRefreshLayout;

import org.yeewoe.handytestdemo.adapter.ComListAdapter;
import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.callback.UICallback;
import org.yeewoe.handytestdemo.model.vo.ComEntityVo;

import java.util.List;

/**
 * 列表公共presenter
 * Created by ivo on 2017/3/29.
 */

public abstract class ComListPresenter<T extends ComEntityVo> implements RecyclerRefreshLayout.OnRefreshListener {
    private Activity activity;
    private RecyclerRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private ComListAdapter<T> adapter;

    public abstract void call(Object startPageParam, int count, HandyCallback<T> defaultCallback);

    protected abstract int getPageCount();

    public ComListPresenter(Activity activity, RecyclerRefreshLayout refreshLayout, RecyclerView recyclerView, ComListAdapter<T> comListAdapter) {
        this.activity = activity;
        this.refreshLayout = refreshLayout;
        this.recyclerView = recyclerView;
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        this.refreshLayout.setOnRefreshListener(this);
        this.adapter = comListAdapter;
        this.recyclerView.setAdapter(adapter);
    }

    /**
     * 开始加载数据
     */
    public void load() {
        refreshLayout.setRefreshing(true);
        onRefresh();
    }

    @Override public void onRefresh() {
        call(null, getPageCount(), new DefaultCallback(getActivity(), true));
    }

    public Activity getActivity() {
        return activity;
    }

    public ComListAdapter getAdapter() {
        return adapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public RecyclerRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }


    private class DefaultCallback extends UICallback<T> {

        private boolean isRefresh; // 是否是走下拉刷新的回调，否则就是走分页的

        public DefaultCallback(Activity activity, boolean isRefresh) {
            super(activity);
            this.isRefresh = isRefresh;
        }

        @Override public void onUISuccess(T entity, List<T> entities) {
            getRefreshLayout().setRefreshing(false);
            if (isRefresh) {
                adapter.setAll(entities);
            } else {
                adapter.addAll(entities);
            }
        }

        @Override public void onUIFail(int errorCode, String errorMsg) {
            /** 对错误的公共处理方法 **/
            getRefreshLayout().setRefreshing(false);
            Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
        }
    }

}
