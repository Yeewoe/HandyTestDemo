package org.yeewoe.handytestdemo.presenter;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.adapter.ComListAdapter;
import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.callback.UICallback;
import org.yeewoe.handytestdemo.model.vo.ComEntityVo;
import org.yeewoe.handytestdemo.view.widget.HandyLoadMoreView;

import java.util.List;

/**
 * 列表公共presenter
 * Created by ivo on 2017/3/29.
 */

public abstract class ComListPresenter<T extends ComEntityVo> implements PullToRefreshRecyclerView.PagingableListener, SwipeRefreshLayout.OnRefreshListener {
    private Activity activity;
    private final PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private RecyclerView recyclerView;
    private ComListAdapter<T> adapter;

    public abstract void call(Object startPageParam, int count, HandyCallback<T> defaultCallback);

    protected abstract int getPageCount();

    public ComListPresenter(Activity activity, PullToRefreshRecyclerView pullToRefreshRecyclerView, ComListAdapter<T> comListAdapter) {
        this.activity = activity;
        this.pullToRefreshRecyclerView = pullToRefreshRecyclerView;
        this.recyclerView = pullToRefreshRecyclerView.getRecyclerView();

        /** 配置recycler view **/
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));

        /** 配置刷新控件 **/
        HandyLoadMoreView loadMoreView = new HandyLoadMoreView(activity, this.recyclerView);
        loadMoreView.setLoadmoreString(activity.getString(R.string.loadmore));
        loadMoreView.setLoadMorePadding(100);
        this.pullToRefreshRecyclerView.setLoadMoreFooter(loadMoreView);
        this.pullToRefreshRecyclerView.removeHeader();
        this.pullToRefreshRecyclerView.setSwipeEnable(true);
        this.pullToRefreshRecyclerView.setPagingableListener(this);
        this.pullToRefreshRecyclerView.setOnRefreshListener(this);

        this.pullToRefreshRecyclerView.onFinishLoading(true, false);

        this.adapter = comListAdapter;
        this.recyclerView.setAdapter(adapter);
    }

    /**
     * 开始加载数据
     */
    public void load() {
        pullToRefreshRecyclerView.setRefreshing(true);
        onRefresh();
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

    public PullToRefreshRecyclerView getRefreshLayout() {
        return pullToRefreshRecyclerView;
    }

    @Override public void onRefresh() {
        call(null, getPageCount(), new DefaultCallback(getActivity(), true));
    }

    @Override public void onLoadMoreItems() {
        call(getAdapter().getLastItemPageParam(), getPageCount(), new DefaultCallback(getActivity(), false));
    }

    private class DefaultCallback extends UICallback<T> {

        private boolean isRefresh; // 是否是走下拉刷新的回调，否则就是走分页的

        public DefaultCallback(Activity activity, boolean isRefresh) {
            super(activity);
            this.isRefresh = isRefresh;
        }

        @Override public void onUISuccess(T entity, List<T> entities) {
            getRefreshLayout().setOnRefreshComplete();
            if (isRefresh) {
                adapter.setAll(entities);
            } else {
                adapter.addAll(entities);
                if (entities == null || entities.size() == 0) {
                    getRefreshLayout().onFinishLoading(false, false);
                }
            }
        }

        @Override public void onUIFail(int errorCode, String errorMsg) {
            /** 对错误的公共处理方法 **/
            getRefreshLayout().setOnRefreshComplete();
            Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
        }
    }

}
