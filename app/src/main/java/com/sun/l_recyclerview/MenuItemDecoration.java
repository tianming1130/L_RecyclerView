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
    private float mDividerHeight;
    private Paint mPaint;
    private Context mContext;
    public MenuItemDecoration(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mContext=context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //第一个ItemView不需要在上面绘制分割线
        if (parent.getChildAdapterPosition(view) != 0){
            //这里直接硬编码为1px
            outRect.top = 50;
            //outRect.set(0,1,0,0);
            mDividerHeight = 50;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            //第一个ItemView不需要绘制
            if (index == 0) {
                continue;
            }
            float dividerTop = view.getTop() - mDividerHeight;
            float dividerLeft = parent.getPaddingLeft();
            float dividerBottom = view.getTop();
            float dividerRight = parent.getWidth() - parent.getPaddingRight();
            if (i%2==0){
                mPaint.setColor(Color.BLUE);
            }else {
                mPaint.setColor(Color.RED);
            }
            c.drawRect(dividerLeft,dividerTop,dividerRight,dividerBottom,mPaint);
//            Paint mTextPaint=new Paint();
//            mTextPaint.setColor(Color.RED);
//            mTextPaint.setTextSize(32);
//            c.drawText(String.valueOf(i),dividerLeft,dividerTop,mTextPaint);
        }
    }
}
