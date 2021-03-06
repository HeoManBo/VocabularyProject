package com.example.vocabularyproject.lock_screen_pager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.vocabularyproject.FavorityWord;
import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;
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

import java.util.ArrayList;
import com.example.vocabularyproject.myFavorityDB;
import com.example.vocabularyproject.lock_screen_pager.lock_screen_adapter;


public class lock_screen_pager01 extends AppCompatActivity {
    private FileSplit fs;

    public myFavorityDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock_screen);

        fs = new FileSplit(R.raw.chap01); //test???????????? ?????????

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager??? ??????
        lock_screen_adapter adapter = new lock_screen_adapter(this);


        DB = new myFavorityDB(this);
        SQLiteDatabase db = DB.getWritableDatabase();


        Bundle bundle = new Bundle(); //voca List ??????
        bundle.putSerializable("word",fs.voca);
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter ??????
        viewPager.setOffscreenPageLimit(15);

    }

}

