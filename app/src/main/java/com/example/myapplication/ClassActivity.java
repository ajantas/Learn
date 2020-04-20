package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        Button buttonOne = (Button) findViewById(R.id.button1);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonTwo = (Button) findViewById(R.id.button2);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonThree = (Button) findViewById(R.id.button3);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonFour = (Button) findViewById(R.id.button4);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonFive = (Button) findViewById(R.id.button5);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonSix = (Button) findViewById(R.id.button6);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonSeven = (Button) findViewById(R.id.button7);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonEight = (Button) findViewById(R.id.button8);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });
        Button buttonNine = (Button) findViewById(R.id.button9);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonTen = (Button) findViewById(R.id.button10);
        buttonTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonEleven = (Button) findViewById(R.id.button11);
        buttonEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

        Button buttonTwelve = (Button) findViewById(R.id.button12);
        buttonTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubject(v);
            }
        });

    }

    private void chooseSubject(View view) {
        Intent intent = new Intent(this, TopicChooseActivity.class);
        Button b = (Button) findViewById(view.getId());
        intent.putExtra("className", b.getText().toString());
        startActivityForResult(intent,0);
    }
}
