package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.vocabularyproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.pager);
        com.example.vocabularyproject.pager_adapter adapter = new com.example.vocabularyproject.pager_adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}