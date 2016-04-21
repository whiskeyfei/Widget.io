package com.whiskeyfei.love.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whiskeyfei.love.R;


/**
 * Created by whiskeyfei on 16/4/12.
 */
public class TabItemView extends LinearLayout {
    private ImageView mImageView;
    private TextView mTitle;
    private Context mContext;

    public TabItemView(Context context) {
        this(context, null);
    }

    public TabItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        setOrientation(LinearLayout.VERTICAL);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.tab_item, this,true);
        mImageView = (ImageView) view.findViewById(R.id.tab_icon);
        mTitle = (TextView) view.findViewById(R.id.tab_text);
    }

    public void setText(String text) {
        mTitle.setText(text);
    }

    public void setTabIcon(int tabIcon) {
        mImageView.setImageResource(tabIcon);
    }

    public void setTextColor(int textColor) {
        mTitle.setTextColor(textColor);
    }

    public void setOnTabClickListener(final OnTabClickListener listener){
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener !=null)
                listener.onClick(v);
            }
        });
    }

    public interface OnTabClickListener{
        void onClick(View v);
    }

    public interface OnTabLayoutClickListener{
        void onClick(View v, int position);
    }
}
