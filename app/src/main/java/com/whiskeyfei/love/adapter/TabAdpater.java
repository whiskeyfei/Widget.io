package com.whiskeyfei.love.adapter;

import android.view.View;

/**
 * Created by whiskeyfei on 16/4/13.
 */
public abstract class TabAdpater {
    public abstract View getView(int position);

    public abstract int getCount();

    public abstract Object getItem(int position);

    public void notifyDataSetChanged(){
        for (int i = 0 ;i<getCount();i++) {
            getView(i);
        }
    };
}
