package com.whiskeyfei.love.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.adapter.BottomTabAdapter;
import com.whiskeyfei.love.widget.TabItemView;
import com.whiskeyfei.love.widget.TabJustLayout;

/**
 * Created by whiskeyfei on 16/4/19.
 */
public class TabLayoutJustActivity extends Activity implements TabItemView.OnTabLayoutClickListener{

    private String mTabNames[] = {"Chats", "Contacts", "Discover", "Me"};
//    private List<String> mLists;

    private TabJustLayout mTabJustLayout;
    private BottomTabAdapter mBottomTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just);
        getWindow().setBackgroundDrawable(null);

        mTabJustLayout = (TabJustLayout) findViewById(R.id.tabLayout);

//        mBottomTabAdapter = new BottomTabAdapter(getApplicationContext(),getList());
        mBottomTabAdapter = new BottomTabAdapter(getApplicationContext(),mTabNames);

        mTabJustLayout.setOnTabLayoutClickListener(this);
        mTabJustLayout.setAdapter(mBottomTabAdapter);
    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(TabLayoutJustActivity.this, "position:"+position, Toast.LENGTH_SHORT).show();
    }

//    private List<String> getList() {
//        if (ListUtils.isEmpty(mLists)){
//            mLists = new ArrayList<>();
//            int len = mTabNames.length;
//            for (int i = 0; i < len; i++) {
//                mLists.add(mTabNames[i]);
//            }
//        }
//        return mLists;
//    }
}
