package com.whiskeyfei.love.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by whiskeyfei on 17/1/18.
 *
 * 问题：了解 onMeasure 和 onLayout 使用
 *
 * onMeasure：
 *
 *  View 中的 measure() 方法是final的，此我们无法在子类中去重写这个方法，说明Android是不允许我们改变View的measure框架的
 *
 * 之后会调用onMeasure()方法，这里才是真正去测量并设置View大小的地方，默认会调用getDefaultSize()方法来获取视图的大小
 *
 * ViewGroup :ViewGroup中定义了一个measureChildren()方法来去测量子视图的大小
 *
 * 这里首先会去遍历当前布局下的所有子视图，然后逐个调用measureChild()方法来测量相应子视图的大小
 *
 * onMeasure()方法是可以重写的，也就是说，如果你不想使用系统默认的测量方式，可以按照自己的意愿进行定制
 *
 * 需要注意的是，在setMeasuredDimension()方法调用之后，我们才能使用getMeasuredWidth()和getMeasuredHeight()来获取视图测量出的宽高，以此之前调用这两个方法得到的值都会是0。
 *
 * onLayout：
 *
 * View：在layout()方法中，首先会调用setFrame()方法来判断视图的大小是否发生过变化，以确定有没有必要对当前的视图进行重绘，
 * 同时还会在这里把传递过来的四个参数分别赋值给mLeft、mTop、mRight和mBottom这几个变量，
 *
 * View中的onLayout()方法就是一个空方法，因为onLayout()过程是为了确定视图在布局中所在的位置，而这个操作应该是由布局来完成的，即父视图决定子视图的显示位置
 *
 * ViewGroup中 onLayout()方法竟然是一个抽象方法，这就意味着所有ViewGroup的子类都必须重写这个方法
 *
 * onDraw()：
 *
 * View：onDraw()方法空方法。其实也可以理解，因为每个视图的内容部分肯定都是各不相同的，这部分的功能交给子类来去实现也是理所当然的。
 *
 */

public class SimpleLayout extends ViewGroup {
    private static final String TAG = "SimpleLayout";

    public SimpleLayout(Context context) {
        super(context);
    }

    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG,"l:"+ l);
        Log.d(TAG,"t:"+ t);
        Log.d(TAG,"r:"+ r);
        Log.d(TAG,"b:"+ b);
        Log.d(TAG,"getChildCount:"+ getChildCount());

        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            Log.d(TAG,"childView.getMeasuredWidth()"+ childView.getMeasuredWidth());
            Log.d(TAG,"childView.getMeasuredHeight()"+ childView.getMeasuredHeight());
            childView.layout(0, 0, childView.getMeasuredWidth(), childView.getMeasuredHeight());
        }
    }
}
