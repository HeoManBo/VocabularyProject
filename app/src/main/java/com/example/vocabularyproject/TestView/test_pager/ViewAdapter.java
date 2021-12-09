package com.example.vocabularyproject.TestView.test_pager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Collections;

public class ViewAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;

    public ViewAdapter(FragmentActivity fa){
        super(fa);
        fragments = new ArrayList<>();
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment01());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment02());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment03());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment04());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment05());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment06());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment07());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment08());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment09());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment10());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment11());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment12());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment13());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment14());
        fragments.add(new com.example.vocabularyproject.TestView.fragment01.test_fragment15());
    }

    public void putWord(Bundle bundle){
        ArrayList<String[]> split = (ArrayList<String[]>)bundle.getSerializable("word");
        for(int i=0; i<15; i++) {
            bundle.putStringArray("word"+i, split.get(i));
        }
        for(int i=0; i<15; i++) {
            fragments.get(i).setArguments(bundle);
        }
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
