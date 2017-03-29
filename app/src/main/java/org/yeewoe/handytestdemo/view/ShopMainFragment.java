package org.yeewoe.handytestdemo.view;

import android.support.v4.app.Fragment;
import android.view.View;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.presenter.CityGuideListPresenter;
import org.yeewoe.handytestdemo.view.base.HandyBaseFragment;

import butterknife.BindView;

/**
 * Shop 主TAB页面
 *
 * Created by ivo on 2017/3/28.
 */

public class ShopMainFragment extends HandyBaseFragment {


    public ShopMainFragment() {
    }

    public static Fragment newInstance() {
        return new ShopMainFragment();
    }


    @Override protected int getContentViewLayoutId() {
        return R.layout.fragment_shop_main;
    }

    @Override protected void bindViewListener(View contentView) {
        super.bindViewListener(contentView);

    }

    @Override protected void loadSyncData() {
    }

    @Override protected void loadAsyncData() {
    }
}
