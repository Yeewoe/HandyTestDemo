package org.yeewoe.handytestdemo.view;

import android.support.v4.app.Fragment;
import android.view.View;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.view.base.HandyBaseFragment;

/**
 * Eat 主TAB页面
 *
 * Created by ivo on 2017/3/28.
 */

public class EatMainFragment extends HandyBaseFragment {


    public EatMainFragment() {
    }

    public static Fragment newInstance() {
        return new EatMainFragment();
    }


    @Override protected int getContentViewLayoutId() {
        return R.layout.fragment_eat_main;
    }

    @Override protected void loadSyncData() {
    }

    @Override protected void loadAsyncData() {
    }
}
