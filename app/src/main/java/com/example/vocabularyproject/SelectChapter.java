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
    Button chap01,chap02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chapter);
        mContext = this;
        chap01 = findViewById(R.id.chap01);
        chap01.setOnClickListener(this);
        chap02 = findViewById(R.id.chap02);
        chap02.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        Intent intent = new Intent();
        ComponentName name = null;
        switch (view.getId()){
            case R.id.chap01:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap01");
                intent.setComponent(name);
                intent.putExtra("chap02","chap02");
                startActivity(intent);
                break;
            case R.id.chap02:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap02");
                intent.setComponent(name);
                intent.putExtra("chap02","chap02");
                startActivity(intent);
                break;
        }
    }
}