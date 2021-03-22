package com.c19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Note extends AppCompatActivity {
    Button start_quiz ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        start_quiz = (Button) findViewById(R.id.start_quiz);
        start_quiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}