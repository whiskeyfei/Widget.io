package com.whiskeyfei.love.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by whiskeyfei on 16/4/25.
 *  自定义listvew 滑动弹的简单效果
 */
public class MyListView extends ListView {
    private int mMaxOverScrollY;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverScrollY, isTouchEvent);
    }

    public void setMaxOverScrollY(int maxOverScrollY) {
        mMaxOverScrollY = maxOverScrollY;
    }
}
