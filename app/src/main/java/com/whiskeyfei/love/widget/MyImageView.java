package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.whiskeyfei.love.R;

/**
 * Created by whiskeyfei on 16/5/15.
 */
public class MyImageView extends View{
    private static final String TAG = "MyImageView" ;
    private Drawable mDrawable = null;
    private Paint mPaint1;

    public MyImageView(Context context) {
        super(context);
        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(
                android.R.color.white));
        mPaint1.setStyle(Paint.Style.FILL);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                invalidate();
            }
        });
        mDrawable = getResources().getDrawable(R.drawable.bg_tab_bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        if (mDrawable != null){
            Log.e(TAG,"mDrawable != null");
            mDrawable.setBounds(0, 0, width, height-50);
            mDrawable.draw(canvas);
        }
        mPaint1.setTextSize(50);
        mPaint1.setTextAlign(Paint.Align.LEFT);
        String str = "123142";
        canvas.drawText(str,(getWidth()-mPaint1.measureText(str))/2,getHeight(),mPaint1);
        Log.e(TAG,"onDraw");
    }

    private int lastX;
    private int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN: {

                    break;
                }

                case MotionEvent.ACTION_MOVE: {
                    CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                    int left = layoutParams.leftMargin + x - lastX;
                    int top = layoutParams.topMargin + y - lastY;


                    layoutParams.leftMargin = left;
                    layoutParams.topMargin = top;
                    setLayoutParams(layoutParams);
                    requestLayout();
                    break;
                }

                case MotionEvent.ACTION_UP: {

                    break;
                }

            }
            lastX = x;
            lastY = y;
            return true;
    }
}
