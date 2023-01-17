package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionView extends AppCompatActivity {


    private QuestionAdapter adapter;
    private QuestionList totalQuiz = QuestionFactory.createQuiz();
    private  List<Question> questions;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);




        questions = new ArrayList<>();

        questions.addAll(totalQuiz.questionList);




        adapter = new QuestionAdapter(questions);

        RecyclerView recyclerView = findViewById(R.id.questionRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

     @Override
    protected void onPause() {
        super.onPause();

        finish();
    }


}

