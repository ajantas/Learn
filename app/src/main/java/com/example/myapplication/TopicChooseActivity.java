package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TopicChooseActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    final ArrayList<CardItem> cardList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_choose);
        Bundle bundle =  getIntent().getExtras();
        final String className = bundle.getString("className");

        if(className.equalsIgnoreCase("Class 9")){
            cardList.add(new CardItem("Mathematics"));
            cardList.add(new CardItem("Physical Science"));
            cardList.add(new CardItem("Life Science"));
            cardList.add(new CardItem("Geography"));
            cardList.add(new CardItem("History"));
            cardList.add(new CardItem("English"));
            cardList.add(new CardItem("Bengali"));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CardAdapter(cardList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openChapters(position);
            }
        });

//        Button buttonOne = (Button) findViewById(R.id.math);
//        buttonOne.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    chooseSubject(className);
//                }
//            });
    }

    private void openChapters(int position) {
        CardItem cardItem = cardList.get(position);
        Intent intent = new Intent(this, ChapterChoose.class);
        Bundle bundle = new Bundle();
        bundle.putString("stuff", cardItem.getText());
        intent.putExtras(bundle);
        startActivityForResult(intent,0);
    }

    private void chooseSubject(String className) {
        if(className.equalsIgnoreCase("Class 9")) {
            Intent intent = new Intent(this, VideoActivity.class);
            startActivityForResult(intent, 0);
        }
    }
}
