package com.example.vocabularyproject.lock_screen_fragment;

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

public class lock_screen_fragment9 extends Fragment {

    TextView word,mean,Example;
    ArrayList<String[]> arr;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lock_screen_fragment9, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        word = view.findViewById(R.id.Word);
        mean = view.findViewById(R.id.mean);
        Example = view.findViewById(R.id.Example);


        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        arr = (ArrayList<String[]>) bundle.getSerializable("word");
        word.setText(arr.get(8)[1]);
        mean.setText(arr.get(8)[2]);
        Example.setText(arr.get(8)[3]);
    }
}