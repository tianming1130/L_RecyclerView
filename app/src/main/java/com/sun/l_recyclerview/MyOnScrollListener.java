package com.sun.l_recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by sun on 2017/12/21.
 */

public abstract class MyOnScrollListener extends RecyclerView.OnScrollListener {
    private RecyclerView.Adapter adapter;

    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItem=-1;
    public MyOnScrollListener(RecyclerView.Adapter adapter, LinearLayoutManager linearLayoutManager){
        this.adapter=adapter;
        this.linearLayoutManager=linearLayoutManager;
    }
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState ==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==adapter.getItemCount()) {
            loadMore();
        }
    }
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView,dx, dy);
        lastVisibleItem =linearLayoutManager.findLastVisibleItemPosition();

    }
    public abstract void loadMore();
}
