package com.whiskeyfei.love.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.whiskeyfei.love.R;

import java.util.List;

/**
 * Created by whiskeyfei on 16/4/22.
 *
 * ListView 最普遍的Adapter书写方式，利用Android的Recycler机制，使用 convertView来重新回收View，提高效率。
 * View的每次创建是比较耗时的，因此对于getview方法传入的convertView应充分利用 != null的判断
 * <p/>
 * 然后利用ViewHolder将需要缓存的view封装好，convertView的setTag才是将这些缓存起来供下次调用。
 * 当你的listview里布局多样化的时候 viewholder的作用体现明显，效率再一次提高。
 * View的findViewById()方法也是比较耗时的，也就是进行了inflate操作，因此需要考虑只调用一次，之后就用View.getTag()方法来获得ViewHolder对象。
 *
 * ViewHolder 使用
 * http://developer.android.com/intl/zh-cn/training/improving-layouts/smooth-scrolling.html#ViewHolder
 */
public class ItemAdapter extends BaseAdapter {

    private List<String> mList;
    private Context mContext;
    private LayoutInflater mLayoutInfalter;

    public ItemAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mLayoutInfalter = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return (mList != null) ? mList.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //判断是否有缓存
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = createView(holder, convertView, position);
            convertView.setTag(holder);//设置tag
        } else {
            holder = (ViewHolder) convertView.getTag();//通过tag来找到缓存的布局
        }
        //设置显示UI数据等
        holder.text.setText("Item:" + position);
        return convertView;
    }

    private View createView(ViewHolder holder, View convertView, int position) {
        convertView = mLayoutInfalter.inflate(R.layout.view_item, null);
        holder.text = (TextView) convertView.findViewById(R.id.text);
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 定义ViewHolder
     *
     * 提高了LiseView的效率，利用视图缓存机制，避免每次去获取view，比较耗时
     */

    public final class ViewHolder {
        TextView text;
    }

}
