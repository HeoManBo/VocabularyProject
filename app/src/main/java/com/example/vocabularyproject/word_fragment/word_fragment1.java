package com.example.vocabularyproject.word_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

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

public class word_fragment1 extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener {
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

    private SharedPreferences appData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_word1,container,false);
        word = viewGroup.findViewById(R.id.Word);
        mean = viewGroup.findViewById(R.id.mean);
        Example = viewGroup.findViewById(R.id.Example);
        speak = (Button) viewGroup.findViewById(R.id.sound);
        star = viewGroup.findViewById(R.id.star01);
        star.setOnClickListener(this);

        appData = getActivity().getSharedPreferences("appdata", Context.MODE_PRIVATE);
        btn_load();

        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        arr = (ArrayList<String[]>) bundle.getSerializable("word");
        word.setText(arr.get(0)[1]);
        mean.setText(arr.get(0)[2]);
        Example.setText(arr.get(0)[3]);

        sentence = viewGroup.findViewById(R.id.sentence);
        sentence.setText(arr.get(0)[4]);


        speak.setEnabled(false);
        speak.setOnClickListener(this);

        text = arr.get(0)[1];
        tts = new TextToSpeech(getActivity(), this);

        return viewGroup;
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
                btn_save();
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_on_normal));
                Toast.makeText(getActivity(),"단어 추가 완료!",Toast.LENGTH_SHORT).show();
                sqLiteDatabase.execSQL("insert into word_Table (word,word_class) values (?,?)", new String[]{arr.get(0)[1],arr.get(0)[2]});
            }
            else{
                i = false;
                btn_delete();
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_off_normal));
                Toast.makeText(getActivity(),"단어 삭제 완료!",Toast.LENGTH_SHORT).show();
                favorityDB = new myFavorityDB(getActivity());
                favorityDB.Delete(arr.get(0)[1]);
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

    public void btn_save(){ 
        SharedPreferences.Editor editor = appData.edit();
        editor.putBoolean("on_off", i);
        editor.apply();
    }

    public void btn_load(){
        if(appData != null) {
            i = appData.getBoolean("on_off", false);
            if(i == true) {
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_on_normal));
            }
            else{
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.btn_star_off_normal));
            }
        }
    }

    public void btn_delete(){
        SharedPreferences.Editor editor = appData.edit();
        editor.remove("on_off");
        editor.apply();
    }

}