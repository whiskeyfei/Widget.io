package com.whiskeyfei.love.ui;

import android.widget.Toast;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.widget.TopBar;

/**
 * Created by whiskeyfei on 16/5/7.
 */
public class TextViewActivity extends BaseActivity implements TopBar.topbarClickListener {

    private TopBar mTopbar;

    @Override
    public void onCreate() {
        setContentView(R.layout.text);
    }

    @Override
    public void initView() {
        mTopbar = (TopBar) findViewById(R.id.topBar);
        mTopbar.setOnTopbarClickListener(this);
        mTopbar.setButtonVisable(0, true);
        mTopbar.setButtonVisable(1, false);
    }

    @Override
    public void leftClick() {
        Toast.makeText(TextViewActivity.this,
                "left", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void rightClick() {
        Toast.makeText(TextViewActivity.this,
                "right", Toast.LENGTH_SHORT)
                .show();
    }
}
