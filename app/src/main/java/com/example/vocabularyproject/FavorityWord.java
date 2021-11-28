package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class FavorityWord extends AppCompatActivity {
    private static final String WORD_SETTING = "word_setting";
   SharedPreferences preferences = getSharedPreferences(WORD_SETTING, MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favority_word);

        myFavorityDB DB = new myFavorityDB(this);

    }

}