package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    TextView welcome;

    String name;

    public void getStarted(View view){
        Intent intent = new Intent(this, QuestionOneActivity.class);
        if(name == null){
            intent.putExtra("name", nameInput.getText().toString());
        }else{
            intent.putExtra("name", name);
        }

        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameEditText);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        welcome = findViewById(R.id.enterNameLabel);

        //if name was retrieved from intent it will be displayed otherwise will prompt to enter name
        if(name != null){
            nameInput.setVisibility(View.INVISIBLE);
            welcome.setText("Let's play again, " + name);
        }







    }
}