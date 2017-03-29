package org.yeewoe.handytestdemo.presenter;

import android.app.Activity;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.yeewoe.handytestdemo.adapter.CityGuideListAdapter;
import org.yeewoe.handytestdemo.callback.HandyCallback;
import org.yeewoe.handytestdemo.model.service.CityGuideService;
import org.yeewoe.handytestdemo.model.vo.CityGuideLineResultVo;

/**
 * city guide列表presenter
 * Created by ivo on 2017/3/29.
 */

public class CityGuideListPresenter extends ComListPresenter<CityGuideLineResultVo.CityGuideLineEntityVo> {
    private static final int PAGE_COUNT = 6;
    private CityGuideService cityGuideService;

    public CityGuideListPresenter(Activity activity, XRecyclerView recyclerView) {
        super(activity, recyclerView, new CityGuideListAdapter(recyclerView.getContext()));
        this.cityGuideService = new CityGuideService();
    }

    @Override public void call(Object startPageParam, int count, HandyCallback<CityGuideLineResultVo.CityGuideLineEntityVo> defaultCallback) {
        long startPageId = 0;
        if (startPageParam != null) {
            startPageId = (long) startPageParam;
        }
        cityGuideService.getLine(startPageId, count, defaultCallback);
    }

    @Override protected int getPageCount() {
        return PAGE_COUNT;
    }
}
