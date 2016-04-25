package com.whiskeyfei.love.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.adapter.BottomTabAdapter;
import com.whiskeyfei.love.adapter.TabViewPagerAdapter;
import com.whiskeyfei.love.utils.ListUtils;
import com.whiskeyfei.love.widget.BottomTabLayout;
import com.whiskeyfei.love.widget.TabItemView;
import com.whiskeyfei.love.widget.TabViewPager;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity implements TabItemView.OnTabLayoutClickListener{

    private String mTabNames[] = {"Chats", "Contacts", "Discover", "Me"};
    private TabViewPager mViewPager;

    private List<String> mLists;

    private BottomTabLayout mBottomTabLayout;
    private BottomTabAdapter mBottomTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        getWindow().setBackgroundDrawable(null);

        mViewPager = (TabViewPager)findViewById(R.id.tabViewpager);
        mViewPager.setScrollEnabled(false);
        mBottomTabLayout = (BottomTabLayout) findViewById(R.id.tabLayout);

        mBottomTabAdapter = new BottomTabAdapter(getApplicationContext(),getList());
//        mBottomTabAdapter.setData(getList());

        mViewPager.setAdapter(new TabViewPagerAdapter(getApplicationContext(), getList()));
        mBottomTabLayout.setOnTabLayoutClickListener(this);
        mBottomTabLayout.setAdapter(mBottomTabAdapter);
        mBottomTabLayout.setViewPager(mViewPager);
    }

    private List<String> getList() {
        if (ListUtils.isEmpty(mLists)){
            mLists = new ArrayList<>();
            int len = mTabNames.length;
            for (int i = 0; i < len; i++) {
                mLists.add(mTabNames[i]);
            }
        }
        return mLists;
    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(TabLayoutActivity.this, "position:"+position, Toast.LENGTH_SHORT).show();
    }

}
