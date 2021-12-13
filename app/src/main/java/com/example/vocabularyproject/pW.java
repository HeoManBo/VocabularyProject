package com.example.vocabularyproject;


import android.graphics.drawable.Drawable;

public class pW {
    private String word;
    private String pos;
    private String mean;

    public pW(String word, String pos, String mean) {
        this.word = word;
        this.pos = pos;
        this.mean = mean;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
