package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;

public class lock_screen extends AppCompatActivity {
    FileSplit fs;
    SharedPreferences spref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lock_screen);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        spref = getSharedPreferences("save", Context.MODE_PRIVATE);

        switch(spref.getInt("index",0)+1) {
            case 1:
                fs = new FileSplit(1);
                break;
            case 2:
                fs = new FileSplit(2);
                break;
            case 3:
                fs = new FileSplit(3);
                break;
            case 4:
                fs = new FileSplit(4);
                break;
            case 5:
                fs = new FileSplit(5);
                break;
            case 6:
                fs = new FileSplit(6);
                break;
            case 7:
                fs = new FileSplit(7);
                break;
            case 8:
                fs = new FileSplit(8);
                break;
            case 9:
                fs = new FileSplit(9);
                break;
            case 10:
                fs = new FileSplit(10);
                break;
        }

         //test데이터를 읽어옴

        ViewPager2 viewPager = findViewById(R.id.pager); //ViewPager를 얻음
        com.example.vocabularyproject.lock_screen_pager.lock_screen_adapter adapter = new com.example.vocabularyproject.lock_screen_pager.lock_screen_adapter(this); //ViewPager Adapter 생성

        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",fs.getVoca());
        adapter.putWord(bundle);

        viewPager.setAdapter(adapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);
    }
}