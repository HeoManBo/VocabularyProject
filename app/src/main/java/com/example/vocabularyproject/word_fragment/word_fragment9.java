package com.example.vocabularyproject.word_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import com.example.vocabularyproject.R;
import com.example.vocabularyproject.myFavorityDB;

import java.util.Locale;

public class word_fragment9 extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener {
    TextView word, mean, Example,sentence;
    TextToSpeech tts;
    String text;
    ImageButton star, speak;

    myFavorityDB favorityDB;
    ArrayList<String[]> arr;

    boolean i = false;
    float size = 20.0F;
    float speed = 1.5F;
    SharedPreferences shpref;

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
        speak = view.findViewById(R.id.sound);
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

        //글자 크기 조절하는 기능
        shpref = getActivity().getSharedPreferences("text_size",Context.MODE_PRIVATE);
        size = shpref.getFloat("textsize",20.0F);
        speed = shpref.getFloat("soundSpeed", 1.5F);
        word.setTextSize(size);
        mean.setTextSize(size);
        Example.setTextSize(size);
        sentence.setTextSize(size);


        speak.setEnabled(false);
        speak.setOnClickListener(this);

        text = arr.get(8)[1];
        tts = new TextToSpeech(getActivity(), this);

    }

    private void Speak() {
        tts.setPitch(speed);
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
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.on));
                Toast.makeText(getActivity(),"단어 추가 완료!",Toast.LENGTH_SHORT).show();
                sqLiteDatabase.execSQL("insert into word_Table (word,word_class) values (?,?)", new String[]{arr.get(8)[1],arr.get(8)[2]});
            }
            else{
                i = false;
                star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.off));
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
            star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.on));
            i = true;
        }
        else{
            star.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.off));
            i = false;
        }
    }
}