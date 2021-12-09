package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class settingView extends AppCompatActivity {

    SharedPreferences spref;
    SharedPreferences.Editor editor;
    TextView select;
    Spinner spinner;
    Switch lock_scr;
    String[] items = {"CHAP01","CHAP02","CHAP03","CHAP04","CHAP05","CHAP06","CHAP07","CHAP08","CHAP09","CHAP10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_view);
        //view 객체 획득
        lock_scr=(Switch)findViewById(R.id.lock_scr);
        spinner=(Spinner)findViewById(R.id.spinner);
        select = findViewById(R.id.select);

        spref = getSharedPreferences("save", Context.MODE_PRIVATE);
        editor=spref.edit();
        lock_scr.setChecked(spref.getBoolean("value",false));
        select.setText(items[spref.getInt("index",0)]);
        if(spref.getBoolean("vis",true))
            spinner.setVisibility(View.VISIBLE);
        else
            spinner.setVisibility(View.INVISIBLE);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(spref.getInt("index",0));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select.setText(items[i]);
                editor.putInt("index",i);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                select.setText("선택: ");

            }
        });
        //switch 이벤트 함수
        lock_scr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckState();
            }
        });

    }
    private void CheckState(){
        if(lock_scr.isChecked()) {
            editor.putBoolean("value",true);
            editor.putBoolean("vis",true);
            editor.apply();
            spinner.setVisibility(View.VISIBLE);
            Intent intent = new Intent(getApplicationContext(), lock_screen_service.class);
            startService(intent);

        }
        else{
            editor.putBoolean("value",false);
            editor.putBoolean("vis",false);
            editor.apply();
            spinner.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(getApplicationContext(), lock_screen_service.class);
            stopService(intent);

        }
    }


}