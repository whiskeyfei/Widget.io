package com.whiskeyfei.love.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whiskeyfei.love.R;

//学习资料demo
public class TopBar extends RelativeLayout {

    private int mBarColor;
    private final Button mLeftButton;

    private final Button mRightButton;
    private final TextView mTitleView;

    private LayoutParams mLeftParams, mTitlepParams, mRightParams;

    // 左按钮的属性值，即我们在atts.xml文件中定义的属性
    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;

    // 右按钮的属性值，即我们在atts.xml文件中定义的属性
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    // 标题的属性值，即我们在atts.xml文件中定义的属性
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;

    // 映射传入的接口对象
    private topbarClickListener mListener;

    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // 通过这个方法，将你在atts.xml中定义的declare-styleable
        // 的所有属性的值存储到TypedArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        // 从TypedArray中取出对应的值来为要设置的属性赋值
        mBarColor = ta.getResourceId(R.styleable.TopBar_topBar_barColor, -1);
        mLeftTextColor = ta.getColor(
                R.styleable.TopBar_topBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(
                R.styleable.TopBar_topBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_topBar_leftText);

        mRightTextColor = ta.getColor(
                R.styleable.TopBar_topBar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(
                R.styleable.TopBar_topBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_topBar_rightText);

        mTitleTextSize = ta.getDimension(
                R.styleable.TopBar_topBar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(
                R.styleable.TopBar_topBar_titleTextColor, 0);
        mTitle = ta.getString(R.styleable.TopBar_topBar_title);

        // 获取完TypedArray的值后，一般要调用
        // recyle方法来避免重新创建的时候的错误
        ta.recycle();

//        setBackgroundResource(mBarColor);
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        // 为创建的组件元素赋值
        // 值就来源于我们在引用的xml文件中给对应属性的赋值
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackgroundDrawable(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackgroundDrawable(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        // 为组件元素设置相应的布局元素
        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        // 添加到ViewGroup
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitlepParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitlepParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitlepParams);

        // 按钮的点击事件，不需要具体的实现，
        // 只需调用接口的方法，回调的时候，会有具体的实现
        mRightButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.rightClick();
            }
        });

        mLeftButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.leftClick();
            }
        });
    }

    // 暴露一个方法给调用者来注册接口回调
    // 通过接口来获得回调者对接口方法的实现
    public void setOnTopbarClickListener(topbarClickListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 设置按钮的显示与否 通过id区分按钮，flag区分是否显示
     *
     * @param id   id
     * @param flag 是否显示
     */
    public void setButtonVisable(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftButton.setVisibility(View.VISIBLE);
            } else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftButton.setVisibility(View.GONE);
            } else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }

    public interface topbarClickListener {
        void leftClick();
        void rightClick();
    }
}
