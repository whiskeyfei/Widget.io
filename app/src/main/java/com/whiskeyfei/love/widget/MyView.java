package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by whiskeyfei on 17/1/18.
 * <p>
 * <p>
 * onDraw()
 * <p>
 * measure和layout的过程都结束后，接下来就进入到draw
 * <p>
 * View 会自动绘制的背景效果
 * 但 View 是不会帮我们绘制内容部分的,因此需要每个视图根据想要展示的内容来自行绘制,子类TextView、ImageView等类的源码，你会发现它们都有重写onDraw()这个方法
 * <p>
 * Paint 画笔，Canvas 进行绘制
 */

public class MyView extends View {

    // 1.创建一个画笔
    private Paint  mPaint = new Paint();;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(15f);  //设置画笔宽度为15px
        canvas.drawRect(0, 0, getWidth()-10, getHeight() -10, mPaint);
        drawText(canvas);
        drawPoint(canvas);
        drawLine(canvas);
//        drawRect(canvas);
//        drawRoundRect(canvas);
        drawOval(canvas);
        drawCircle(canvas);
        drawDemo1(canvas);
        testStyle(canvas);
    }


    /**
     * 绘制一个点
     * @param canvas
     */
    private void drawPoint(Canvas canvas){
        mPaint.setColor(Color.RED);
        canvas.drawPoint(150, 150, mPaint);
        canvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
                500,500,
                500,600,
                500,700
        },mPaint);
    }

    /**
     * 绘制文字
     * @param canvas
     */
    private void drawText(Canvas canvas){
        String text = "Hello View";
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        canvas.drawText(text, 0, 100, mPaint);
    }


    /**
     * 绘制线
     * @param canvas
     */
    private void drawLine(Canvas canvas){
        canvas.drawLine(300,300,500,600,mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线

        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
                100,200,200,200,
                100,300,200,300
        },mPaint);
    }

    /**
     * 绘制巨型
     * @param canvas
     *
     * 为什么会有Rect和RectF两种？两者有什么区别吗？

    答案当然是存在区别的，两者最大的区别就是精度不同，Rect是int(整形)的，而RectF是float(单精度浮点型)的。
    除了精度不同，两种提供的方法也稍微存在差别，在这里我们暂时无需关注
     */
    private void drawRect(Canvas canvas){
        //one:
        canvas.drawRect(100,100,350,400,mPaint);
        //two:
        Rect rect = new Rect(100,100,350,400);
        canvas.drawRect(rect,mPaint);
        //three:
        RectF rectF = new RectF(100,100,350,400);
        canvas.drawRect(rectF,mPaint);
    }

    /**
     * 绘制圆角矩形：
     * @param canvas
     */
    private void drawRoundRect(Canvas canvas){
        // 第一种
        RectF rectF = new RectF(100,100,444,400);
        canvas.drawRoundRect(rectF,30,30,mPaint);

        // 第二种
//        canvas.drawRoundRect(100,100,444,400,30,30,mPaint);
    }

    /**
     * 绘制椭圆：
     * @param canvas
     */
    private void drawOval(Canvas canvas){
        // 第一种
        RectF rectF = new RectF(100,100,500,400);
        canvas.drawOval(rectF,mPaint);

        // 第二种
//        canvas.drawOval(100,100,800,400,mPaint);
    }

    /**
     * 绘制圆
     * @param canvas
     */
    private void drawCircle(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(500,500,100,mPaint);  // 绘制一个圆心坐标在(500,500)，半径为100 的圆。
    }

    /**
     * 矩形和扇形
     * @param canvas
     */
    private void drawDemo1(Canvas canvas){
        RectF rectF = new RectF(10,400,230,620);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(rectF,mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectF,0,90,true,mPaint);
    }

    private void testStyle(Canvas canvas){
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20f);     //为了实验效果明显，特地设置描边宽度非常大
        //1
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(800,150,60,mPaint);

        // 填充
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        canvas.drawCircle(800,400,60,mPaint);

        // 描边加填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(800,600, 60, mPaint);
    }

}
