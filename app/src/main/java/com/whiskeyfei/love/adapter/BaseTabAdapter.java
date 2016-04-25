package com.whiskeyfei.love.adapter;

import android.content.Context;
import android.view.View;

import com.whiskeyfei.love.widget.TabItemView;

import java.util.List;

/**
 * Created by whiskeyfei on 16/4/13.
 */
public abstract class BaseTabAdapter<T> extends TabAdpater<T> {

    private Context mContext;
    protected List<T> mLists;

    public BaseTabAdapter(Context context) {
        mContext = context;
    }

    public BaseTabAdapter(Context context, List<T> objects) {
        this(context);
        mLists = objects;
    }

    public void setData(List<T> list) {
        mLists = list;
    }

    @Override
    public T getItem(int position) {
        return (mLists != null) ? mLists.get(position) : null;
    }

    @Override
    public View getView(final int position) {
        final TabItemView itemView = new TabItemView(getContext());
        convert(itemView, getItem(position),position);
        return itemView;
    }

    public int getCount() {
        return (mLists != null) ? mLists.size() : 0;
    }

    public Context getContext() {
        return mContext;
    }

    public abstract void convert(TabItemView tabItemView, T item,int position);

    static class MyViewHolder {
        public final View itemView;

        public MyViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("view may not be null");
            }
            itemView = view;
        }
    }
}
