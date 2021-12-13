package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class privateWordAdd extends AppCompatActivity {

    String word;
    String mean;
    String pos;

    EditText addWord;
    EditText addMean;
    EditText addPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_word_add);
        Button add = findViewById(R.id.add);

        addWord = (EditText)findViewById(R.id.word);
        addMean = (EditText)findViewById(R.id.mean);
        addPos = (EditText)findViewById(R.id.pos);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = 0;
                String filename = "add.txt";
                File file = new File(getFilesDir(), filename);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.readLine() != null)
                        num++;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                word = addWord.getText().toString();
                mean = addMean.getText().toString();
                pos = addPos.getText().toString();

                if (iSNE(word) && iSNE(mean) && iSNE(pos)) {
                    FileWriter writer;
                    try {
                        writer = new FileWriter(file, true);
                        writer.write(word + ":" + pos + ":" + mean + ":" + num + "\n");
                        writer.flush();
                        writer.close();
                        Toast.makeText(getApplicationContext(), "추가가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "모두 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    static boolean iSNE(String str) { // isStringNotEmpty
        return !(str == null || str.isEmpty());
    }
}