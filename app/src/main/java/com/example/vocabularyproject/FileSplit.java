package com.example.vocabularyproject;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* RAW에 있는 WORD 파일을 읽어서 저장하는 함수
   RAW파일안에는 한 줄당 : 토큰 단위로 단어,뜻,예문이 분리되어 있음   */
public class FileSplit implements Serializable {

    public ArrayList<String[]> voca = new ArrayList<String[]>(); //text에 있는 문장을 한줄 단위로 받을 리스트

    public FileSplit(int FileID) {
        InputStream inputS = word_pager.mContext.getResources().openRawResource(FileID); //Raw파일에 있는 fileID를 얻음
        try{
            byte data[] = new byte[inputS.available()]; //byte화 된 string을 string으로 바꾸는 작업
            inputS.read(data);
            inputS.close();
            String str = new String(data,"UTF-8");
            MakeArray(str); //String 으로 만든 txt파일을 정한 형식으로 저장함
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void MakeArray(String str){
        String tmp[] = str.split("\n"); //enter단위로 문장을 쪼개어 저장
        String s;
        for(int i=0; i<tmp.length; i++){
            s = tmp[i]; //한 문장을
            String tmp2[] = s.split(":"); //:단위로 쪼갠 string을
            voca.add(tmp2); //리스트에 저장함
        }
    }
}