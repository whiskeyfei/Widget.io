package com.whiskeyfei.love.adapter;

import android.content.Context;
import android.view.View;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.utils.ResourceUtil;
import com.whiskeyfei.love.widget.TabItemView;

import java.util.List;

/**
 * Created by whiskeyfei on 16/4/13.
 */
public class BottomTabAdapter extends TabAdpater{
    private static final String TAG = "BottomTabAdapter";
    private Context mContext;

    private int mTabIconRes[][] = {
            {R.drawable.icon_chats_normal, R.drawable.icon_chats_selected},
            {R.drawable.icon_contacts_normal, R.drawable.icon_contacts_selected},
            {R.drawable.icon_discover_normal, R.drawable.icon_discover_selected},
            {R.drawable.icon_me_normal, R.drawable.icon_me_selected}
    };

    private List<String> mListNames;

    private int mTabTextSelectColor, mTabTextNormalColor;

    public BottomTabAdapter(Context context){
        mContext = context;
        mTabTextSelectColor = ResourceUtil.getColor(R.color.tab_textcolor_selected);
        mTabTextNormalColor = ResourceUtil.getColor(R.color.tab_textcolor_normal);
    }

//    public TabItemView.OnTabLayoutClickListener mOnTabClickListener;

    public void setData(List<String> list){
        mListNames = list;
        notifyDataSetChanged();
    }

//    public void setOnTabLayoutClickListener(TabItemView.OnTabLayoutClickListener listener ){
//        mOnTabClickListener = listener;
//    }

    public String getItemName(int position){
        return (mListNames != null) ? mListNames.get(position) : "";
    }

    public boolean hasData(){
        return mTabIconRes != null;
    }

    public int getIcon(boolean selected,int position){
        return selected ? mTabIconRes[position][1] : mTabIconRes[position][0];
    }

    @Override
    public View getView(final int position) {
        final TabItemView itemView = new TabItemView(mContext);
        itemView.setText(getItemName(position));
        boolean isZero = (position == 0);
        itemView.setTextColor(getTextColor(isZero));
        itemView.setTabIcon(getIcon(isZero,position));
        return itemView;
    }

    public int getCount(){
        return (mListNames != null) ? mListNames.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mListNames == null ? "" : mListNames.get(position);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public int getTextColor(boolean isSelected) {
        return isSelected ? mTabTextSelectColor : mTabTextNormalColor;
    }
}
