package com.example.vocabularyproject.TestView.test_pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.example.vocabularyproject.R;

public class test_pager1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_pager1);

        Intent intent = getIntent();

        ViewPager2 viewPager = findViewById(R.id.pager_test);
        ViewAdapter viewAdapter = new ViewAdapter(this);

        Bundle bundle = new Bundle(); //voca List 전달
        bundle.putSerializable("word",intent.getSerializableExtra("word"));

        viewAdapter.putWord(bundle);

        viewPager.setAdapter(viewAdapter); //Adapter 설정
        viewPager.setOffscreenPageLimit(15);
    }
}