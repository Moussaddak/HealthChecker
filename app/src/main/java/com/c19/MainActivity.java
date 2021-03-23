package com.c19;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static float score;
    private float tmp = 100;
    Button btn_one, btn_two, btn_three;
    TextView tv_question;

    private final Question question = new Question();
    // Total number of questions
    private final int questionLength = question.questions.length;
    public int iteration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_one = (Button) findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);

        tv_question = (TextView) findViewById(R.id.tv_question);
        NextQuestion(iteration);
    }

    private void NextQuestion(int num) {
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Log.i("itr: ", String.valueOf(iteration)); // debugging msg
        switch (v.getId()) {
            case R.id.btn_one:
                if (btn_one.getText() == question.choices[iteration][0]) {
                    tmp = tmp - 10;
                } else if (btn_one.getText() == question.choices[iteration][2]) {
                    tmp = tmp - 5;
                }
                break;

            case R.id.btn_two:
                if (btn_two.getText() == question.choices[iteration][0]) {
                    tmp = tmp - 10;
                } else if (btn_two.getText() == question.choices[iteration][2]) {
                    tmp = tmp - 5;
                }
                break;

            case R.id.btn_three:
                if (btn_three.getText() == question.choices[iteration][0]) {
                    tmp = tmp - 10;
                } else if (btn_three.getText() == question.choices[iteration][2]) {
                    tmp = tmp - 5;
                }
                break;
        }
        iteration++;
        Log.i("score exe: ", String.valueOf(tmp)); // debugging msg
        if (iteration == questionLength) {
            iteration = 0;
            Log.i("itr if: ", String.valueOf(iteration)); // debugging msg
            Log.i("score if b: ", String.valueOf(score)); // debugging msg
            score = tmp;
            GameOver(score);
            tmp = 100;
        }
        NextQuestion(iteration);
    }

    private void GameOver(float score) {
        Log.i("gameover: ", String.valueOf(score)); // debugging msg
        if (score >= 80) {
            Intent intent = new Intent(this, Goodhealth.class);
            startActivity(intent);
        } else if (score >= 60) {
            Intent intent = new Intent(this, Need_doctor.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, Call190.class);
            startActivity(intent);
        }
    }
    public static float getScore() {
        Log.i("result in getter", String.valueOf(score));
        return score;
    }

}