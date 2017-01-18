package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by whiskeyfei on 17/1/18.
 *
 *
 * onDraw()
 *
 * measure和layout的过程都结束后，接下来就进入到draw
 *
 * View 会自动绘制的背景效果
 * 但 View 是不会帮我们绘制内容部分的,因此需要每个视图根据想要展示的内容来自行绘制,子类TextView、ImageView等类的源码，你会发现它们都有重写onDraw()这个方法
 *
 * Paint 画笔，Canvas 进行绘制

 */

public class MyView extends View{
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        String text = "Hello View";
        canvas.drawText(text, 0, getHeight() / 2, mPaint);
    }
}
