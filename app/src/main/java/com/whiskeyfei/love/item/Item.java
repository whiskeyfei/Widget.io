package com.whiskeyfei.love.item;

import android.content.Context;

/**
 * Created by whiskeyfei on 16/11/9.
 */

public class Item extends Widget{
    protected final int mItemType;
    private int mActualWidth;
    private int mActualHeight;

    public Item(int itemType) {
        super();
        this.mItemType = itemType;
    }

    @Override
    public Object buildUI(Context context) {
        return null;
    }

    @Override
    public Object updateUI() {
        return null;
    }

    /**
     * 以1920x1080位基准, Item可见范围宽度<br/>
     * 另见{@link #getPaddingLeftRight()}
     */
    public int getWidth() {
        return 0;
    }

    /**item实际宽度**/
    public void setActualItemSize(int width, int height) {
        mActualWidth = width;
        mActualHeight = height;
    }

    /**item实际宽度**/
    protected int getActualItemWidth() {
        return mActualWidth;
    }
    /**item实际高度**/
    protected int getActualItemHeight() {
        return mActualHeight;
    }

    /**
     * 以1920x1080位基准, Item可见范围高度, 如果标题在图片下方, 标题不算高度<br/>
     * 另见{@link #getPaddingTop()}
     */
    public int getHeight() {
        return 0;
    }

    /**
     * 以1920x1080为基准, Item上padding距离
     */
    public int getPaddingTop() {
        return 21;
    }

    /**
     * 以1920x1080为基准, Item下padding距离<br/>
     *<li>标题在图片内的为背景padding</li>
     * <li>标题在图片外的为第二行文字高度</li>
     */
    public int getPaddingBottom() {
        return 21;
    }

    /**
     * 以1920x1080为基准, Item左/右的padding距离(左右padding值相同)
     */
    public int getPaddingLeftRight() {
        return 21;
    }

    @Override
    public void onEvent(int event, Object arg) {

    }

}
