package com.whiskeyfei.love.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.model.ItemInfo;
import com.whiskeyfei.love.utils.ResourceUtil;
import com.whiskeyfei.love.widget.TabItemView;

import java.util.List;

/**
 * Created by whiskeyfei on 16/4/13.
 */
public class BottomTabAdapter extends BaseTabAdapter<ItemInfo>{

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int tagType);
    }

    public void setOnItemClickListener(OnItemClickListener selectViewClickListener) {
        mOnItemClickListener = selectViewClickListener;
    }

    private static final String TAG = "BottomTabAdapter";

    private int mTabTextSelectColor, mTabTextNormalColor;

    public BottomTabAdapter(Context context, List<ItemInfo> objects){
        super(context,objects);
        mTabTextSelectColor = ResourceUtil.getColor(R.color.tab_textcolor_selected);
        mTabTextNormalColor = ResourceUtil.getColor(R.color.tab_textcolor_normal);
    }

    public int getIcon(boolean selected,int position){
        ItemInfo info  = mLists.get(position);
        if (info == null){
            return 0;
        }
        return selected ? info.icons[1] : info.icons[0];
    }

    @Override
    public View getView(final int position) {
        final TabItemView itemView = new TabItemView(getContext());
        final ItemInfo info = mLists.get(position);
        if (info != null){
            itemView.setText(info.name);
            itemView.setTag(info.type);
        }else{
            Log.e(TAG,"getView() -> info is null");
        }

        boolean isZero = (position == 0);
        itemView.setTextColor(getTextColor(isZero));
        itemView.setTabIcon(getIcon(isZero,position));
        return itemView;
    }

    public int getTextColor(boolean isSelected) {
        return isSelected ? mTabTextSelectColor : mTabTextNormalColor;
    }

    @Override
    public void convert(TabItemView tabItemView, ItemInfo item,int position) {
        tabItemView.setText(item.name);
        boolean isZero = (position == 0);
        tabItemView.setTextColor(getTextColor(isZero));
        tabItemView.setTabIcon(getIcon(isZero,position));
    }

    @Override
    public void onClick(View view, int type) {
        if (mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(view,type);
        }
    }
}
