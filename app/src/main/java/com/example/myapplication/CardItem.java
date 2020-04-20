package com.example.myapplication;

public class CardItem {
   // private int mImageResource;
    private String text;

    public CardItem( String text){
        //this.mImageResource=mImageResource;
        this.text=text;
    }

//    public int getmImageResource() {
//        return mImageResource;
//    }

    public String getText() {
        return text;
    }

    public void changeText(String text){
        this.text=text;
    }
}
