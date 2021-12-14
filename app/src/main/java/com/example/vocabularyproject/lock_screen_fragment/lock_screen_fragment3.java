package com.example.vocabularyproject.lock_screen_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vocabularyproject.R;

import java.util.ArrayList;


public class lock_screen_fragment3 extends Fragment {
    TextView word,mean,Example,sentence;
    ArrayList<String[]> arr;
    SharedPreferences shpref;

    float size = 20.0F;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lock_screen_fragment3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        word = view.findViewById(R.id.Word);
        mean = view.findViewById(R.id.mean);
        Example = view.findViewById(R.id.Example);


        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        arr = (ArrayList<String[]>) bundle.getSerializable("word");
        word.setText(arr.get(2)[1]);
        mean.setText(arr.get(2)[2]);
        Example.setText(arr.get(2)[3]);

        sentence = view.findViewById(R.id.sentence);
        sentence.setText(arr.get(2)[4]);

        shpref = getActivity().getSharedPreferences("text_size", Context.MODE_PRIVATE);
        size = shpref.getFloat("textsize",20.0F);
        word.setTextSize(size);
        mean.setTextSize(size);
        Example.setTextSize(size);
        sentence.setTextSize(size);
    }
}