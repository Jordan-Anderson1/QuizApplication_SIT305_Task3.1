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

public class QuestionFiveActivity extends BaseActivity {


    public void next(View view){
        Intent toFinalScreen = new Intent(this, FinalScreen.class);
        toFinalScreen.putExtra("name", name);
        toFinalScreen.putExtra("score", score);
        startActivity(toFinalScreen);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        loadQuestionPage();

        Log.d("Q5", "onCreate: " + currentQuestionIndex);

    }
}