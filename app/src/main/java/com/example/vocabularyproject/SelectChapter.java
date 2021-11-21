package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectChapter extends AppCompatActivity implements View.OnClickListener {

    static Context mContext ; //fileSplit에서 사용할 context getResource를 위해
    Button chap01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chapter);
        mContext = this;
        chap01 = findViewById(R.id.chap01);
        chap01.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.chap01:
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.chap01.wordpager"));
                startActivity(intent);
            break;
        }
    }
}