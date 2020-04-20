package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    static boolean isStudent = false, isTeacher = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = findViewById(R.id.welcomeImage);
        view.setImageResource(R.drawable.welcome_image);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton student = (RadioButton) findViewById(R.id.radioStudent);
        RadioButton teacher = (RadioButton) findViewById(R.id.radioTeacher);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStudent = true;
                isTeacher = false;
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStudent = false;
                isTeacher = true;
            }
        });
        Button buttonOne = (Button) findViewById(R.id.continue1);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseClass(isStudent, isTeacher);
            }
        });
    }

    private void chooseClass(boolean isStudent, boolean isTeacher) {
        if(isStudent){
            Intent intent = new Intent(this, ClassActivity.class);
            startActivityForResult(intent,0);
        }
        if(isTeacher){
            Intent intent = new Intent(this, TeachersActivity.class);
            startActivityForResult(intent,0);
        }
    }

}
