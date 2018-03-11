package com.sun.l_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by sun on 2017/11/18.
 */

public class MenuListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Map<String,Object>> mDataList;
    private LayoutInflater mLayoutInflater;
    //两个final int类型表示ViewType的两种类型
    private final int ITEM_TYPE = 0;
    private final int FOOT_TYPE = 1;

    public MenuListAdapter(Context context,List<Map<String,Object>> dataList){
        this.mDataList=dataList;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_view, parent, false);
        View footView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.foot_view, parent, false);
        if (viewType == FOOT_TYPE)
            return new ViewHolder(footView, FOOT_TYPE);
        return new ViewHolder(itemView, ITEM_TYPE);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder) holder;

        if (getItemViewType(position) == FOOT_TYPE) {
            viewHolder.tvFootView.setText("加载中...");
        } else {
            viewHolder.menu_thumb.setImageResource((int)mDataList.get(position).get("menu_thumb"));
            viewHolder.menu_title.setText((String)mDataList.get(position).get("menu_title"));
            viewHolder.menu_info.setText((String)mDataList.get(position).get("menu_info"));
        }
    }
    @Override
    public int getItemCount() {
        return mDataList.size()+1;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == mDataList.size()) {
            return FOOT_TYPE;
        }
        return ITEM_TYPE;
    }
    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView menu_thumb;
        TextView menu_title;
        TextView menu_info;
        TextView tvFootView;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == ITEM_TYPE) {
                menu_thumb = (ImageView) itemView.findViewById(R.id.menu_thumb);
                menu_title = (TextView) itemView.findViewById(R.id.menu_title);
                menu_info = (TextView) itemView.findViewById(R.id.menu_info);
            } else if (viewType == FOOT_TYPE) {
                tvFootView = (TextView) itemView.findViewById(R.id.tv_foot_view);
            }
        }
    }
}
