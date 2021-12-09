package com.example.vocabularyproject;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//즐겨찾기를 위한 DB생성
public class myFavorityDB extends SQLiteOpenHelper {

    final SQLiteDatabase db = getWritableDatabase();
    static final String DBname = "word_Table"; //DB이름
    Cursor cursor;

    //myFavorityDB 생성자
    public myFavorityDB(Context context){

        super(context,DBname,null,1);
    }

    //Word_table 생성
    @Override
    public void onCreate(SQLiteDatabase db){ //아예 db가 새로 만들어지는 경우
        String query = "create table word_Table(_id integer primary key autoincrement,word String,word_class String)";
        db.execSQL(query); //처음 실행시
    }

    //업데이트
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion == newVersion) {
            String query = "DROP TABLE wordDB";
            db.execSQL(query);
            onCreate(db);
        }
    }

    //word_table 단어 추가
    public void insert(String word,String mean){
        db.execSQL("insert into word_Table (word,word_class) values (?,?)", new String[]{word,mean});
        db.close();
    }

    //삭제 메서드
    public void Delete(String word){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("word_Table","word = ?",new String[]{word});
        db.close();
    }

    //해당 단어가 DB에 있는지 확인하는 메소드
    public boolean isIn(String word) {
        SQLiteDatabase database = getReadableDatabase();
        cursor = database.rawQuery("select word from word_Table order by _id desc limit 1", null);
        while (cursor.moveToNext()) {
            if (cursor.getString(0).equals(word)) {
                return true;
            }
        }
        return false;
    }

}
