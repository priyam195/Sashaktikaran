package com.example.priyamkumar.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        String easyPuzzle = intent.getExtras().getString("epuzzle");
        TextView tv= (TextView) findViewById(R.id.showTextView);
        tv.setText(easyPuzzle);


    }
}
