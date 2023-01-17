package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    String result;
    TextView resultTextview;
    int nbQuestions;
    int goodAnswersCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextview = findViewById(R.id.resultTextView);
        Intent srcIntent = getIntent();
        nbQuestions = srcIntent.getIntExtra("nbQuestions",0);
        goodAnswersCount = srcIntent.getIntExtra("goodAnswers",0);

        resultTextview.setText("Votre résultat : \n"+ goodAnswersCount +" / "+ nbQuestions);

        Button returnQuizActivity = findViewById(R.id.returnButton);
        returnQuizActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnQuizActivity = new Intent(Result.this, Start.class);
                finish();
                startActivity(returnQuizActivity);


            }
        });


    }



}