package com.whiskeyfei.love.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by whiskeyfei on 16/5/8.
 */
public class RLayoutView extends RelativeLayout {
    private Context mContext;

    private LinearLayout mTextLayout;
    private static final int TEXT_LAYOUT_ID = 1;
    private TextView mTitle;
    private TextView mDesc;
    private ParamsBean mParams;

    private SparseArray<View> mViews;

    public static final int IMAGE_BG = 0;
    public static final int IMAGE_LEFT_TOP = 1;
    public static final int IMAGE_RIGHT_TOP = 2;
    public static final int IMAGE_LEFT_BOTTOM = 3;
    public static final int IMAGE_RIGHT_BOTTOM = 4;

    public RLayoutView(Context context) {
        super(context);
        mContext = context;
    }

    public RLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public RLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void init(){
        if (mViews == null){
            mViews = new SparseArray<>();
        }

        if (mParams.width == 0){

        }

        setLayoutParams(new LayoutParams(mParams.width,mParams.height));
        setFocusable(false);
        addImageView(IMAGE_BG);
        addImageView(IMAGE_LEFT_TOP);
        addImageView(IMAGE_RIGHT_TOP);
        addTextLayout();
        addImageView(IMAGE_LEFT_BOTTOM);
        addImageView(IMAGE_RIGHT_BOTTOM);
    }

    @SuppressWarnings("ResourceType")
    private void addTextLayout() {
        mTextLayout = new LinearLayout(mContext);
        mTextLayout.setId(TEXT_LAYOUT_ID);
        mTextLayout.setFocusable(false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mParams.width, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mTextLayout.setOrientation(LinearLayout.VERTICAL);
        //添加title
        mTitle = new TextView(mContext);
        RelativeLayout.LayoutParams titleLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mTextLayout.addView(mTitle, titleLayoutParams);

        //添加desc
        mDesc = new TextView(mContext);
        RelativeLayout.LayoutParams descLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mTextLayout.addView(mDesc, descLayoutParams);

        addView(mTextLayout, params);
    }

    private void addImageView(int index) {
        ImageView imageView = new ImageView(mContext);
        imageView.setFocusable(false);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams ivLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);;
        switch (index) {
            case IMAGE_BG:
                ivLayoutParams.width = mParams.width;
                ivLayoutParams.height = mParams.height;
                addView(imageView, ivLayoutParams);
                mViews.put(IMAGE_BG, imageView);
                break;
            case IMAGE_LEFT_TOP:
                ivLayoutParams.width = 50;
                ivLayoutParams.height = 50;
                ivLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                addView(imageView, ivLayoutParams);
                mViews.put(IMAGE_LEFT_TOP,imageView);
                break;
            case IMAGE_RIGHT_TOP:
                ivLayoutParams.width = 50;
                ivLayoutParams.height = 50;
                ivLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                addView(imageView, ivLayoutParams);
                mViews.put(IMAGE_RIGHT_TOP,imageView);
                break;
            case IMAGE_LEFT_BOTTOM:
                ivLayoutParams.width = 50;
                ivLayoutParams.height = 50;
                ivLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                ivLayoutParams.addRule(RelativeLayout.ABOVE,TEXT_LAYOUT_ID);
                addView(imageView, ivLayoutParams);
                mViews.put(IMAGE_LEFT_BOTTOM,imageView);
                break;

            case IMAGE_RIGHT_BOTTOM:
                ivLayoutParams.width = 50;
                ivLayoutParams.height = 50;
                ivLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                ivLayoutParams.addRule(RelativeLayout.ABOVE,TEXT_LAYOUT_ID);
                addView(imageView, ivLayoutParams);
                mViews.put(IMAGE_RIGHT_BOTTOM,imageView);
                 break;
        }
    }

    public void setViewParams(ParamsBean params) {
        if (params == null) {
            return;
        }
        mParams = params;
        init();
    }

    public ImageView getImageView(int index){
        if (mViews != null){
            return (ImageView) mViews.get(index);
        }
        return null;
    }

    public void setTextLayoutBg(int color){
        if (mTextLayout != null) mTextLayout.setBackgroundColor(color);
    }

    public void setTitleText(String str){
        if (mTitle != null) mTitle.setText(str);
    }

    public void setDescText(String str){
        if (mDesc != null) mDesc.setText(str);
    }

    public void setDescTextColor(int color){
        if (mDesc != null) mDesc.setTextColor(color);
    }

    public void setTitleTextColor(int color){
        if (mTitle != null) mTitle.setTextColor(color);
    }

    public static class ParamsBean{
        public int width;
        public int height;
    }

}
