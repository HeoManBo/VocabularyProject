package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
//dsadsa
public class privateWordAdd extends AppCompatActivity {

    String word; // EditText의 값을 저장할 변수
    String mean;
    String pos;

    EditText addWord; // 추가할 단어들이 입력되는 EditText
    EditText addMean;
    EditText addPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_word_add);
        Button add = findViewById(R.id.add); // 추가 버튼

        addWord = (EditText)findViewById(R.id.word);
        addMean = (EditText)findViewById(R.id.mean);
        addPos = (EditText)findViewById(R.id.pos);

        add.setOnClickListener(new View.OnClickListener() { // '추가하기' 버튼을 눌렀을 경우
            @Override
            public void onClick(View view) {
                String filename = "add.txt";
                File file = new File(getFilesDir(), filename); // SQL이 아닌, 내부 저장소 파일 읽고 쓰기를 사용하여 프로그램을 작성해보았다.

                word = addWord.getText().toString(); // EditText 안의 값을 불러옴
                mean = addMean.getText().toString();
                pos = addPos.getText().toString();

                if (iSNE(word) && iSNE(mean) && iSNE(pos)) { // 모든 입력 칸이 채워졌을 경우
                    FileWriter writer;
                    try {
                        writer = new FileWriter(file, true);
                        writer.write(word + ":" + pos + ":" + mean + "\n"); // 내부 저장소 파일에 구분자 :를 기준으로 데이터 저장.
                        writer.flush();
                        writer.close();
                        Toast.makeText(getApplicationContext(), "추가가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                        finish(); // 액티비티 종료.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else { // EditText에 빈 칸이 있을 경우
                    Toast.makeText(getApplicationContext(), "모두 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    static boolean iSNE(String str) {
        return !(str == null || str.isEmpty());
    } // is String Not Empty
}