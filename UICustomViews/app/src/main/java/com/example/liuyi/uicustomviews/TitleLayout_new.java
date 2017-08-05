package com.example.liuyi.uicustomviews;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.widget.Toast.*;

public class TitleLayout_new extends LinearLayout {

    public TitleLayout_new(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button button = (Button)findViewById(R.id.title_back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TitleLayout_new", "onClick: ");
            }
        });
    }


}
