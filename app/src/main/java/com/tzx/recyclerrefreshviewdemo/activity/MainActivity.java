package com.tzx.recyclerrefreshviewdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tzx.recyclerrefreshviewdemo.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onListViewClick(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void onRecyclerViewClick(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void onScrollViewClick(View view) {
        startActivity(new Intent(this, ScrollViewActivity.class));
    }

    public void onXRecycleViewClick(View view) {
        startActivity(new Intent(this, XRecyleViewActivity.class));
    }

    public void onSwipeRefreshActivity(View view) {
        startActivity(new Intent(this, SwipeRefreshActivity.class));
    }
}
