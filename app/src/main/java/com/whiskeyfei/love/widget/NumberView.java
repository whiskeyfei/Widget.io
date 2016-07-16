package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by whiskeyfei on 16/6/29.
 */
public class NumberView extends View{
    private int mCount = 0;
    private Paint mTextPaint;
    private Rect mTextRect;
    private String TAG = "NumberView";

    public NumberView(Context context) {
        this(context,null);
    }

    public NumberView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTextRect = new Rect();
        mTextPaint = new Paint();
        setFocusable(true);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                invalidate();
            }
        });
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG,"onLongClick");
                return false;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setTextSize(30);
        String s = String.valueOf(mCount);
        mTextPaint.getTextBounds(s,0,s.length(),mTextRect);
        int x = getMeasuredWidth() / 2 - mTextRect.width() / 2;
        int y = getMeasuredHeight()/2 - mTextRect.height()/2;
        canvas.drawText(s,x,y,mTextPaint);
    }


}
