package com.whiskeyfei.love.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.whiskeyfei.love.adapter.BottomTabAdapter;


/**
 * Created by whiskeyfei on 16/4/11.
 */
public class TabJustLayout extends LinearLayout implements TabItemView.OnTabClickListener{
    private static final String TAG = "TabJustLayout";

    private BottomTabAdapter mBottomTabAdapter;

    private SparseArray<View> mTabViews;

    private TabItemView.OnTabLayoutClickListener mTabLayoutClickListener;
    private Context mContext;

    public TabJustLayout(Context context) {
        this(context,null);
    }

    public TabJustLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabJustLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context) {
        mContext = context;
        if (mBottomTabAdapter == null){
            throw new IllegalArgumentException("mBottomTabAdapter is null");
        }

        if (mTabViews == null){
            mTabViews = new SparseArray<>();
        }

        mTabViews.clear();
        removeAllViews();
        int len = mBottomTabAdapter.getCount();
        if (len <= 0 ) return;
        for (int i = 0; i < len; i++) {
            TabItemView itemView = (TabItemView) mBottomTabAdapter.getView(i);
            mTabViews.put(i, itemView);
            itemView.setOnTabClickListener(this);
            LayoutParams lp = (LayoutParams) itemView.getLayoutParams();
            if (lp == null) {
                lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            }
            lp.gravity = Gravity.CENTER;
            lp.weight = 1;
            addView(itemView, lp);
        }
    }

    public void setAdapter(BottomTabAdapter adapter) {
        this.mBottomTabAdapter = adapter;
        init(getContext());
    }

    public void setOnTabLayoutClickListener(TabItemView.OnTabLayoutClickListener listener){
        mTabLayoutClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        int count = getChildCount();
        if (mTabViews == null || mBottomTabAdapter == null || !mBottomTabAdapter.hasData() || mBottomTabAdapter.getCount() <= 0){
            return;
        }
        for (int i = 0; i < count; i++) {
            boolean isSelected = (v == getChildAt(i));
                TabItemView item = (TabItemView) mTabViews.get(i);
                if (item != null){
                    item.setTabIcon(mBottomTabAdapter.getIcon(isSelected,i));
                    item.setTextColor(mBottomTabAdapter.getTextColor(isSelected));
                }
            if (isSelected && mTabLayoutClickListener != null){
                mTabLayoutClickListener.onClick(v,i);
            }
        }
    }

}
