package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.vocabularyproject.TestView.TestWordChapter;

public class StartView extends AppCompatActivity {

    Button word_learning;
    Button word_learning_test;
    Button private_add_learning;
    Button end;
    ImageButton setting;
    @SuppressLint("StaticFieldLeak")
    static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startview);

        mContext = this;
        word_learning = findViewById(R.id.Word_learning);
        word_learning_test = findViewById(R.id.Word_learning_test);
        private_add_learning = findViewById(R.id.private_word_add);
        end = findViewById(R.id.end);
        setting = findViewById(R.id.setting);

        Intent intent = new Intent(getApplicationContext(), lock_screen_service.class);
        startService(intent);

    }

    public void onClick(View view){ //각 버튼 클릭시 이동
        Intent intent = new Intent();
        if(view == word_learning){
            ComponentName componentName = new ComponentName(this,SelectChapter.class);
            intent.setComponent(componentName);
            startActivity(intent);
        }
        else if(view == word_learning_test){
            ComponentName componentName = new ComponentName(this, TestWordChapter.class);
            intent.setComponent(componentName);
            startActivity(intent);
        }
        else if(view == private_add_learning){
            ComponentName componentName = new ComponentName(this, privateWordAdd.class);
            intent.setComponent(componentName);
            startActivity(intent);
        }
        else if(view == setting){
            ComponentName componentName = new ComponentName(this, settingView.class);
            intent.setComponent(componentName);
            startActivity(intent);
        }
        else if(view == end){
            finish();
        }
    }
}