package com.example.olgakuklina.BuildItBigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String guitarJoke;

    public String getData() {
        return guitarJoke;
    }

    public void setData(String data) {
        guitarJoke = data;
    }
}