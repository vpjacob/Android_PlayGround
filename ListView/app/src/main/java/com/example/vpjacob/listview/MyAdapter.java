package com.example.vpjacob.listview;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vpjacob on 2017/12/10.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<String> mDatas;
    private static final String TAG = "MyAdapter";
    public MyAdapter(ArrayList<String> datas) {
        mDatas = datas;
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount:");
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.d(TAG, "getView: " + i);
        TextView textView = new TextView(viewGroup.getContext());
        textView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(30);
        textView.setText(mDatas.get(i));
        return textView;
    }


}
