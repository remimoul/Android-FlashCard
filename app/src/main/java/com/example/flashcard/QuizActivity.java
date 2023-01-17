package com.example.flashcard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView questionTextView;
    RadioGroup answerRadioGroup;
    RadioButton answerRadioButton1;
    RadioButton answerRadioButton2;
    RadioButton answerRadioButton3;
    RadioButton answerRadioButton4;
    ImageView picture;
    Button submit;


    QuestionList quiz;
    Question current;
    AlertDialog.Builder builder;

    String builderTitle;

//--------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        picture = findViewById(R.id.pictureImageView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        answerRadioButton1 = findViewById(R.id.answerRadioButton1);
        answerRadioButton2 = findViewById(R.id.answerRadioButton2);
        answerRadioButton3 = findViewById(R.id.answerRadioButton3);
        answerRadioButton4 = findViewById(R.id.answerRadioButton4);
        submit = findViewById(R.id.summit);
         builder = new AlertDialog.Builder(this);

        // récupérer le quiz de l'intent  :
        Intent srcIntent = getIntent();
        quiz = srcIntent.getParcelableExtra("Quiz");

        int size = quiz.size();


            current = (quiz.getCurrentQuestion());
            playQuestion(current);












        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = 0;


                int selected = answerRadioGroup.getCheckedRadioButtonId();
                RadioButton rb = answerRadioGroup.findViewById(selected);
                String answer = rb.getText().toString();

                Log.i("MainActivity", "selected =" + selected);



                if (answer.equals(current.getCorrectAnswer())) {
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    quiz.goodAnswersCount++;

                    builderTitle = "BravoOo 🥳 ";

                } else {

                    Toast.makeText(QuizActivity.this, "inCorrect", Toast.LENGTH_SHORT).show();

                    builderTitle = "Ooops 🫣 Loupé 🥺";

                }


            /*

*/

                if (quiz.size() > 1) {



                    if (quiz.nextQuestionIndex < (quiz.size() - 1)) {

                        builder.setTitle(builderTitle)
                        .setMessage("\n La bonne réponse était : \n  \n" + current.getCorrectAnswer()+"\n")
                                //Créer un bouton Ok sur lequel l'utilisateur peut cliquer
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                                        quiz.getNextQuestion();
                                        intent.putExtra("Quiz", quiz);
                                        startActivity(intent);
                                        finish();


                                    }
                                })

                                .create()
                                .show();




                    } else {

                        builder.setTitle(builderTitle)
                                .setMessage("\n  La bonne réponse était : \n\n" + current.getCorrectAnswer()+"\n")
                                //Créer un bouton Ok sur lequel l'utilisateur peut cliquer
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(QuizActivity.this, Result.class);
                                        intent.putExtra("nbQuestions", size);
                                        intent.putExtra("goodAnswers", quiz.goodAnswersCount);
                                        startActivity(intent);



                                    }
                                })

                                .create()// créer la boite de dialogue
                                .show();


                    }
                } else {


                    builder.setTitle(builderTitle)
                            // Définir le message qui s'affiche dans la boite de dialogue
                            .setMessage("\n La bonne réponse était : \n \n" + current.getCorrectAnswer()+"\n")
                            //Créer un bouton Ok sur lequel l'utilisateur peut cliquer
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    Intent intent = new Intent(QuizActivity.this,QuestionView.class);
                                    startActivity(intent);
                                    finish();


                                }
                            })

                            .create()// créer la boite de dialogue
                            .show();
                }


            }


                   });




    }



    private void playQuestion(final Question question) {
        questionTextView.setText(question.question);
        answerRadioButton1.setText(question.getAnswersList().get(0));
        answerRadioButton2.setText(question.getAnswersList().get(1));
        answerRadioButton3.setText(question.getAnswersList().get(2));
        answerRadioButton4.setText(question.getAnswersList().get(3));
        picture.setImageResource(question.picture);

    }
//
//ImageButton test = (ImageView)findViewById(R.id.pictureImageView);
//    test.setOnClickListener(){}
//


}

