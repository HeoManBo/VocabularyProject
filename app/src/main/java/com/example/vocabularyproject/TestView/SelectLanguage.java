package com.example.vocabularyproject.TestView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vocabularyproject.FileSplit;
import com.example.vocabularyproject.R;

import java.util.ArrayList;
import java.util.Iterator;

public class SelectLanguage extends AppCompatActivity {

    Intent intent;
    String str;
    FileSplit fs;
    int Chap;
    ArrayList<String[]> arr;
    ComponentName cmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        intent = getIntent();
        Chap = intent.getIntExtra("whatChap", 0);
        if(Chap == 0){
            finish();
        }

    }


    public void onClick(View view){
        Intent intent = new Intent();
        String tmp[];
        String str;
        switch (view.getId()){
            case R.id.btn_English:
                fs = new FileSplit(Chap);
                arr = fs.getVoca();
                intent = new Intent();
                cmp = new ComponentName(this,"com.example.vocabularyproject.TestView.test_pager.test_pager" + 1);
                intent.putExtra("word", arr);
                intent.setComponent(cmp);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                break;
            case R.id.btn_Korea:
                fs = new FileSplit(Chap);
                arr = fs.getVoca();
                for(int i=0; i<15; i++){ //뜻이 젤 위로 위치해 있게 설정
                    tmp = arr.get(i);
                    str = tmp[1];
                    tmp[1] = tmp[2];
                    tmp[2] = str;
                    arr.set(i,tmp);
                }
                intent = new Intent();
                intent.putExtra("word", arr);
                cmp = new ComponentName(this,"com.example.vocabularyproject.TestView.test_pager.test_pager" + 1);
                intent.setComponent(cmp);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        //스크린에서 사라지면 액티비티 삭제
        finish();
    }

}