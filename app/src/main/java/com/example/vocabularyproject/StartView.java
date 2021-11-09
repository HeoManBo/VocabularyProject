package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StartView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startview);
        System.out.println("start Project");
    }
}