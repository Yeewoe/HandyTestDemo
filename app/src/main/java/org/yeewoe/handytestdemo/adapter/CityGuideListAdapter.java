package org.yeewoe.handytestdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.model.vo.CityGuideLineResultVo;

/**
 * city guide 列表adapter
 *
 * Created by ivo on 2017/3/29.
 */

public class CityGuideListAdapter extends ComListAdapter<CityGuideLineResultVo.CityGuideLineEntityVo> {
    private static final int TYPE_PICTURE_AND_CONTENT = 101;
    private static final int TYPE_ONLY_PICTURE = 102;

    public CityGuideListAdapter(Context context) {
        super(context);
    }

    @Override public int getItemViewType(int position) {
        if (TextUtils.isEmpty(getInnerData().get(position).title) && TextUtils.isEmpty(getInnerData().get(position).content)) {
            return TYPE_ONLY_PICTURE;
        } else {
            return TYPE_PICTURE_AND_CONTENT;
        }
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_PICTURE_AND_CONTENT) {
            return new CityGuidePictureAndContentViewHolder(getLayoutInflater().inflate(R.layout.item_city_guide_picture_and_content_list, null));
        } else if (viewType == TYPE_ONLY_PICTURE){
            return new CityGuideOnlyPictureViewHolder(getLayoutInflater().inflate(R.layout.item_city_guide_only_picture_list, null));
        }
        return null;
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder != null) {
            CityGuideLineResultVo.CityGuideLineEntityVo entityVo = getInnerData().get(position);
            if (holder instanceof CityGuidePictureAndContentViewHolder) {
                CityGuidePictureAndContentViewHolder cityGuidePictureAndContentViewHolder = (CityGuidePictureAndContentViewHolder) holder;
            } else if (holder instanceof CityGuideOnlyPictureViewHolder) {
                CityGuideOnlyPictureViewHolder cityGuideOnlyPictureViewHolder = (CityGuideOnlyPictureViewHolder) holder;
            }
        }
    }

    private class CityGuidePictureAndContentViewHolder extends RecyclerView.ViewHolder {

        public CityGuidePictureAndContentViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class CityGuideOnlyPictureViewHolder extends RecyclerView.ViewHolder {

        public CityGuideOnlyPictureViewHolder(View itemView) {
            super(itemView);
        }
    }
}
