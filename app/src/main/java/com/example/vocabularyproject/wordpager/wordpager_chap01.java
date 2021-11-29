package com.example.vocabularyproject.wordpager;

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
import com.example.vocabularyproject.wordpager.MystateAdapter;

//Chapter를 Viewpager 방식으로 보여줌

public class wordpager_chap01 extends AppCompatActivity {
    private FileSplit fs;

    public myFavorityDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
//      chap activity에서 chapter 선택시 가져올 word.text 가져올 때 사용
//      Intent intent = getIntent();
//      intent.getBundleExtra("word");

        fs = new FileSplit(R.raw.chap01); //test데이터를 읽어옴

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        MystateAdapter adapter = new MystateAdapter(this);


        DB = new myFavorityDB(this);
        SQLiteDatabase db = DB.getWritableDatabase();


        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.voca);
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);

    }

}