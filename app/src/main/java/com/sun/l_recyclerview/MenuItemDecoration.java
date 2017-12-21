package com.sun.l_recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sun on 2017/11/19.
 */

public class MenuItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    public MenuItemDecoration(Context context) {
        this.mContext=context;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c,parent,state);

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        for (int i = 0; i < childCount; i++){
            final View child = parent.getChildAt(i);

            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + px2dip(mContext,2);

            c.drawRect(left,top,right,bottom,paint);
            //Log.d("wnw", left + " " + top + " "+right+"   "+bottom+" "+i);
        }

    }
    //由于Divider也有长宽高，每一个Item需要向下或者向右偏移
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //画横线，就是往下偏移一个分割线的高度
            outRect.set(0, 0, 0,px2dip(mContext,2));
    }
    public int px2dip(Context mContext, float px) {

        float scale = mContext.getResources().getDisplayMetrics().density;

        return (int) (px / scale + 0.5f);

    }
}
