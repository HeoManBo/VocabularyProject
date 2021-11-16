package com.example.vocabularyproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link word_fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class word_fragment3 extends Fragment {

        ViewGroup viewGroup;
        TextView word, mean, Example;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_word1,container,false);
            word = viewGroup.findViewById(R.id.Word);
            mean = viewGroup.findViewById(R.id.mean);
            Example = viewGroup.findViewById(R.id.Example);
            Bundle bundle = getArguments();
            ArrayList<String[]> arr = (ArrayList<String[]>) bundle.getSerializable("word");
            word.setText(arr.get(2)[1]);
            mean.setText(arr.get(2)[2]);
            Example.setText(arr.get(2)[3]);


            return viewGroup;
        }
}