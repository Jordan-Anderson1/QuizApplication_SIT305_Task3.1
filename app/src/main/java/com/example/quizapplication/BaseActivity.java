package com.example.quizapplication;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected int score;
    protected String name;

    //keeps track of question number
    protected int currentQuestionIndex = 0;

    protected String correctAnswer;

    protected TextView questionNumber;
    protected TextView questionContent;
    protected TextView welcomeText;

    protected Button ans1;
    protected Button ans2;
    protected Button ans3;

    protected Button nextButton;

    protected Intent intent;
    protected ProgressBar progressBar;

    public void removeEventListeners(){
        ans1.setOnClickListener(null);
        ans2.setOnClickListener(null);
        ans3.setOnClickListener(null);
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

    public void manageIntent(){
        intent = getIntent();
        name = intent.getStringExtra("name");
        score = intent.getIntExtra("score", 0);
        currentQuestionIndex = intent.getIntExtra("currentQuestionIndex", 0);

    }

    public void loadQuestion(){

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

    public void initialiseComponents(){
        //initialise components
        correctAnswer = getResources().getStringArray(R.array.correctAnswers)[currentQuestionIndex];
        welcomeText = findViewById(R.id.welcomeText);
        questionNumber = findViewById(R.id.q1Title);
        questionContent = findViewById(R.id.q1Content);
        ans1 = findViewById(R.id.answer1Button);
        ans2 = findViewById(R.id.answer2Button);
        ans3 = findViewById(R.id.answer3Button);
        nextButton = findViewById(R.id.nextButton);
        progressBar = findViewById(R.id.quizProgressBar);
        progressBar.setProgress((int)(((currentQuestionIndex + 1) / 5.0) * 100));

    }

    public void loadQuestionPage(){
        manageIntent();
        initialiseComponents();
        loadQuestion();
    }


}
