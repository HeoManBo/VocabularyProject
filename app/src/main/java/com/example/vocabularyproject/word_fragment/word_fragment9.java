package com.example.vocabularyproject.word_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.vocabularyproject.FavorityWord;
import com.example.vocabularyproject.R;
import com.example.vocabularyproject.myFavorityDB;

import java.util.Locale;

public class word_fragment9 extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener {
    ViewGroup viewGroup;
    TextView word, mean, Example,sentence;
    Button speak;
    TextToSpeech tts;
    String text;
    Button star;

    myFavorityDB favorityDB;
    ArrayList<String[]> arr;
    Cursor cursor;

    String dbFilename = "word_Table";
    boolean i = false;
    boolean on_off;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_word9, container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        word = view.findViewById(R.id.Word);
        mean = view.findViewById(R.id.mean);
        Example = view.findViewById(R.id.Example);
        speak = (Button) view.findViewById(R.id.sound);
        star = view.findViewById(R.id.star09);
        star.setOnClickListener(this);

        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        arr = (ArrayList<String[]>) bundle.getSerializable("word");
        word.setText(arr.get(8)[1]);
        mean.setText(arr.get(8)[2]);
        Example.setText(arr.get(8)[3]);

        //버튼의 상태를 가져오는 함수
        btn_load();

        sentence = view.findViewById(R.id.sentence);
        sentence.setText(arr.get(8)[4]);


        speak.setEnabled(false);
        speak.setOnClickListener(this);

        text = arr.get(0)[1];
        tts = new TextToSpeech(getActivity(), this);

    }

    private void Speak() {
        tts.setPitch(1.0f);
        tts.setSpeechRate(1.0f);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int language = tts.setLanguage(Locale.ENGLISH);
            if (language == TextToSpeech.LANG_NOT_SUPPORTED || language == TextToSpeech.LANG_MISSING_DATA) {
                speak.setEnabled(false);
            }
            else {
                speak.setEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(view == speak) {
            Speak();

        }
        else if(view == star){
            myFavorityDB DB = new myFavorityDB(getActivity());
            SQLiteDatabase sqLiteDatabase = DB.getWritableDatabase();
            if(i == false){
                i = true;
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_on_normal));
                Toast.makeText(getActivity(),"단어 추가 완료!",Toast.LENGTH_SHORT).show();
                sqLiteDatabase.execSQL("insert into word_Table (word,word_class) values (?,?)", new String[]{arr.get(8)[1],arr.get(8)[2]});
            }
            else{
                i = false;
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_off_normal));
                Toast.makeText(getActivity(),"단어 삭제 완료!",Toast.LENGTH_SHORT).show();
                favorityDB = new myFavorityDB(getActivity());
                favorityDB.Delete(arr.get(8)[1]);
            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }

    public void btn_load(){
        myFavorityDB DB = new myFavorityDB(getActivity());
        if(DB.isIn(arr.get(8)[1])){
            star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_on_normal));
            i = true;
        }
        else{
            star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_off_normal));
            i = false;
        }
    }
}