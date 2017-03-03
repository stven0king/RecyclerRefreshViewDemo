package com.tzx.recyclerrefreshviewdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tzx.recyclerrefreshviewdemo.R;
import com.tzx.recyclerrefreshviewdemo.adapter.ListAdapter;
import com.tzx.recyclerrefreshviewdemo.xrecycleview.XRecyclerItemClickListener;
import com.tzx.recyclerrefreshviewdemo.xrecycleview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * Date: 2016/2/17.
 */
public class XRecyleViewActivity extends Activity {
    XRecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecycle_view);

        recyclerView = (XRecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ListAdapter mAdapter = new ListAdapter(getData(), XRecyleViewActivity.this);
        mAdapter.setxRecyclerItemClickListener(new XRecyclerItemClickListener() {
            @Override
            public void onWrappedItemClick(View view, int wrappedPosition) {

            }
        });
        recyclerView.setAdapter(mAdapter);

        TextView footerView = (TextView) LayoutInflater.from(this).inflate(android.R.layout.simple_list_item_1, null, false);
        footerView.setText("footer");
        mAdapter.addFooterView(footerView);

        TextView view = (TextView) LayoutInflater.from(this).inflate(android.R.layout.simple_list_item_1, null, false);
        view.setText("header");
        mAdapter.addHeaderView(view);

        TextView endlessView = (TextView) LayoutInflater.from(this).inflate(android.R.layout.simple_list_item_1, null, false);
        endlessView.setText("endlessView");
        mAdapter.addEndlessView(recyclerView, endlessView, true);

        TextView footerView2 = (TextView) LayoutInflater.from(this).inflate(android.R.layout.simple_list_item_1, null, false);
        footerView2.setText("footer2");
        mAdapter.addFooterView(footerView2);

        mAdapter.setxRecyclerItemClickListener(new XRecyclerItemClickListener() {
            @Override
            public void onWrappedItemClick(View view, int wrappedPosition) {
                Toast.makeText(XRecyleViewActivity.this, "sss" + wrappedPosition, Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<String> getData() {
        List<String> datas = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            datas.add("" + i);
        }
        return datas;
    }
}
