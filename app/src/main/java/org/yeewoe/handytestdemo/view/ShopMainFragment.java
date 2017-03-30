package org.yeewoe.handytestdemo.view;

import android.support.v4.app.Fragment;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.view.base.HandyBaseFragment;

/**
 * Shop 主TAB页面
 * <p>
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


    @Override protected void loadSyncData() {
    }

    @Override protected void loadAsyncData() {
    }
}
