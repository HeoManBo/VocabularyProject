package com.example.vocabularyproject.word_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import android.speech.tts.TextToSpeech;
import android.widget.Button;

import com.example.vocabularyproject.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link word_fragment1#} factory method to
 * create an instance of this fragment.
 */
public class word_fragment9 extends Fragment implements View.OnClickListener, TextToSpeech.OnInitListener {
    ViewGroup viewGroup;
    TextView word, mean, Example,sentence;
    Button speak;
    TextToSpeech tts;
    String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_word1,container,false);
        word = viewGroup.findViewById(R.id.Word);
        mean = viewGroup.findViewById(R.id.mean);
        Example = viewGroup.findViewById(R.id.Example);
        speak = (Button) viewGroup.findViewById(R.id.sound);
        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        ArrayList<String[]> arr = (ArrayList<String[]>) bundle.getSerializable("word");
        word.setText(arr.get(8)[1]);
        mean.setText(arr.get(8)[2]);
        Example.setText(arr.get(8)[3]);

        sentence = viewGroup.findViewById(R.id.sentence);
        sentence.setText(arr.get(8)[4]);

        speak.setEnabled(false);
        speak.setOnClickListener(this);
        text = arr.get(8)[1];

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
        switch (view.getId()) {
            case R.id.sound :
                Speak();
                break;

            default:
                break;
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

}