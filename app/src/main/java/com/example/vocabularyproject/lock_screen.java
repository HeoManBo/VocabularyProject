package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;
import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;

public class lock_screen extends AppCompatActivity {
    FileSplit fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        fs = new FileSplit(R.raw.chap01); //test데이터를 읽어옴

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        com.example.vocabularyproject.wordpager.MystateAdapter adapter = new com.example.vocabularyproject.wordpager.MystateAdapter(this); //ViewPager Adapter 생성

        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.voca);
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);
    }
}