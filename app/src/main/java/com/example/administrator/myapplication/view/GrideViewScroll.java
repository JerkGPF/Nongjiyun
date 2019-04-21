package com.example.administrator.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2018/4/27.
 */

public class GrideViewScroll extends GridView {

    public GrideViewScroll(Context context) {
        super(context);
    }

    public GrideViewScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GrideViewScroll(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

//    public GrideViewScroll(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


}
