package com.example.vocabularyproject.chap01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;

import java.util.ArrayList;

//Chapter를 Viewpager 방식으로 보여줌

public class wordpager extends AppCompatActivity {
    FileSplit fs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
//      chap activity에서 chapter 선택시 가져올 word.text 가져올 때 사용
//      Intent intent = getIntent();
//      intent.getBundleExtra("word");

        fs = new FileSplit(R.raw.chap01); //test데이터를 읽어옴

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        MystateAdapter adapter = new MystateAdapter(this); //ViewPager Adapter 생성

        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.voca);
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);

    }

    private class MystateAdapter extends FragmentStateAdapter{
        private ArrayList<Fragment> fragments;

        MystateAdapter(FragmentActivity fa){
            super(fa);
            fragments = new ArrayList<>();
            fragments.add(new word_fragment1());
            fragments.add(new word_fragment2());
            fragments.add(new word_fragment3());
            fragments.add(new word_fragment4());
            fragments.add(new word_fragment5());
            fragments.add(new word_fragment6());
            fragments.add(new word_fragment7());
            fragments.add(new word_fragment8());
            fragments.add(new word_fragment9());
            fragments.add(new word_fragment10());
            fragments.add(new word_fragment11());
            fragments.add(new word_fragment12());
            fragments.add(new word_fragment13());
            fragments.add(new word_fragment14());
            fragments.add(new word_fragment15());
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