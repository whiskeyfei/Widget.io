package com.whiskeyfei.love.ui;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whiskeyfei on 16/4/22.
 */
public abstract class  BaseActivity extends Activity{

    protected List<String> mDataList;
    private static final int DATA_SIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreate();
        initData();
        initView();
    }

    public abstract void onCreate();
    public abstract void initView();
    private void initData(){
        if (mDataList == null){
            mDataList = new ArrayList<>();
            for (int i = 0; i < DATA_SIZE; i++) {
                mDataList.add("i:"+i);
            }
        }
    }




}
