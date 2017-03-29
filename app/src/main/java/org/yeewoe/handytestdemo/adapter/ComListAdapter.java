package org.yeewoe.handytestdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import org.yeewoe.handytestdemo.model.vo.ComEntityVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装的公共列表adapter
 * Created by ivo on 2017/3/29.
 */

public abstract class ComListAdapter<T extends ComEntityVo> extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    private List<T> innerData;

    ComListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        innerData = new ArrayList<>();
    }

    @Override public int getItemCount() {
        return innerData != null ? innerData.size() : 0;
    }

    public void setAll(List<T> entities) {
        if (entities == null) {
            entities = new ArrayList<>();
        }
        if (innerData != null) {
            innerData.clear();
        } else {
            innerData = new ArrayList<>();
        }
        innerData.addAll(entities);
        notifyDataSetChanged();
    }

    public void addAll(List<T> entities) {
        if (entities == null) {
            entities = new ArrayList<>();
        }
        if (innerData == null) {
            innerData = new ArrayList<>();
        }
        innerData.addAll(entities);
        notifyDataSetChanged();
    }

    protected LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    @NonNull protected List<T> getInnerData() {
        return innerData;
    }

    /**
     * 上一頁最後一條的分頁條件
     */
    public abstract Object getLastItemPageParam();
}
