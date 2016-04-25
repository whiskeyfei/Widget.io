package com.whiskeyfei.love.ui;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.whiskeyfei.love.R;
import com.whiskeyfei.love.adapter.ItemAdapter;

/**
 * Created by whiskeyfei on 16/4/22.
 * 记录：
 * ListView 基本使用
 * Adapter 常用写法
 */
public class AdapterActivity extends BaseActivity {
    private ListView mListView;

    @Override
    public void onCreate() {
        setContentView(R.layout.adapterlayout);
    }

    @Override
    public void initView() {
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setEmptyView(findViewById(R.id.empty));
//        View header = new View(this);
//        header.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,60));
//        mListView.addHeaderView(header);
        mListView.setAdapter(new ItemAdapter(getApplicationContext(),mDataList));
        //点击监听
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        //touch监听
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });

        //滑动监听
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //实时刷新
            }
        });

    }
}
