package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class privateWordAdd extends AppCompatActivity {

    String word;
    String mean;
    String pos;
    String ex;
    String exMean;

    EditText addWord;
    EditText addMean;
    EditText addPos;
    EditText addEx;
    EditText addExMean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_word_add);
        Button add = findViewById(R.id.add);


        addWord = (EditText)findViewById(R.id.word);
        addMean = (EditText)findViewById(R.id.mean);
        addPos = (EditText)findViewById(R.id.pos);
        addEx = (EditText)findViewById(R.id.ex);
        addExMean = (EditText)findViewById(R.id.exMean);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String filename = "add.txt";
                int test = 0;
                File file = new File(getFilesDir(), filename);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    while (reader.readLine() != null)
                        test++;
                } catch (IOException e) {
                    e.printStackTrace();
                }



                word = addWord.getText().toString();
                mean = addMean.getText().toString();
                pos = addPos.getText().toString();
                ex = addEx.getText().toString();
                exMean = addExMean.getText().toString();

                if (test < 15) { // 개인단어 제한 15개
                    if (iSNE(word) && iSNE(mean) && iSNE(pos) && iSNE(ex) && iSNE(exMean)) {
                        FileWriter writer;
                        try {
                            writer = new FileWriter(file, true);
                            writer.write(word + ":" + pos + ")" + mean + ":" + ex + ":" + exMean + "\n");
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
                else
                    Toast.makeText(getApplicationContext(), "단어의 최대 개수를 초과했습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    static boolean iSNE(String str) { // isStringNotEmpty
        return !(str == null || str.isEmpty());
    }
}