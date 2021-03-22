package com.c19;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Need_doctor extends AppCompatActivity {
    TextView output;
    float result = MainActivity.getScore();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needdoctor);
        output = (TextView) findViewById(R.id.textView);
        Log.i("result good: ", String.valueOf(result));
        output.setText("you may need to consult with a doctor, Your result is " + (int) result + "%");
        Button btn_exit = findViewById(R.id.button);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button clicked", "ok");
                AlertDialog.Builder builder = new AlertDialog.Builder(Need_doctor.this);
                builder.setTitle("Do you want to exit?")
                        .setMessage("click yes to exit or no to start again")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("Yes clicked", "ok");
                                openActivity();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finishAffinity();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }

    private void openActivity() {
        Intent intent = new Intent(this, Note.class);
        startActivity(intent);
    }
}
