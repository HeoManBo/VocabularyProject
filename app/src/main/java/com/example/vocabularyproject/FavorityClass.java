package com.example.vocabularyproject;

//즐겨찾기 단어를 올리기 위한 클래스 생성

public class FavorityClass {
    private String word; //단어
    private String mean; //품사
    private String split; //뜻

    public FavorityClass(String word, String mean){
        this.word = word;
        String[] split = mean.split("[)]");
        this.mean = split[0];
        this.split = split[1];
    }

    public String getWord(){
        return word;
    }

    public String getMean(){
        return mean;
    }

    public String getSplit() {return split;}
}
