package org.yeewoe.handytestdemo.view;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dinuscxj.refresh.RecyclerRefreshLayout;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.presenter.CityGuideListPresenter;
import org.yeewoe.handytestdemo.view.base.HandyBaseFragment;

import butterknife.BindView;

/**
 * City Guide 主TAB页面
 *
 * Created by ivo on 2017/3/28.
 */

public class CityGuideMainFragment extends HandyBaseFragment {

    @BindView(R.id.refresh_layout) RecyclerRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    private CityGuideListPresenter cityGuideListPresenter;


    public CityGuideMainFragment() {
    }

    public static Fragment newInstance() {
        return new CityGuideMainFragment();
    }


    @Override protected int getContentViewLayoutId() {
        return R.layout.fragment_city_guide_main;
    }

    @Override protected void bindViewListener(View contentView) {
        super.bindViewListener(contentView);

    }

    @Override protected void loadSyncData() {
        cityGuideListPresenter = new CityGuideListPresenter(getActivity(), mRefreshLayout, mRecyclerView);
    }

    @Override protected void loadAsyncData() {
        cityGuideListPresenter.load();
    }
}
