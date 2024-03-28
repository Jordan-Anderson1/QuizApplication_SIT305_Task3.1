package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScreen extends AppCompatActivity {


    private String name;

    private int score;

    //goes back to start and remembers name
    public void newQuiz(View view){
            Intent backToStart = new Intent(this, MainActivity.class);
            backToStart.putExtra("name", name);
            startActivity(backToStart);
    }

    //goes back to start doesn't remember name
    public void finish(View view){
        Intent backToStart = new Intent(this, MainActivity.class);
        startActivity(backToStart);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        score = intent.getIntExtra("score", 0);

        TextView congratulationsText = findViewById(R.id.congratulationsText);
        TextView scoreText = findViewById(R.id.scoreText);
        Button finishButton = findViewById(R.id.finishButton);
        Button newQuizButton = findViewById(R.id.newQuizButton);

        congratulationsText.setText("Congratulations, " + name + "!");
        scoreText.setText("You scored " + score +"/5!");
    }
}