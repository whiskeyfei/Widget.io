package com.whiskeyfei.love.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.model.PieData;
import com.whiskeyfei.love.widget.CircleView;

import java.util.ArrayList;
import java.util.List;


/**
 * 问题：
 * layout_width和layout_height什么情况下其作用？
 * <p>
 * <p>
 * 在 Activity 中调用 setContentView()方法时，Android 会自动在布局文件的最外层再嵌套一个 FrameLayout，也就是我们平常在H工具中看到的 id＝"content"的 view。
 * 因为FrameLayout 相当于是父控件，所以layout_width和layout_height属性才会有效果
 *
 * 我们来验证下 mLinearLayout 中的父控件是FrameLayout。这样layout_width和layout_height设置才会起作用，也就是说子控件在父控件中占的位置大小，如果
 * 连父控件都没有了，那子view设置宽高还有什么意义。
 * <p>
 * <p>
 * TAG: the parent of mainLayout is android.widget.FrameLayout{41183c88 V.ED.... ......I. 0,0-0,0 #1020002 android:id/content}
 */

public class LayoutInflaterActivity extends Activity {
    private LinearLayout mLinearLayout;
    CircleView mCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        test1();
//        test2();
        test3();
    }

    private void test3(){
        setContentView(R.layout.myview);
        mCircleView = (CircleView) findViewById(R.id.circle_view);
        mCircleView.setData(getData());
        mCircleView.setStartAngle(45);
    }

    private List<PieData> getData(){
        List<PieData> datas = new ArrayList<>();
        PieData p1 = new PieData("",1);
        PieData p2 = new PieData("",2);
        PieData p3 = new PieData("",3);
        PieData p4 = new PieData("",4);
        datas.add(p1);
        datas.add(p2);
        datas.add(p3);
        datas.add(p4);
        return datas;
    }

    /**
     * use simplelayout
     */
    private void test2(){
        setContentView(R.layout.simplelayout);
    }

    /**
     * 操作 LayoutInflater 了解setContentView()方法使用。
     */
    private void test1(){
        setContentView(R.layout.layoutinflater);
        mLinearLayout = (LinearLayout) findViewById(R.id.main_layout);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View buttonLayout = layoutInflater.inflate(R.layout.button_item, null);
        mLinearLayout.addView(buttonLayout);

        ViewParent viewParent = mLinearLayout.getParent();
        Log.d("TAG", "the parent of mainLayout is " + viewParent);
    }
}
