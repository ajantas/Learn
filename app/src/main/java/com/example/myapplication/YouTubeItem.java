package com.example.myapplication;

public class YouTubeItem {
    private int intentId;
    private String label;

    public YouTubeItem(int intentId, String label ){
        this.intentId = intentId;
        this.label = label;
    }

    public int getIntentId(){
        return intentId;
    }
    public void setIntentId(int intentId){
        this.intentId = intentId;
    }
    public String getLabel(){
        return label;
    }
    public void setLabel(String label){
        this.label = label;
    }
}
