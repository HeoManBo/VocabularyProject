package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class FavorityWord extends AppCompatActivity {

    FavorityListiewAdapter adapter;
    ItemTouchHelper helper;
    static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favority_word);
        mContext = this;

        adapter = new FavorityListiewAdapter();
        getData_db();

        RecyclerView recyclerView = findViewById(R.id.favority_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        helper = new ItemTouchHelper(new ItemTouchHelperCallback(adapter));
        helper.attachToRecyclerView(recyclerView);

        myFavorityDB DB = new myFavorityDB(this);

    }


    protected void getData_db(){
        //DB와 읽기모드를 가져와 사용준비
        myFavorityDB DB = new myFavorityDB(this);
        SQLiteDatabase database = DB.getReadableDatabase();

        //Cusor를 이용해 데이터 탐색
        Cursor cursor = database.rawQuery("select word, word_class from word_Table order by _id desc", null);

        while(cursor.moveToNext()){
            adapter.addItem(new FavorityClass(cursor.getString(0),cursor.getString(1)));
        }

    }

}