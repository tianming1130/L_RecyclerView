package com.sun.l_recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by sun on 2017/12/21.
 */

public abstract class MenuOnScrollListener extends RecyclerView.OnScrollListener {

    private int lastVisibleItem=-1;
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState ==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==recyclerView.getAdapter().getItemCount()) {
            loadMore();
        }
    }
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView,dx, dy);
        if (dy>0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
        }
    }
    public abstract void loadMore();
}
