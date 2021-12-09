package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class privateWordStudyView extends AppCompatActivity {
    ListView listview;
    ArrayList<pW> arr;
    privateWordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_word_study_view);

        arr = new ArrayList<>();
        String filename = "add.txt";

        File file = new File(getFilesDir(), filename);
        if (file.exists() == false)
            return;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String tmp[];
            String t, e, m, p;
            while ((line = reader.readLine()) != "null") {
                tmp =line.split(":");
                t = tmp[0]; e = tmp[1]; m = tmp[2]; p = tmp[3];
                arr.add(new pW(t, e, m, p));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter = new privateWordAdapter(arr);
        listview = (ListView)findViewById(R.id.word_list);
        listview.setAdapter(adapter);


     }

}