package com.whiskeyfei.love.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.adapter.BottomTabAdapter;
import com.whiskeyfei.love.adapter.TabViewPagerAdapter;
import com.whiskeyfei.love.model.ItemFactory;
import com.whiskeyfei.love.widget.BottomTabLayout;
import com.whiskeyfei.love.widget.TabItemView;
import com.whiskeyfei.love.widget.TabViewPager;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity implements TabItemView.OnTabLayoutClickListener{

    private TabViewPager mViewPager;
    private BottomTabLayout mBottomTabLayout;
    private BottomTabAdapter mBottomTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        getWindow().setBackgroundDrawable(null);

        mViewPager = (TabViewPager)findViewById(R.id.tabViewpager);
        mViewPager.setScrollEnabled(true);//viewpager 可滑动
        mBottomTabLayout = (BottomTabLayout) findViewById(R.id.tabLayout);
        mBottomTabAdapter = new BottomTabAdapter(getApplicationContext(), ItemFactory.getData());
        mViewPager.setAdapter(new TabViewPagerAdapter(getApplicationContext(), getList()));
        mBottomTabLayout.setOnTabLayoutClickListener(this);
        mBottomTabLayout.setAdapter(mBottomTabAdapter);
        mBottomTabLayout.setViewPager(mViewPager);
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        int size = ItemFactory.getData().size();
        for (int i = 0; i < size; i++){
            list.add(ItemFactory.getData().get(i).name);
        }
        return list;
    }

    @Override
    public void onClick(View v, int type) {
        Toast.makeText(TabLayoutActivity.this, "type:"+type, Toast.LENGTH_SHORT).show();
    }

}
