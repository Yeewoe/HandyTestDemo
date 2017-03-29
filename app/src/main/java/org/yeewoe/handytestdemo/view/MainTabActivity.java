package org.yeewoe.handytestdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.config.MainTabConfig;
import org.yeewoe.handytestdemo.view.base.HandyBaseActivity;

import butterknife.BindView;

public class MainTabActivity extends HandyBaseActivity {

    @BindView(R.id.tabs) TabLayout mTabLayout;
    @BindView(R.id.viewpager) ViewPager mViewPager;

    @Override protected int getContentViewLayoutId() {
        return R.layout.activity_main_tab;
    }

    @Override protected void initIntent(Intent intent) {

    }

    @Override protected void bindIntent() {

    }

    @Override protected void loadSyncData() {
        mTabLayout.setupWithViewPager(mViewPager);
        MainTabViewPagerAdapter mAdapter = new MainTabViewPagerAdapter(getSupportFragmentManager());
//        mViewPager.setOffscreenPageLimit(mAdapter.getCount());
        mViewPager.setAdapter(mAdapter);
    }

    @Override protected void loadAsyncData() {

    }

    @Override protected void saveInstanceState(Bundle outState) {

    }

    @Override protected void restoreInstanceState(Bundle savedInstanceState) {

    }

    private class MainTabViewPagerAdapter extends FragmentPagerAdapter {

        private MainTabViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override public Fragment getItem(int position) {
            return MainTabConfig.getTabItem(position);
        }

        @Override public int getCount() {
            return MainTabConfig.getTabCount();
        }

        @Override public CharSequence getPageTitle(int position) {
            return MainTabConfig.getTabName(MainTabActivity.this, position);
        }
    }
}
