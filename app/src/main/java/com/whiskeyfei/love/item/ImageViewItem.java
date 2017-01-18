package com.whiskeyfei.love.item;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.whiskeyfei.love.R;

/**
 * Created by whiskeyfei on 16/11/9.
 */

public class ImageViewItem extends Item {

    private ImageView mView;

    public ImageViewItem(int itemType) {
        super(itemType);
    }

    @Override
    public Object buildUI(Context context) {
        if (context == null) {
            return mView;
        }

        mView = new ImageView(context);
        updateUI();
        return mView;
    }

    @Override
    public Object updateUI() {
        if (mView != null){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(getWidth(),getHeight());
            lp.leftMargin = getPaddingLeftRight();
            lp.rightMargin = getPaddingLeftRight();
            lp.topMargin = getPaddingTop();
            lp.bottomMargin = getPaddingTop();
            mView.setLayoutParams(lp);
            Glide.with(mView.getContext())
                    .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                    .placeholder(R.mipmap.ic_launcher)//占位符
                    .error(R.mipmap.ic_launcher)//错误占位符
                    .crossFade()//动画默认的持续时间是 300毫秒 .crossFade(int duration) 自定义
                    .dontAnimate()//没有任何淡入淡出效果
                    .override(200, 150)//重新改变图片大小
                    .into(mView);
        }
        return mView;
    }

    @Override
    public int getWidth() {
        return 200;
    }

    @Override
    public int getHeight() {
        return 150;
    }


}
