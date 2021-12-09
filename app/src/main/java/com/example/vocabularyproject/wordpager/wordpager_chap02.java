package com.example.vocabularyproject.wordpager;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;

import java.util.ArrayList;

import com.example.vocabularyproject.word_fragment.word_fragment1;
import com.example.vocabularyproject.word_fragment.word_fragment10;
import com.example.vocabularyproject.word_fragment.word_fragment11;
import com.example.vocabularyproject.word_fragment.word_fragment12;
import com.example.vocabularyproject.word_fragment.word_fragment13;
import com.example.vocabularyproject.word_fragment.word_fragment14;
import com.example.vocabularyproject.word_fragment.word_fragment15;
import com.example.vocabularyproject.word_fragment.word_fragment2;
import com.example.vocabularyproject.word_fragment.word_fragment3;
import com.example.vocabularyproject.word_fragment.word_fragment4;
import com.example.vocabularyproject.word_fragment.word_fragment5;
import com.example.vocabularyproject.word_fragment.word_fragment6;
import com.example.vocabularyproject.word_fragment.word_fragment7;
import com.example.vocabularyproject.word_fragment.word_fragment8;
import com.example.vocabularyproject.word_fragment.word_fragment9;
import com.example.vocabularyproject.wordpager.*;
//Chapter를 Viewpager 방식으로 보여줌

public class wordpager_chap02 extends AppCompatActivity {
    FileSplit fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        Intent intent = getIntent();
        String chap02 = intent.getStringExtra("chap02");

        fs = new FileSplit(2); //test데이터를 읽어옴

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        MystateAdapter adapter = new MystateAdapter(this); //ViewPager Adapter 생성


        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.getVoca());
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);

    }

    private class MystateAdapter extends FragmentStateAdapter{
        private ArrayList<Fragment> fragments;

        MystateAdapter(FragmentActivity fa){
            super(fa);
            fragments = new ArrayList<>();
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment1());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment2());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment3());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment4());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment5());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment6());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment7());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment8());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment9());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment10());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment11());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment12());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment13());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment14());
            fragments.add(new com.example.vocabularyproject.word_fragment.word_fragment15());
        }

        public void putWord(Bundle bundle){
            for(int i=0; i<15; i++) {
                fragments.get(i).setArguments(bundle); //첫번째 frag에 voca list 전달
            }
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }
}