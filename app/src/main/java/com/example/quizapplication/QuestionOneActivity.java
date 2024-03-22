package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuestionOneActivity extends BaseActivity {


    public void next(View view){
        Intent firstToSecond = new Intent(this, QuestionTwoActivity.class);
        firstToSecond.putExtra("name", name);
        firstToSecond.putExtra("score", score);
        firstToSecond.putExtra("currentQuestionIndex", currentQuestionIndex + 1);
        startActivity(firstToSecond);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        loadQuestionPage();

        Log.d("Q1", "onCreate: " + currentQuestionIndex);

        //set welcome message
        welcomeText.setText("Welcome, " + name);




















    }
}