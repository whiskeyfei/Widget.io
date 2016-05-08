package com.whiskeyfei.love.ui;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.widget.RLayoutView;

/**
 * Created by whiskeyfei on 16/5/7.
 */
public class RLayoutViewActivity extends BaseActivity{
    private RLayoutView mRLayoutView;
    @Override
    public void onCreate() {
        setContentView(R.layout.rlayout);
    }

    @Override
    public void initView() {
        mRLayoutView = (RLayoutView) findViewById(R.id.rlayoutview);
//        mRLayoutView.setViewParams(getParams());
//        mRLayoutView.getImageView(RLayoutView.IMAGE_BG).setBackgroundColor(getResources().getColor(R.color.image_color));
//        mRLayoutView.getImageView(RLayoutView.IMAGE_LEFT_TOP).setBackgroundColor(getResources().getColor(R.color.white));
//        mRLayoutView.getImageView(RLayoutView.IMAGE_RIGHT_TOP).setBackgroundColor(getResources().getColor(R.color.white));
//        mRLayoutView.getImageView(RLayoutView.IMAGE_LEFT_BOTTOM).setBackgroundColor(getResources().getColor(R.color.white));
//        mRLayoutView.getImageView(RLayoutView.IMAGE_RIGHT_BOTTOM).setBackgroundColor(getResources().getColor(R.color.white));
//        mRLayoutView.setTextLayoutBg(getResources().getColor(R.color.bgcolor));
//        mRLayoutView.setTitleText("title");
//        mRLayoutView.setTitleTextColor(getResources().getColor(R.color.white));
//        mRLayoutView.setDescText("desc");
//        mRLayoutView.setDescTextColor(getResources().getColor(R.color.white));

    }

    private RLayoutView.ParamsBean getParams() {
        RLayoutView.ParamsBean params = new RLayoutView.ParamsBean();
        params.width = 400;
        params.height = 300;
        return params;
    }
}
