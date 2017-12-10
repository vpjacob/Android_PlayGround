package com.example.vpjacob.listview;

import android.util.Log;
import android.view.LayoutInflater;
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


    class myHolder{
        TextView textView1;
        TextView textView2;
    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
////        Log.d(TAG, "getView: " + i);
////        TextView textView = new TextView(viewGroup.getContext());
////        textView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT));
////        textView.setTextSize(30);
////        textView.setText(mDatas.get(i));
//
//        //布局充气
//        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        View view1 = layoutInflater.inflate(R.layout.lv_item_layout,null);
//        TextView textView = (TextView) view1.findViewById(R.id.lv_item);
//        textView.setText(mDatas.get(i));
//        return textView;
//
//
//    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        myHolder myHolder = null;

        if (view == null){
            //布局充气

            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            view = layoutInflater.inflate(android.R.layout.simple_list_item_2,null);

            myHolder = new myHolder();
            myHolder.textView1 = (TextView) view.findViewById(android.R.id.text1);
            myHolder.textView2 = (TextView) view.findViewById(android.R.id.text2);

            view.setTag(myHolder);
        }else {
            myHolder =(myHolder) view.getTag();
        }

        myHolder.textView1.setText(mDatas.get(i));
        myHolder.textView2.setText(mDatas.get(i));

            return view;


    }



}
