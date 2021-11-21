package com.example.vocabularyproject.chap01;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.vocabularyproject.chap01.word_fragment1;
import com.example.vocabularyproject.chap01.word_fragment10;
import com.example.vocabularyproject.chap01.word_fragment11;
import com.example.vocabularyproject.chap01.word_fragment12;
import com.example.vocabularyproject.chap01.word_fragment13;
import com.example.vocabularyproject.chap01.word_fragment14;
import com.example.vocabularyproject.chap01.word_fragment15;
import com.example.vocabularyproject.chap01.word_fragment2;
import com.example.vocabularyproject.chap01.word_fragment3;
import com.example.vocabularyproject.chap01.word_fragment4;
import com.example.vocabularyproject.chap01.word_fragment5;
import com.example.vocabularyproject.chap01.word_fragment6;
import com.example.vocabularyproject.chap01.word_fragment7;
import com.example.vocabularyproject.chap01.word_fragment8;
import com.example.vocabularyproject.chap01.word_fragment9;

import java.util.ArrayList;

public class pager_adapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mData;

    public pager_adapter(@NonNull FragmentManager fm) {
        super(fm);
        mData = new ArrayList<>();
        mData.add(new word_fragment1());
        mData.add(new word_fragment2());
        mData.add(new word_fragment3());
        mData.add(new word_fragment4());
        mData.add(new word_fragment5());
        mData.add(new word_fragment6());
        mData.add(new word_fragment7());
        mData.add(new word_fragment8());
        mData.add(new word_fragment9());
        mData.add(new word_fragment10());
        mData.add(new word_fragment11());
        mData.add(new word_fragment12());
        mData.add(new word_fragment13());
        mData.add(new word_fragment14());
        mData.add(new word_fragment15());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
