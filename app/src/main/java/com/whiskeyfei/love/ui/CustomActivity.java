package com.whiskeyfei.love.ui;

import android.app.Activity;
import android.os.Bundle;

import com.whiskeyfei.love.R;

/**
 * Created by whiskeyfei on 16/4/20.
 */
public class CustomActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
