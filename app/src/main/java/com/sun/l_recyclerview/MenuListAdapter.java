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
    private Context context;
    private List<Map<String,Object>> mDataList;
    private LayoutInflater mLayoutInflater;
    public MenuListAdapter(Context context,List<Map<String,Object>> dataList){
        this.context=context;
        this.mDataList=dataList;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.card_view,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder) holder;
        viewHolder.menu_thumb.setImageResource((int)mDataList.get(position).get("menu_thumb"));
        viewHolder.menu_title.setText((String)mDataList.get(position).get("menu_title"));
        viewHolder.menu_info.setText((String)mDataList.get(position).get("menu_info"));
    }
    @Override
    public int getItemCount() {
        return mDataList.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        ImageView menu_thumb;
        TextView menu_title;
        TextView menu_info;
        public ViewHolder(View itemView) {
            super(itemView);
            menu_thumb=itemView.findViewById(R.id.menu_thumb);
            menu_title=itemView.findViewById(R.id.menu_title);
            menu_info=itemView.findViewById(R.id.menu_info);
        }
    }
}
