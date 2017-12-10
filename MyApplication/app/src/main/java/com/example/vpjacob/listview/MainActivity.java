package com.example.vpjacob.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv);

        ArrayList<String> datas = new ArrayList<String>();

        for (int i = 0;i < 150 ;i++){
            datas.add("test" + i);
        }

        MyAdapter addapter = new MyAdapter(datas);
        listView.setAdapter(addapter);

    }
}
