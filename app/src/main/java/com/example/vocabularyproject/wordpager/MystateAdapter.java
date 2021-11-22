package com.example.vocabularyproject.wordpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MystateAdapter extends FragmentStateAdapter { //Viewpager를 연결해주는 fragement adapter
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
