package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.whiskeyfei.love.R;


/**
 * Created by whiskeyfei on 16/4/19.
 */
public class CustomView extends View {

    private static final int COUSTOM_SIZE = 150;
    private static final String TAG = "CustomView";
    private final Rect mTextBound;
    private final Paint mTextPaint;
    private final Paint mBackPaint;
    private Bitmap mIconBitmap;
    private Bitmap mLeftIcon;
    private Rect mIconRect;
    private Rect mLeftIconRect;
    private Rect mRightconRect;
    private String mTitle = "Title";
//    private RectF mBackgroundRect;
    private RectF mBottomRect;


    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(true);
        mIconBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_chats_selected);
        mLeftIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        mTextBound = new Rect();
        mTextPaint = new Paint();
        mBackPaint = new Paint();
        mBackPaint.setColor(Color.RED);
        setBackgroundResource(R.drawable.item_selector);
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e(TAG,"onFocusChange hasFocus:" + hasFocus);
//                mBackPaint.setColor(hasFocus ? Color.YELLOW : Color.RED);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG,"onMeasure");
        //测量icon
//        int viewWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
//        int viewHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
//        int iconWidth = Math.min(viewWidth, viewHeight);
//        int left = getMeasuredWidth() / 2 - iconWidth / 2;
//        int top = getMeasuredHeight() / 2 - iconWidth / 2;
//        mIconRect = new Rect(left, top, left + iconWidth, top + iconWidth);
//        setMeasuredDimension(
//                measureWidth(widthMeasureSpec),
//                measureHeight(heightMeasureSpec));
    }


    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        //精准模式 layout_width layout_height 指定具体的数值或者指定 match_parent 大小为 EXACTLY模式
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = COUSTOM_SIZE;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = COUSTOM_SIZE;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG,"onDraw");
        super.onDraw(canvas);
//        mBackgroundRect = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        mLeftIconRect = new Rect(0,0,50,50);
        mRightconRect = new Rect(getMeasuredWidth() - 50,0,getMeasuredWidth(),50);
        mBottomRect =  new RectF(0, getMeasuredHeight() - 50, getMeasuredWidth(), getMeasuredHeight());
//        canvas.drawRect(mBackgroundRect,mBackPaint);
        canvas.drawRect(mBottomRect,mBackPaint);
//        canvas.drawBitmap(mIconBitmap, null, mIconRect, null);
        canvas.drawBitmap(mLeftIcon, null, mLeftIconRect, null);
        canvas.drawBitmap(mLeftIcon, null, mRightconRect, null);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {
        mTextPaint.setTextSize(30);
        mTextPaint.setColor(0Xff555555);
        mTextPaint.getTextBounds(mTitle, 0, mTitle.length(), mTextBound);
        int x = getMeasuredWidth() / 2 - mTextBound.width() / 2;
        int y = getMeasuredHeight() - mTextBound.height() - 10;
        canvas.drawText(mTitle, x, y, mTextPaint);
    }

    /**
     * onLayout()
     *
     *
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
