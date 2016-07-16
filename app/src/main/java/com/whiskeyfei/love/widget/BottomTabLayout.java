package com.whiskeyfei.love.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.whiskeyfei.love.adapter.BottomTabAdapter;


/**
 * Created by whiskeyfei on 16/4/11.
 */
public class BottomTabLayout extends LinearLayout implements TabItemView.OnTabClickListener{
    private static final String TAG = "BottomTabLayout";

    private BottomTabAdapter mBottomTabAdapter;

    private SparseArray<View> mTabViews;

    private TabItemView.OnTabLayoutClickListener mTabLayoutClickListener;
    private ViewPager mViewPager;
    private Context mContext;

    public BottomTabLayout(Context context) {
        this(context,null);
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
        if (len <= 0 ){
            return;
        }

        for (int i = 0; i < len; i++) {
            TabItemView itemView = (TabItemView) mBottomTabAdapter.getView(i);
            mTabViews.put(i, itemView);
            itemView.setOnTabClickListener(this);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) itemView.getLayoutParams();
            if (lp == null) {
                lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            }
            lp.gravity = Gravity.CENTER;
            lp.weight = 1;
            addView(itemView, lp);
        }
    }

    public void setAdapter(BottomTabAdapter adapter) {
        this.mBottomTabAdapter = adapter;
    }

    public void setOnTabLayoutClickListener(TabItemView.OnTabLayoutClickListener listener){
        mTabLayoutClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        int count = getChildCount();
        if (mTabViews == null || mBottomTabAdapter == null || mBottomTabAdapter.getCount() <= 0){
            return;
        }
        for (int i = 0; i < count; i++) {
            boolean isSelected = (v == getChildAt(i));
            if (isSelected){
                mViewPager.setCurrentItem(i, false);
            }
            if (isSelected && mTabLayoutClickListener != null){
                mTabLayoutClickListener.onClick(v,i);
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(mOnPageChangeListener);
            init(getContext());
        }
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            Log.e(TAG,"onPageSelected position:"+position);
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                boolean isSelected = (position == i);
                TabItemView item = (TabItemView) mTabViews.get(i);
                if (item != null){
                    item.setTabIcon(mBottomTabAdapter.getIcon(isSelected,i));
                    item.setTextColor(mBottomTabAdapter.getTextColor(isSelected));
                }
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            Log.e(TAG,"onPageScrolled arg0:"+arg0);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}
