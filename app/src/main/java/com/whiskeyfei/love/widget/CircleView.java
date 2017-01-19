package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.whiskeyfei.love.model.PieData;

import java.util.List;

/**
 * Created by whiskeyfei on 17/1/19.
 */

public class CircleView extends View{

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private List<PieData> mData;
    // 宽高
    private int mWidth, mHeight;
    // 画笔
    private Paint mPaint = new Paint();

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);//填充
        mPaint.setAntiAlias(true);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(List<PieData> data){
        mData = data;
        initData();
        invalidate();
    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData) return;
        float currentStartAngle = mStartAngle;
        mWidth = getWidth();
        mHeight = getHeight();
        canvas.translate(mWidth/2,mHeight/2); // 将画布坐标原点移动到中心位置
        float r = 300;//半径
        RectF rect = new RectF(-r, -r, r, r);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect,mPaint);

        int size = mData.size();
        for (int i = 0; i < size; i++){
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect,currentStartAngle,pie.getAngle(),true,mPaint);
            currentStartAngle += pie.getAngle();
        }

    }

    private void initData() {
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            sumValue += pie.getValue();       //计算数值和

            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for(int i = 0; i < mData.size(); i++){
            PieData pie = mData.get(i);
            float percentage = pie.getValue() / sumValue;//百分比  1/(1+2+3+4)
            float angle = percentage * 360;  //角度
            pie.setAngle(angle);
            pie.setPercentage(percentage);
            sumAngle += angle;
            Log.i("angle", "" + pie.getAngle());
        }
    }
}
