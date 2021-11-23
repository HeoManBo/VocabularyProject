package com.example.vocabularyproject;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//즐겨찾기를 위한 DB생성
public class myFavorityDB extends SQLiteOpenHelper {

    static String DBname = "word_Table";

    public myFavorityDB(Context context){
        super(context,DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){ //아예 db가 새로 만들어지는 경우
        String query = "create table word_Table(_id integer primary key autoincrement,word String,word_class String)";
        db.execSQL(query); //처음 실행시
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion == newVersion) {
            String query = "DROP TABLE wordDB";
            db.execSQL(query);
            onCreate(db);
        }
    }
}
