package com.c19;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class call190 extends AppCompatActivity {
    TextView output;
    float result = MainActivity.getScore();
    Snackbar mySnackbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call190);
        output = (TextView) findViewById(R.id.textView);
        Log.i("result good: ", String.valueOf(result));
        output.setText("Please stay home, isolate yourself and call 190, Your result is " + (int) result + "%");
        Button btn_exit = findViewById(R.id.button);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button clicked", "ok");
                AlertDialog.Builder builder = new AlertDialog.Builder(call190.this);
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
        Button btn_call;
        btn_call = findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_190(v);
            }
        });

    }
    private void openActivity() {
        Intent intent = new Intent(this, Note.class);
        startActivity(intent);
    }
    public void call_190(View v){
        String num = "99081619";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + num));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            mySnackbar = Snackbar.make(v, "Please grant call permission first", BaseTransientBottomBar.LENGTH_SHORT);
            mySnackbar.show();
            return;
        }
        startActivity(intent);
    }


}

