package com.whiskeyfei.love.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.adapter.BottomTabAdapter;
import com.whiskeyfei.love.model.ItemFactory;
import com.whiskeyfei.love.widget.TabJustLayout;

/**
 * Created by whiskeyfei on 16/4/19.
 */
public class TabLayoutJustActivity extends Activity{

    private TabJustLayout mTabJustLayout;
    private BottomTabAdapter mBottomTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just);
        getWindow().setBackgroundDrawable(null);

        mTabJustLayout = (TabJustLayout) findViewById(R.id.tabLayout);

        mBottomTabAdapter = new BottomTabAdapter(getApplicationContext(), ItemFactory.getData());
        mBottomTabAdapter.setOnItemClickListener(new BottomTabAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int tagType) {
                Toast.makeText(TabLayoutJustActivity.this, "tagType:"+tagType, Toast.LENGTH_SHORT).show();
            }
        });
        mTabJustLayout.setAdapter(mBottomTabAdapter);
    }


}
