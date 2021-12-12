package com.example.vocabularyproject.TestView.fragment01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vocabularyproject.R;

import java.util.ArrayList;
import java.util.Locale;

public class test_fragment03 extends Fragment {
    String arr[];
    String koreaSplit[] = null;
    String split, tmp;
    EditText inputAnswer;
    TextView problem;
    TextView answer;
    Button btn;
    int count =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_test_fragment01, container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        inputAnswer = view.findViewById(R.id.input);
        problem = view.findViewById(R.id.word_test);
        answer = view.findViewById(R.id.answer);
        btn = view.findViewById(R.id.answer_btn);

        Bundle bundle = getArguments(); //ViewPager가 전달한 Bundle 인자 수신
        arr = (String[]) bundle.getStringArray("word2");
        split = arr[2];

        for(int i=0; i<split.length(); i++){ //문제가 한국어로 들어온 경우
            if(split.charAt(i) == ')'){
                koreaSplit = split.split("[)]");
                tmp = koreaSplit[1]; //,으로 구분된 정답들
            }
        }

        if(koreaSplit != null) {
            koreaSplit = tmp.split(",");
            for (int i = 0; i < koreaSplit.length; i++) {
                koreaSplit[i] = koreaSplit[i].trim();
            }
        }

        problem.setText(arr[1]);
        answer.setVisibility(View.INVISIBLE);
        answer.setText(arr[2]);

        btn.setOnClickListener(new View.OnClickListener() {
            int i;
            @Override
            public void onClick(View view) {
                String myanswer = inputAnswer.getText().toString().toLowerCase(Locale.ROOT);
                if (koreaSplit != null) { //문제가 영어로 나온 경우
                    for (i = 0; i < koreaSplit.length; i++) {
                        if (koreaSplit[i].equals(myanswer)) { //문제를 맞췄을 때
                            answer.setVisibility(View.VISIBLE);
                            answer.setText("전체 답은 : " + tmp);
                            Toast.makeText(getActivity(), "정답입니다!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        if (i == koreaSplit.length - 1 && !(koreaSplit[i].equals(myanswer))) { //첫 오답을 입력한 경우
                            Toast toast = Toast.makeText(getActivity(), "다시 한번 생각해보세요!", Toast.LENGTH_SHORT);
                            toast.show();
                            count++;
                            continue;
                        }
                        if (count == 2) { //두번 오답을 입력한 경우
                            Toast.makeText(getActivity(), "오답입니다.", Toast.LENGTH_SHORT).show();
                            answer.setVisibility(View.VISIBLE);
                            count = 0;
                            break;
                        }
                    }
                } else if (myanswer.trim().equals(arr[2])) { //한국어로 제시된 문제를 맞췄을때
                    Toast toast = Toast.makeText(getActivity(), "정답입니다!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (!myanswer.trim().equals(arr[2])) {
                    if (count == 0) { //첫 오답을 입력한 경우
                        Toast toast = Toast.makeText(getActivity(), "다시한번 생각해보세요!", Toast.LENGTH_SHORT);
                        toast.show();
                        count++;
                    } else { //두번째 오답을 입력한 경우
                        Toast toast = Toast.makeText(getActivity(), "오답입니다!", Toast.LENGTH_SHORT);
                        toast.show();
                        answer.setVisibility(View.VISIBLE);
                        count = 0;
                    }
                }
            }
        });
    }

}