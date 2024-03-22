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

public class QuestionFourActivity extends BaseActivity {



    public void next(View view){
        Intent fourthToFifth = new Intent(this, QuestionFiveActivity.class);
        fourthToFifth.putExtra("name", name);
        fourthToFifth.putExtra("score", score);
        fourthToFifth.putExtra("currentQuestionIndex", currentQuestionIndex + 1);
        startActivity(fourthToFifth);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        loadQuestionPage();


    }

}