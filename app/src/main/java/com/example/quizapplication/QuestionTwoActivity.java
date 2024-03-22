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

public class QuestionTwoActivity  extends BaseActivity {


    public void next(View view){
        Intent secondToThird = new Intent(this, QuestionThreeActivity.class);
        secondToThird.putExtra("name", name);
        secondToThird.putExtra("score", score);
        secondToThird.putExtra("currentQuestionIndex", currentQuestionIndex + 1);
        startActivity(secondToThird);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);


        loadQuestionPage();



    }
}