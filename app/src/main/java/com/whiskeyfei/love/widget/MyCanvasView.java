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
import android.view.View;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.app.AppApplication;

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

public class MyCanvasView extends View {

    // 1.创建一个画笔
    private Paint  mPaint = new Paint();;

    public MyCanvasView(Context context) {
        super(context);
    }

    public MyCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mPaint.setStrokeWidth(5f);  //设置画笔宽度为15px
//        translate(canvas);//平移
//        scale(canvas);//缩放练习
//        scaleDemo(canvas);//嵌套矩形
//        rotate(canvas);//绘制一个圆盘钟表样式
//        drawPicture(canvas);//绘制图片
        drawText(canvas);//绘制图片
    }

    private void drawPicture(Canvas canvas) {
        Bitmap bt = BitmapFactory.decodeResource(AppApplication.get().getResources(), R.drawable.pic3);
//        canvas.drawBitmap(bt,new Matrix(),new Paint());
        //或者 选定绘制起点
//        canvas.drawBitmap(bt,10,10,new Paint());
        // 将画布坐标系移动到画布中央
        canvas.translate(getWidth()/2,getHeight()/2);

        // 指定图片绘制区域(左上角的四分之一)
        Rect src = new Rect(0,0,bt.getWidth()/2,bt.getHeight()/2);

        // 指定绘制在屏幕上的绘制，图片宽高会根据指定的区域自动进行缩放
        Rect dst = new Rect(0,0,bt.getWidth()/5,bt.getHeight()/5);

        canvas.drawBitmap(bt,src,dst,new Paint());

    }

    /**
     * 绘制一个圆盘钟表样式
     * @param canvas
     */
    private void rotate(Canvas canvas) {

        canvas.translate(getWidth()/2,getHeight()/2);
        //画坐标系
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(1f);
        canvas.drawLine(0,-getHeight()/2,0,getHeight()/2,mPaint);
        canvas.drawLine(-getWidth()/2,0,getWidth()/2,0,mPaint);

        mPaint.setStrokeWidth(2f);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(0,0,200,mPaint);
        canvas.drawCircle(0,0,210,mPaint);

        for (int i =0;i<=360;i++){
            canvas.drawLine(0,200,0,210,mPaint);
            canvas.rotate(5);
        }

    }

    /**
     * translate是坐标系的移动，可以为图形绘制选择一个合适的坐标系。
     * 注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动，如下：
     */
    private void translate(Canvas canvas){
        mPaint.setColor(Color.BLUE);
        canvas.translate(200,200);//将中心点移动到x=200.y=200 位置，半径r=100
        canvas.drawCircle(0,0,100,mPaint);//移动的好处是好计算位置

        mPaint.setColor(Color.GRAY);
        canvas.translate(200,200);//本次移动相对于 之前的（200，200）移动，而不是（0，0）位置移动
        canvas.drawCircle(0,0,100,mPaint);//移动的好处是好计算位置
    }


    /**
     * 绘制一个嵌套矩形
     * @param canvas
     */
    private void scaleDemo(Canvas canvas){
        // 将坐标系原点移动到画布正中心
        mPaint.setStrokeWidth(2f);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.translate(getWidth() / 2, getHeight() / 2);

        RectF rect = new RectF(-200,-200,200,200);   // 矩形区域

        for (int i=0; i<=30; i++)
        {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rect,mPaint);
        }
    }

    private void scale(Canvas canvas){
        canvas.translate(getWidth()/2,getHeight()/2);
        //画坐标系
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(1f);
        canvas.drawLine(0,-getHeight()/2,0,getHeight()/2,mPaint);
        canvas.drawLine(-getWidth()/2,0,getWidth()/2,0,mPaint);

        //矩形
        RectF rectF = new RectF(0,-200,200,0);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(2f);
        canvas.drawRect(rectF,mPaint);

        //缩放矩形
//        canvas.scale(0.5f,0.5f);//默认围绕中心点缩放
//        mPaint.setColor(Color.RED);
//        mPaint.setStrokeWidth(2f);
//        canvas.drawRect(rectF,mPaint);

        //缩放矩形
//        canvas.scale(0.5f,0.5f,100,0);//默认围绕中心点向右平移100 缩放
//        mPaint.setColor(Color.GREEN);
//        mPaint.setStrokeWidth(2f);
//        canvas.drawRect(rectF,mPaint);

        //缩放负值
//        canvas.scale(-0.5f,-0.5f);          // 画布缩放
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rectF,mPaint);

        //缩放负值 + 平移中心点
        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.scale(-0.5f,-0.5f,100,0);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
        canvas.drawRect(rectF,mPaint);
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
        //绘制默认基准线
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3f);
        //x
        canvas.drawLine(0,0,getWidth(),0,mPaint);
        //y
        canvas.drawLine(0,0,0,getHeight(),mPaint);

        mPaint.setStrokeWidth(1f);
        String text = "Hello View";
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        mPaint.setTextAlign(Paint.Align.RIGHT);//左对齐(LEFT),居中对齐(CENTER),右对齐(RIGHT)
        canvas.drawText(text, 100, 100, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawText(text,0,4,100,130,mPaint);
        float size = mPaint.measureText(text);
        canvas.drawText(String.valueOf(size),0,4,100,180,mPaint);
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
