package com.example.myogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class News_Plus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_plus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("News");
    }
}
