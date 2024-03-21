package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class QuestionOneActivity extends AppCompatActivity {

    public int score = 0;
    public String name;

    //keeps track of question number
    public int currentQuestionIndex = 0;

    public String correctAnswer;

    Button ans1;
    Button ans2;
    Button ans3;

    Button nextButton;

    public void removeEventListeners(){
        ans1.setOnClickListener(null);
        ans2.setOnClickListener(null);
        ans3.setOnClickListener(null);
    }

    public void next(View view){
        Intent firstToSecond = new Intent(this, QuestionTwoActivity.class);
        firstToSecond.putExtra("name", name);
        firstToSecond.putExtra("score", score);
        firstToSecond.putExtra("currentQuestionIndex", currentQuestionIndex + 1);
        startActivity(firstToSecond);
    }

    public void handleClick(View view){
        String selectedAnswer = ((Button) view).getText().toString();

        //if selected answer is incorrect, sets selection to red and correct answer to green
        if (!selectedAnswer.equals(correctAnswer)){
            ((Button) view).setBackgroundColor(Color.RED);

            if(ans1.getText().equals(correctAnswer)){
                ans1.setBackgroundColor(Color.GREEN);
            }else if(ans2.getText().equals(correctAnswer)){
                ans2.setBackgroundColor(Color.GREEN);
            }else{
                ans3.setBackgroundColor(Color.GREEN);
            }
        }else{
            ((Button) view).setBackgroundColor((Color.GREEN)); //sets your correct answer to green
            score++;
        }
        removeEventListeners(); //turn off event listeners so another option cannot be selected

        nextButton.setVisibility(View.VISIBLE); //shows next button
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        correctAnswer = getResources().getStringArray(R.array.correctAnswers)[currentQuestionIndex];

        //get Intent
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        //initialise components
        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView questionNumber = findViewById(R.id.q1Title);
        TextView questionContent = findViewById(R.id.q1Content);
        ans1 = findViewById(R.id.answer1Button);
        ans2 = findViewById(R.id.answer2Button);
        ans3 = findViewById(R.id.answer3Button);
        nextButton = findViewById(R.id.nextButton);
        ProgressBar progressBar = findViewById(R.id.quizProgressBar);

        progressBar.setProgress((int)(((currentQuestionIndex + 1) / 5.0) * 100));


        //set welcome message
        welcomeText.setText("Welcome, " + name);

        //retrieve questions and set question
        String question = getResources().getStringArray(R.array.questions)[currentQuestionIndex];
        questionContent.setText(question);

        //set question number
        questionNumber.setText("Question " + String.valueOf(currentQuestionIndex + 1) + ':');

        //get answer array
        String answerArray = "q"+String.valueOf(currentQuestionIndex + 1)+"Answers";
        int resourceID = getResources().getIdentifier(answerArray, "array", getPackageName());
        String[] answers = getResources().getStringArray(resourceID);

        //set buttons to answer values
        ans1.setText(answers[0]);
        ans2.setText(answers[1]);
        ans3.setText(answers[2]);
















    }
}