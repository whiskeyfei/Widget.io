package com.whiskeyfei.love.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.utils.ListUtils;

import java.util.List;

public class TabViewPagerAdapter extends PagerAdapter {
    private List<String> mList;
    private Context mContext;
    private int mSize;

    public TabViewPagerAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mSize = ListUtils.getCount(list);
    }

    @Override
    public int getCount() {
        return ListUtils.getCount(mList);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        view = getView(position, view, container);
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    private static class ViewHolder {
        TextView textView;
    }

    public View getView(int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.page_item, container, false);
            holder.textView = (TextView) view.findViewById(R.id.page_item_text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(mList.get(position));
        return view;
    }

}
