package com.example.vocabularyproject.TestView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vocabularyproject.R;

public class TestWordChapter extends AppCompatActivity implements View.OnClickListener {

    Button chap01, chap02, chap03, chap04, chap05, chap06, chap07, chap08, chap09, chap010;
    String whatChap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_word_chapter);
        chap01 = findViewById(R.id.chap01_test);
        chap01.setOnClickListener(this);
        chap02 = findViewById(R.id.chap02_test);
        chap02.setOnClickListener(this);
        chap03 = findViewById(R.id.chap03_test);
        chap03.setOnClickListener(this);
        chap04 = findViewById(R.id.chap04_test);
        chap04.setOnClickListener(this);
        chap05 = findViewById(R.id.chap05_test);
        chap05.setOnClickListener(this);
        chap06 = findViewById(R.id.chap06_test);
        chap06.setOnClickListener(this);
        chap07 = findViewById(R.id.chap07_test);
        chap07.setOnClickListener(this);
        chap08 = findViewById(R.id.chap08_test);
        chap08.setOnClickListener(this);
        chap09 = findViewById(R.id.chap09_test);
        chap09.setOnClickListener(this);
        chap010 = findViewById(R.id.chap10_test);
        chap010.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        ComponentName name = new ComponentName("com.example.vocabularyproject", "com.example.vocabularyproject.TestView.SelectLanguage");
        switch (view.getId()) {
            case R.id.chap01_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 1);
                startActivity(intent);
                break;
            case R.id.chap02_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 2);
                startActivity(intent);
                break;
            case R.id.chap03_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 3);
                startActivity(intent);
                break;
            case R.id.chap04_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 4);
                startActivity(intent);
                break;
            case R.id.chap05_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 5);
                startActivity(intent);
                break;
            case R.id.chap06_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 6);
                startActivity(intent);
                break;
            case R.id.chap07_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 7);
                startActivity(intent);
                break;
            case R.id.chap08_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 8);
                startActivity(intent);
                break;
            case R.id.chap09_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 9);
                startActivity(intent);
                break;
            case R.id.chap10_test:
                intent.setComponent(name);
                intent.putExtra("whatChap", 10);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}