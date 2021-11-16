package com.example.vocabularyproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import android.speech.tts.TextToSpeech;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import android.os.Build;
import static android.speech.tts.TextToSpeech.ERROR;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link word_fragment1#} factory method to
 * create an instance of this fragment.
 */
public class word_fragment1 extends Fragment {
    ViewGroup viewGroup;
    TextView word, mean, Example;
    TextToSpeech tts;
    Button speak;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_word1, container, false);
        word = viewGroup.findViewById(R.id.Word);
        mean = viewGroup.findViewById(R.id.mean);
        Example = viewGroup.findViewById(R.id.Example);
        speak = (Button) viewGroup.findViewById(R.id.sound);
        speak.setEnabled(false);
        speak.setOnClickListener(this);
        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        ArrayList<String[]> arr = (ArrayList<String[]>) bundle.getSerializable("word");
        word.setText(arr.get(0)[1]);
        mean.setText(arr.get(0)[2]);
        Example.setText(arr.get(0)[3]);

        tts = new TextToSpeech(this, this);


        speak.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                CharSequence text = arr.get(0)[1];
                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "word1");
            }
        });

        return viewGroup;
    }
}