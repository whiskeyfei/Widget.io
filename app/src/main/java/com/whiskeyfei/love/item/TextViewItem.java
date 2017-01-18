package com.whiskeyfei.love.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.utils.ResourceUtil;

/**
 * Created by whiskeyfei on 16/11/9.
 */

public class TextViewItem extends Item {

    private TextView mView;

    public TextViewItem(int itemType) {
        super(itemType);
    }

    @Override
    public Object buildUI(Context context) {
        if (context == null) {
            return mView;
        }

        mView = new TextView(context);
        mView.setOnClickListener(mOnclickListener);
        updateUI();
        return mView;
    }

    private final View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    public Object updateUI() {
        if (mView != null){
            mView.setText("text");
            mView.setTextSize(20);
            mView.setTextColor(ResourceUtil.getResource().getColor(R.color.white));
            mView.setBackgroundColor(ResourceUtil.getResource().getColor(R.color.bgcolor));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(getWidth(),getHeight());
            lp.leftMargin = getPaddingLeftRight();
            lp.rightMargin = getPaddingLeftRight();
            lp.topMargin = getPaddingTop();
            lp.bottomMargin = getPaddingTop();

            mView.setLayoutParams(lp);
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
