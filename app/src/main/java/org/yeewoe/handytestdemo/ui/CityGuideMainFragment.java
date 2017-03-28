package org.yeewoe.handytestdemo.ui;

import android.support.v4.app.Fragment;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.ui.base.HandyBaseFragment;

/**
 * City Guide 主TAB页面
 *
 * Created by ivo on 2017/3/28.
 */

public class CityGuideMainFragment extends HandyBaseFragment {
    public CityGuideMainFragment() {
    }

    public static Fragment newInstance() {
        return new CityGuideMainFragment();
    }


    @Override protected int getContentViewLayoutId() {
        return R.layout.fragment_city_guide_main;
    }

    @Override protected void loadSyncData() {

    }

    @Override protected void loadAsyncData() {

    }
}
