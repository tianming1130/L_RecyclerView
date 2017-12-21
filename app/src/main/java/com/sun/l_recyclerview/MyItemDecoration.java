package com.sun.l_recyclerview;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * Created by sun on 2017/12/20.
 */

public class MyItemDecoration extends Y_DividerItemDecoration {
    public MyItemDecoration(Context context, int lineWidthDp, int colorRGB) {
        super(context, lineWidthDp, colorRGB);
    }

    @Override
    public boolean[] getItemSidesIsHaveOffsets(int itemPosition) {
        //顺时针顺序:left, top, right, bottom
        boolean[] isOffset = {false, false, false, true};//默认只有bottom显示分割线
        return isOffset;
    }
}
