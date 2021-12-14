package com.example.vocabularyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class settingView extends AppCompatActivity {

    SharedPreferences spref, size_spref;
    SharedPreferences.Editor editor;
    TextView select;
    Spinner spinner, size_spinner;
    Switch lock_scr;
    String[] items = {"CHAP01","CHAP02","CHAP03","CHAP04","CHAP05","CHAP06","CHAP07","CHAP08","CHAP09","CHAP10"};
    float[] size_items = {20.0F, 40.0F,60.0F};
    RadioGroup text_size;
    RadioButton small,mid,big;
    static float textSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_view);
        //view 객체 획득
        lock_scr=(Switch)findViewById(R.id.lock_scr);
        spinner=(Spinner)findViewById(R.id.spinner);
        select = findViewById(R.id.select);

        text_size = findViewById(R.id.text_sizeGruop);
        small = findViewById(R.id.text_small);
        mid = findViewById(R.id.text_mid);
        big = findViewById(R.id.text_big);
        //라디오가 마지막으로 선택된 값으로 세팅
        small.setChecked(UpdateState("small"));
        mid.setChecked(UpdateState("mid"));
        big.setChecked(UpdateState("big"));


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
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
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

        text_size.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.text_small){
                    setTextSize(20.0F);
                    radio_BtnSizesave("textsize",18.0F);
                    radio_BtnStateSave("small",true);
                    radio_BtnStateSave("mid",false);
                    radio_BtnStateSave("big",false);
                }
                else if(i == R.id.text_mid){
                    setTextSize(40.0F);
                    radio_BtnSizesave("textsize",20.0F);
                    radio_BtnStateSave("mid",true);
                    radio_BtnStateSave("small",false);
                    radio_BtnStateSave("big",false);
                }
                else if(i == R.id.text_big){
                    setTextSize(60.0F);
                    radio_BtnSizesave("textsize",22.0F);
                    radio_BtnStateSave("big",true);
                    radio_BtnStateSave("small",false);
                    radio_BtnStateSave("mid",false);
                }
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

    private void radio_BtnStateSave(String key, boolean value){
        SharedPreferences sharedPreferences = getSharedPreferences("radio_state",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private Boolean UpdateState(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("radio_state",MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    private void radio_BtnSizesave(String key, float value){
        SharedPreferences sharedPreferences = getSharedPreferences("text_size",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key,value);
        editor.apply();
    }

    void setTextSize(float size){
        textSize = size;
    }


}