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
    Button chap01,chap02,chap03,chap04,chap05,chap06,chap07,chap08,chap09,chap010;
    Button star_select, private_word;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chapter);
        mContext = this;
        chap01 = findViewById(R.id.chap01);
        chap01.setOnClickListener(this);
        chap02 = findViewById(R.id.chap02);
        chap02.setOnClickListener(this);
        chap03 = findViewById(R.id.chap03);
        chap03.setOnClickListener(this);
        chap04 = findViewById(R.id.chap04);
        chap04.setOnClickListener(this);
        chap05 = findViewById(R.id.chap05);
        chap05.setOnClickListener(this);
        chap06 = findViewById(R.id.chap06);
        chap06.setOnClickListener(this);
        chap07 = findViewById(R.id.chap07);
        chap07.setOnClickListener(this);
        chap08 = findViewById(R.id.chap08);
        chap08.setOnClickListener(this);
        chap09 = findViewById(R.id.chap09);
        chap09.setOnClickListener(this);
        chap010 = findViewById(R.id.chap10);
        chap010.setOnClickListener(this);
        star_select = findViewById(R.id.star_select);
        star_select.setOnClickListener(this);
        private_word = findViewById(R.id.private_word);
        private_word.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        Intent intent = new Intent();
        ComponentName name = null;
        switch (view.getId()){
            case R.id.chap01:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.word_fragment.wordpager_chap01");
                intent.setComponent(name);
                intent.putExtra("chap01","chap01");
                startActivity(intent);
                break;
            case R.id.chap02:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap02");
                intent.setComponent(name);
                intent.putExtra("chap02","chap02");
                startActivity(intent);
                break;
            case R.id.chap03:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.word_fragment.wordpager_chap01");
                intent.setComponent(name);
                intent.putExtra("chap03","chap03");
                startActivity(intent);
                break;
            case R.id.chap04:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap02");
                intent.setComponent(name);
                intent.putExtra("chap04","chap04");
                startActivity(intent);
                break;
            case R.id.chap05:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.word_fragment.wordpager_chap01");
                intent.setComponent(name);
                intent.putExtra("chap05","chap05");
                startActivity(intent);
                break;
            case R.id.chap06:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap02");
                intent.setComponent(name);
                intent.putExtra("chap06","chap06");
                startActivity(intent);
                break;
            case R.id.chap07:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.word_fragment.wordpager_chap01");
                intent.setComponent(name);
                intent.putExtra("chap07","chap07");
                startActivity(intent);
                break;
            case R.id.chap08:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap02");
                intent.setComponent(name);
                intent.putExtra("chap08","chap08");
                startActivity(intent);
                break;
            case R.id.chap09:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.word_fragment.wordpager_chap01");
                intent.setComponent(name);
                intent.putExtra("chap09","chap09");
                startActivity(intent);
                break;
            case R.id.chap10:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.wordpager.wordpager_chap02");
                intent.setComponent(name);
                intent.putExtra("chap10","chap10");
                startActivity(intent);
                break;

            case R.id.star_select:
                name = new ComponentName("com.example.vocabularyproject","com.example.vocabularyproject.FavorityWord");
                intent.setComponent(name);
                intent.putExtra("chap10","chap10");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}