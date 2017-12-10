package com.example.liuyi.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private List<Fruit> fruitList = new ArrayList<>();
//    public String[] data = {"Apple","Banna","orange","watermelon","pear","pineapple","Apple","Banna","orange","watermelon","pear","pineapple","Apple","Banna","orange","watermelon","pear","pineapple","Apple","Banna","orange","watermelon","pear","pineapple"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//    }


    private List<Fruit> fruitList = new ArrayList<>();

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
            FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initFruits(){
        for (int i = 0; i < 10; i++) {
            Fruit apple = new Fruit("Apple",R.drawable.appiconh);
            fruitList.add(apple);
        }
    }
}
