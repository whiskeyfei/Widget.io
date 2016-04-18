package com.whiskeyfei.love;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whiskeyfei on 16/4/18.
 */
public class StartActivity extends Activity implements AdapterView.OnItemClickListener {
    private SparseArray<Class<?>> mClasses = new SparseArray<>();
    private List<String> mListItems = new ArrayList<>();
    private ListView mListView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mListView = (ListView) findViewById(R.id.listview);
        init();
    }

    private void init() {
        mContext = getApplicationContext();
        mClasses.put(0, TabLayoutActivity.class);
        int len = mClasses.size();
        for (int i = 0; i < len; i++) {
            mListItems.add(mClasses.get(i).getName());

        }
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mListItems);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            Intent intent = new Intent(StartActivity.this,mClasses.get(position));
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
