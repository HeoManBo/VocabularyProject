package com.example.vocabularyproject.wordpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;

public class wordpager_chap05 extends AppCompatActivity {
    FileSplit fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
//      chap activity에서 chapter 선택시 가져올 word.text 가져올 때 사용
//      Intent intent = getIntent();
//      intent.getBundleExtra("word");

        fs = new FileSplit(R.raw.chap05); //test데이터를 읽어옴

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        com.example.vocabularyproject.wordpager.MystateAdapter adapter = new com.example.vocabularyproject.wordpager.MystateAdapter(this); //ViewPager Adapter 생성

        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.voca);
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);

    }
}