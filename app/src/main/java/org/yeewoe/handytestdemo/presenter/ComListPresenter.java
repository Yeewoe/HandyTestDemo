package org.yeewoe.handytestdemo.presenter;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;

import org.yeewoe.handytestdemo.adapter.ComListAdapter;
import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.callback.UICallback;
import org.yeewoe.handytestdemo.model.vo.ComEntityVo;
import org.yeewoe.handytestdemo.view.widget.HandyRecyclerView;

import java.util.List;

/**
 * 公共列表的presenter，可統一處理列表邏輯<br />
 * 子類只需要完成接口調用部分就行，可參考{@link CityGuideListPresenter}
 *
 * Created by ivo on 2017/3/29.
 */

public abstract class ComListPresenter<T extends ComEntityVo> implements HandyRecyclerView.LoadingListener {
    private Activity activity;
    private HandyRecyclerView recyclerView;
    private ComListAdapter<T> adapter;

    public abstract void call(Object startPageParam, int count, HandyCallback<T> defaultCallback);

    protected abstract int getPageCount();

    public ComListPresenter(Activity activity, HandyRecyclerView recyclerView, ComListAdapter<T> comListAdapter) {
        this.activity = activity;
        this.recyclerView = recyclerView;

        /** 配置recycler view **/
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        this.recyclerView.setRefreshProgressStyle(ProgressStyle.SysProgress);
        this.recyclerView.setLoadingListener(this);

        this.adapter = comListAdapter;
        this.recyclerView.setAdapter(adapter);
    }

    /**
     * 开始加载数据
     */
    public void load() {
        this.recyclerView.refresh();
    }

    public Activity getActivity() {
        return activity;
    }

    public ComListAdapter getAdapter() {
        return adapter;
    }

    public HandyRecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override public void onRefresh() {
        /** 復位上拉 **/
        recyclerView.setNoMore(false);
        call(null, getPageCount(), new DefaultCallback(getActivity(), true));
    }

    @Override public void onLoadMore() {
        call(getAdapter().getLastItemPageParam(), getPageCount(), new DefaultCallback(getActivity(), false));
    }

    private class DefaultCallback extends UICallback<T> {

        private boolean isRefresh; // 是否是走下拉刷新的回调，否则就是走分页的

        public DefaultCallback(Activity activity, boolean isRefresh) {
            super(activity);
            this.isRefresh = isRefresh;
        }

        @Override public void onUISuccess(T entity, List<T> entities) {
            recyclerView.refreshComplete();
            recyclerView.loadMoreComplete();
            if (isRefresh) {
                adapter.setAll(entities);
            } else {
                adapter.addAll(entities);
                if (entities == null || entities.size() == 0) {
                    /** 當加載到最後一頁時，設置為無法上拉 **/
                    recyclerView.setNoMore(true);
                }
            }
        }

        @Override public void onUIFail(int errorCode, String errorMsg) {
            /** 对错误的公共处理方法 **/
            recyclerView.refreshComplete();
            recyclerView.loadMoreComplete();
            Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
        }
    }

}
