package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity implements View.OnClickListener {

    QuestionList easyQuiz = QuestionFactory.createQuizEasy();
    QuestionList regularQuiz = QuestionFactory.createQuizRegular();
    QuestionList hardQuiz = QuestionFactory.createQuizHard();
    QuestionList totalQuiz = QuestionFactory.createQuiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findViewById(R.id.startButton).setOnClickListener(this);
        findViewById(R.id.listButton).setOnClickListener(this);
        findViewById(R.id.aboutButton).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:

                Intent start = new Intent(Start.this, QuizActivity.class);

              //Créer une boite de dialogue :

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // Définir le titre de la boite de dialogue :
                String[] items = {"Facile","Moyen","Difficile"};
                int checkedItem = 1;
                builder.setTitle("Faites votre choix")
                        .setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        easyQuiz.getNextQuestion();
                                        start.putExtra("Quiz", easyQuiz);
                                        startActivity(start);

                                        setResult(RESULT_OK, start);

                                        break;
                                    case 1:
                                        easyQuiz.getNextQuestion();
                                        start.putExtra("Quiz", regularQuiz);
                                        startActivity(start);

                                        setResult(RESULT_OK, start);

                                        break;
                                    case 2:
                                        easyQuiz.getNextQuestion();
                                        start.putExtra("Quiz", hardQuiz);
                                        startActivity(start);

                                        setResult(RESULT_OK, start);
                                        break;
                                }
                            }
                        })

                        .create()// créer la boite de dialogue
                        //.setCanceledOnTouchOutside(false)
                        .show();// afficher la boite de dialogue


                break;




        case R.id.listButton:
            Intent questionList = new Intent(Start.this,QuestionView.class);
            //questionList.putExtra("QuizTotal",totalQuiz);
            startActivity(questionList);

            break;

            case R.id.aboutButton:
                Intent startAbout = new Intent(Start.this,AboutActivity.class);
                String versionApp = "1.0";
                // Ajout des infos a transmettre à l'activity AboutActivity
                startAbout.putExtra("nameGroup", "Group'3");
                startAbout.putExtra("appName", "FlashCard");
                startAbout.putExtra("version",versionApp);


                startActivity(startAbout);
            break;

    }
    }
}