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

public class Call190 extends AppCompatActivity {
    TextView output;
    float result = MainActivity.getScore();
    Snackbar mySnackbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call190);
        output = (TextView) findViewById(R.id.textView);
        Log.i("result good: ", String.valueOf(result)); // debugging msg
        output.setText("Please Stay Home, Isolate yourself and Call 190, Your result is " + (int) result + "%");
        Button btn_exit = findViewById(R.id.button);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button clicked", "ok"); // debugging msg
                AlertDialog.Builder builder = new AlertDialog.Builder(Call190.this);
                builder.setTitle("Do you want to exit?")
                        .setMessage("Click Yes to exit or No to start again")
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("No clicked", "ok");
                                openActivity();
                            }
                        })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
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
        String num = "99081619"; // number to Call N°190
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + num));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            mySnackbar = Snackbar.make(v, "Please Grant Call Permission In Phone Settings", BaseTransientBottomBar.LENGTH_SHORT);
            mySnackbar.show();
            return;
        }
        startActivity(intent);
    }


}

