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

public class QuestionThreeActivity extends BaseActivity {


    public void next(View view){
        Intent thirdToFourth = new Intent(this, QuestionFourActivity.class);
        thirdToFourth.putExtra("name", name);
        thirdToFourth.putExtra("score", score);
        thirdToFourth.putExtra("currentQuestionIndex", currentQuestionIndex + 1);
        startActivity(thirdToFourth);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        loadQuestionPage();


    }

}