package org.yeewoe.handytestdemo.view;

import android.support.v4.app.Fragment;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.presenter.CityGuideListPresenter;
import org.yeewoe.handytestdemo.view.base.HandyBaseFragment;
import org.yeewoe.handytestdemo.view.widget.HandyRecyclerView;

import butterknife.BindView;

/**
 * City Guide 主TAB页面
 * <p>
 * Created by ivo on 2017/3/28.
 */

public class CityGuideMainFragment extends HandyBaseFragment {

    @BindView(R.id.recycler_view) HandyRecyclerView mRecyclerView;
    private CityGuideListPresenter cityGuideListPresenter;

    public CityGuideMainFragment() {
    }

    public static Fragment newInstance() {
        return new CityGuideMainFragment();
    }

    @Override protected int getContentViewLayoutId() {
        return R.layout.fragment_city_guide_main;
    }

    @Override protected void loadSyncData() {
        cityGuideListPresenter = new CityGuideListPresenter(getActivity(), mRecyclerView);
    }

    @Override protected void loadAsyncData() {
        cityGuideListPresenter.load();
    }
}
