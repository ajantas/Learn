package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChapterChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_choose);
        Button buttonOne = (Button) findViewById(R.id.chapter1);
        buttonOne.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View v) {
                   chooseSubject();
                }
            });


    }
    private void chooseSubject() {
            Intent intent = new Intent(this, VideoActivity.class);
            startActivityForResult(intent, 0);
    }
}
