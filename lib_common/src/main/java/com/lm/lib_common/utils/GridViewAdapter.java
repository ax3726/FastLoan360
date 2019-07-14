package com.lm.lib_common.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lm.lib_common.R;

import java.util.List;

/**
 * gridView的adapter
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private int selectorPosition=-1;
    public GridViewAdapter(Context context, List<String> mList) {
        this.mContext = context;
        this.mList = mList;

    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mList != null ? mList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return mList != null ? position : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_gridview, null);
            mViewHolder = new ViewHolder();
            mViewHolder.mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.ll);
            mViewHolder.mtextView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mtextView.setText(mList.get(position));
        //如果当前的position等于传过来点击的position,就去改变他的状态
        if (selectorPosition == position) {
            mViewHolder.mRelativeLayout.setBackgroundResource(R.drawable.grid_shap_two);
            mViewHolder.mtextView.setTextColor(Color.parseColor("#9070F9"));
        } else {
            //其他的恢复原来的状态
            mViewHolder.mRelativeLayout.setBackgroundResource(R.drawable.grid_shap_one);
            mViewHolder.mtextView.setTextColor(Color.parseColor("#323232"));
        }
        return convertView;
    }


    public void changeState(int pos) {
        selectorPosition = pos;
        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView mtextView;
        RelativeLayout mRelativeLayout;
    }
}
