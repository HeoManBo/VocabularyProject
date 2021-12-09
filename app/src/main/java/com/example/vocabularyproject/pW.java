package com.example.vocabularyproject;


public class pW {
    private String word;
    private String mean;
    private String ex;
    private String exMean;

    public pW(String word, String mean, String ex, String exMean) {
        this.word = word;
        this.mean = mean;
        this.ex = ex;
        this.exMean = exMean;
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

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getExMean() {
        return exMean;
    }

    public void setExMean(String exMean) {
        this.exMean = exMean;
    }
}
