package com.example.vocabularyproject.lock_screen_pager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class lock_screen_adapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragments;

    public lock_screen_adapter(FragmentActivity fa){
        super(fa);
        fragments = new ArrayList<>();
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment1());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment2());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment3());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment4());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment5());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment6());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment7());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment8());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment9());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment10());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment11());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment12());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment13());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment14());
        fragments.add(new com.example.vocabularyproject.lock_screen_fragment.lock_screen_fragment15());
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
