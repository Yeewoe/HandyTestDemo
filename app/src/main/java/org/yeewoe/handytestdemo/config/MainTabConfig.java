package org.yeewoe.handytestdemo.config;

import android.content.Context;
import android.support.v4.app.Fragment;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.view.CityGuideMainFragment;
import org.yeewoe.handytestdemo.view.EatMainFragment;
import org.yeewoe.handytestdemo.view.ShopMainFragment;

/**
 * 主页面配置类
 * Created by ivo on 2017/3/28.
 */

public class MainTabConfig {

    private static Class[] tabs = new Class[] {
            CityGuideMainFragment.class,
            ShopMainFragment.class,
            EatMainFragment.class
    };

    private static int[] tabNameStrIds = new int[] {
            R.string.tab_name_city_guide,
            R.string.tab_name_shop,
            R.string.tab_name_eat
    };

    public static CharSequence getTabName(Context context, int position) {
        return context.getString(tabNameStrIds[position]);
    }

    public static Fragment getTabItem(int position) {
        if (tabs[position] == CityGuideMainFragment.class) {
            return CityGuideMainFragment.newInstance();
        } else if (tabs[position] == ShopMainFragment.class) {
            return ShopMainFragment.newInstance();
        } else if (tabs[position] == EatMainFragment.class) {
            return EatMainFragment.newInstance();
        }
        return null;
    }

    public static int getTabCount() {
        return tabs.length;
    }
}
