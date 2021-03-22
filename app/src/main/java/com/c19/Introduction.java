package com.c19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduction extends AppCompatActivity {
    Button btn_Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        btn_Next = (Button) findViewById(R.id.Next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this, Note.class);
        startActivity(intent);
    }
}