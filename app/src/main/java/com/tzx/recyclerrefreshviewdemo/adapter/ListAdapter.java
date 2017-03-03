package com.tzx.recyclerrefreshviewdemo.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tzx.recyclerrefreshviewdemo.R;
import com.tzx.recyclerrefreshviewdemo.xrecycleview.XRecyclerViewAdapter;
import com.tzx.recyclerrefreshviewdemo.xrecycleview.XRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends XRecyclerViewAdapter<ListAdapter.MyViewHolder> {

    private List<String> mDataset;
    private Context context;

    public ListAdapter(List<String> dataset, Context context) {
        mDataset = dataset;
        this.context = context;
    }

    public void setmDateSet(List<String> dataset) {
        mDataset = dataset;
        notifyDataSetChanged();
    }

    public List<String> getmDataset() {
        return mDataset;
    }

    @Override
    public void onWrappedItemClick(View view, int wrappedPosition) {
        Toast.makeText(context, "sss" + wrappedPosition, Toast.LENGTH_LONG).show();
    }

    @Override
    public MyViewHolder onCreateWrappedViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(parent, this);
    }

    @Override
    public void onBindWrappedViewHolder(MyViewHolder holder, int wrappedPosition, int viewType) {
        holder.mTextView.setText(mDataset.get(wrappedPosition));
    }

    @Override
    public int getWrappedItemCount() {
        return mDataset.size();
    }

    @Override
    public int getWrappedItemViewType(int wrappedPosition) {
        return 0;
    }

    @Override
    public void onLoadMore() {
        Log.e("loadmore","loadmore");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Handler mHandler=new Handler(Looper.getMainLooper());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        getmDataset().addAll(getData());
                        notifyDataSetChanged();
                        autoLoadingFinish();
                    }
                });
            }
        }).start();
    }


    private List<String> getData() {
        List<String> datas = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            datas.add("load" + i);
        }
        return datas;
    }

    public class MyViewHolder extends XRecyclerViewHolder {

        public TextView mTextView;

        public MyViewHolder(ViewGroup parent, XRecyclerViewAdapter xRecyclerViewAdapter) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false),
                    xRecyclerViewAdapter);
            mTextView = (TextView) itemView.findViewById(R.id.text1);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(final View v) {

                    return false;
                }
            });
        }

    }

}
