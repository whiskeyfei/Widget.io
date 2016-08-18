package com.whiskeyfei.love;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.whiskeyfei.love.ui.AdapterActivity;
import com.whiskeyfei.love.ui.CombinationViewActivity;
import com.whiskeyfei.love.ui.CustomActivity;
import com.whiskeyfei.love.ui.RLayoutViewActivity;
import com.whiskeyfei.love.ui.TabLayoutActivity;
import com.whiskeyfei.love.ui.TabLayoutJustActivity;
import com.whiskeyfei.love.ui.TextViewActivity;
import com.whiskeyfei.love.ui.VideoViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whiskeyfei on 16/4/18.
 */
public class StartActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private SparseArray<Class<?>> mClasses = new SparseArray<>();
    private List<String> mListItems = new ArrayList<>();
    private ListView mListView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mListView = (ListView) findViewById(R.id.listview);
        init();
    }

    private void init() {
        mContext = getApplicationContext();
        mClasses.put(0, TabLayoutActivity.class);
        mClasses.put(1, TabLayoutJustActivity.class);
        mClasses.put(2, CustomActivity.class);
        mClasses.put(3, AdapterActivity.class);
        mClasses.put(4, CombinationViewActivity.class);
        mClasses.put(5, RLayoutViewActivity.class);
        mClasses.put(6, TextViewActivity.class);
        mClasses.put(7, VideoViewActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
