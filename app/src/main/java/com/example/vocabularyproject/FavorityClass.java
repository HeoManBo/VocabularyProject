package com.example.vocabularyproject;

//즐겨찾기 단어를 올리기 위한 클래스 생성

public class FavorityClass {
    private String word;
    private String mean;

    public FavorityClass(String word, String mean){
        this.word = word;
        this.mean = mean;
    }

    public String getWord(){
        return word;
    }

    public String getMean(){
        return mean;
    }
}
