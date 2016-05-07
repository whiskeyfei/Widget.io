package com.whiskeyfei.love.ui;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.widget.CombinationView;

/**
 * Created by whiskeyfei on 16/5/7.
 */
public class CombinationViewActivity extends BaseActivity{
    private CombinationView mCombinationView;
    @Override
    public void onCreate() {
        setContentView(R.layout.combin);
    }

    @Override
    public void initView() {
        mCombinationView = (CombinationView) findViewById(R.id.combinview);
        mCombinationView.setViewParams(getParams());
        mCombinationView.setBackgroundColor(getResources().getColor(R.color.image_color));
        mCombinationView.setLeftTopImage(getResources().getDrawable(R.mipmap.ic_launcher));
        mCombinationView.setRightTopImage(getResources().getDrawable(R.mipmap.ic_launcher));
        mCombinationView.setTextLayoutBg(getResources().getColor(R.color.bgcolor));
        mCombinationView.setTitleText("title");
        mCombinationView.setDescText("desc");
    }

    private CombinationView.CombinationViewParams getParams() {
        CombinationView.CombinationViewParams params = new CombinationView.CombinationViewParams();
        params.width = 900;
        params.height = 500;
        return params;
    }
}
