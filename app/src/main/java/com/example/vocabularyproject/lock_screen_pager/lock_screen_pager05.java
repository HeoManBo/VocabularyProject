package com.example.vocabularyproject.lock_screen_pager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;
import com.example.vocabularyproject.myFavorityDB;
import com.example.vocabularyproject.wordpager.MystateAdapter;

public class lock_screen_pager05 extends AppCompatActivity {
    private FileSplit fs;

    public myFavorityDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock_screen);


        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        lock_screen_adapter adapter = new lock_screen_adapter(this);


        DB = new myFavorityDB(this);
        SQLiteDatabase db = DB.getWritableDatabase();


        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.voca);
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);

    }

}
