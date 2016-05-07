package com.whiskeyfei.love.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whiskeyfei.love.R;

/* *
 *  using FrameLayout Practice Custom view
 */
public class CombinationView extends FrameLayout {
	
	private Context mContext;

	private CombinationViewParams mParams;
	private ImageView mImageRT;
	private ImageView mImageView;
	private ImageView mImageLT;
	private LinearLayout mTextLayout;
	private TextView mTitle;
	private TextView mDesc;

	public CombinationView(Context context) {
		super(context);
		mContext = context;
	}

	public CombinationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
	}

	public CombinationView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
	}
	
	public void setViewParams(CombinationViewParams params){
		if (params == null){
			return;
		}
		mParams = params;
		init();
	}

	private void init() {
		setFocusable(false);
		addImageView();
		addLeftImageView();
		addRightImageView();
		addTextLayout();
	}


	private void addTextLayout() {
		 mTextLayout = new LinearLayout(mContext);
		mTextLayout.setFocusable(false);
		 LayoutParams params = new LayoutParams(mParams.width, LayoutParams.WRAP_CONTENT);
		 params.gravity = Gravity.BOTTOM;
		 mTextLayout.setOrientation(LinearLayout.VERTICAL);
		 //添加title
		 mTitle = new TextView(mContext);
		 mTitle.setTextColor(getResources().getColor(R.color.white));
		 LayoutParams titleLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		 mTextLayout.addView(mTitle, titleLayoutParams);
		 //添加desc
		 mDesc = new TextView(mContext);
		 mDesc.setTextColor(getResources().getColor(R.color.white));
		 LayoutParams descLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		 mTextLayout.addView(mDesc, descLayoutParams);
		 
	     addView(mTextLayout, params);

	}

	private void addRightImageView() {
		mImageRT = new ImageView(mContext);
		mImageRT.setFocusable(false);
		mImageRT.setScaleType(ScaleType.FIT_XY);
		LayoutParams ivLayoutParams = new LayoutParams(50, 50);
		ivLayoutParams.gravity = Gravity.RIGHT;
		addView(mImageRT, ivLayoutParams);
	}

	private void addLeftImageView() {
		mImageLT = new ImageView(mContext);
		mImageLT.setFocusable(false);
		mImageLT.setScaleType(ScaleType.FIT_XY);
		LayoutParams ivLayoutParams = new LayoutParams(50, 50);
		addView(mImageLT, ivLayoutParams);
	}

	private void addImageView() {
		mImageView = new ImageView(mContext);
		mImageView.setFocusable(false);
		mImageView.setScaleType(ScaleType.FIT_XY);
		LayoutParams ivLayoutParams = new LayoutParams(mParams.width, mParams.height);
		addView(mImageView, ivLayoutParams);
	}
	
	public void setImageDrawable(Drawable background){
		if (mImageView != null) mImageView.setImageDrawable(background);
	}

	public void setBackgroundColor(int color){
		if (mImageView != null) mImageView.setBackgroundColor(color);
	}

	public void setLeftTopImage(Drawable background){
		if (mImageLT != null) mImageLT.setImageDrawable(background);
	}
	
	public void setRightTopImage(Drawable background){
		if (mImageRT != null) mImageRT.setImageDrawable(background);
	}
	
	@SuppressWarnings("deprecation")
	public void setTextLayoutBg(Drawable background){
		if (mTextLayout != null) mTextLayout.setBackgroundDrawable(background);
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

//	public void setBackgroundResource(int resid ){
//		super.setBackgroundResource(resid);
//	}
//
//	public void setFocusable(boolean focusable){
//		super.setFocusable(focusable);
//	}

	public static class CombinationViewParams {
		public int width;
		public int height;
		public int bgRes;
	}

}
