package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class FavorityWord extends AppCompatActivity {
    private static ArrayList<String[] > favorityWord = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favority_word);
    }


    public void addWord(String[] str){ //즐겨찾기 단어 추가
        favorityWord.add(str);
    }

    public void deleteWord(String[] str){ //즐겨찾기 단어 삭제
        for(int i = 0; i<favorityWord.size(); i++){
            if(favorityWord.get(i)[1] == str[0]){
                favorityWord.remove(i);
            }
        }
    }
}