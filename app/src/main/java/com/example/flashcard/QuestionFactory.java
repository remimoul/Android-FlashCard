package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionFactory  {


// Paramètre pour mélanger : à voir plus tard
    public static QuestionList createQuizEasy() {

        Question question2 = new Question("Quel acteur a joué le rôle d'un boxeur russe, Ivan Drago, dans  Rocky 4  ?",
                "Easy",
                R.drawable.rocky_image,
              Arrays.asList("Mister T", "Dolph Lundgren", "Adrian Pinnino Balboa", "Hulk Hogan"),
                "Dolph Lundgren"

        );

        Question question3 = new Question("Qui a peint la Joconde ?",
                "Easy",
                R.drawable.la_joconde,
                Arrays.asList("Jean Bourdichon", "Léonard de Vinci", "Simon Marmion", "Henri Bellechose"),
                "Léonard de Vinci"
        );


        Question question4 = new Question("Dans quelle maison vit le président américain ?",
                "Easy",
                R.drawable.la_maison_blanche,
                Arrays.asList("L'élysée", "La maison close", "La maison Blanche", "10 Downing Street"),
                "La maison Blanche"
        );
        Question question5 = new Question("Qui a été la première personne à marcher sur la lune ?",
                "Easy",
                R.drawable.la_lune,
                Arrays.asList("Nils Holgersson", "Le petit prince", "Buzz Aldrin ", "Neil Armstrong"),
                "Neil Armstrong"
        );
        Question question6 = new Question("Quelle est la capitale des États-Unis ?",
                "Easy",
                R.drawable.flag_usa,
                Arrays.asList("Miami", "Boston", "Washington DC", "New York"),
                "Washington DC"
        );


        List<Question> questionList = Arrays.asList(question2, question3, question4, question5, question6);
        shuffleAnswers(questionList);

        return new QuestionList(questionList);



    }

    private static void shuffleAnswers(List<Question> questionList) {
        for(Question question : questionList) {
            Collections.shuffle(question.getAnswersList());
        }
        Collections.shuffle(questionList);
    }


    public static QuestionList createQuizRegular() {

        Question question7 = new Question("En quelle année Google a-t-il été lancé sur le Web ?",
                "Regular",
                R.drawable.google,
                Arrays.asList("1899", "2010", "1998", "1992"),
                "1998"
        );
        Question question8 = new Question("Quel est le plus grand état des États-Unis ?",
                "Regular",
                R.drawable.carte_etat_unis,
                Arrays.asList("Alaska", "Texas", "Californie", "Montana"),
                "Alaska"
        );
        Question question9 = new Question("En quelle année la Seconde Guerre mondiale a-t-elle pris fin ?",
                "Regular",
                R.drawable.soldat,
                Arrays.asList("1942", "1945", "1948", "1940"),
                "1945"
        );
        Question question10 = new Question("Quel appareil utilisons-nous pour regarder les étoiles ?",
                "Regular",
                R.drawable.star,
                Arrays.asList("Un kaléidoscope", "Une passoire", "Un télescope", "Un camescope"),
                "Un télescope"
        );
        Question question11 = new Question("Quel est le plus grand singe anthropoïde?",
                "Regular",
                R.drawable.singe,
                Arrays.asList("l'orang-outan", "Le chimpanzé", "Le Demis Roussos", "Le gorille"),
                "Le gorille"
        );

       List<Question> questionList = Arrays.asList(question7, question8,question9,question10,question11);

        shuffleAnswers(questionList);
        return new QuestionList(questionList);





    }

    public static QuestionList createQuizHard() {

        Question question1 = new Question(
                "Quel artiste est à l’origine de l’œuvre “Création d’Adam” ?",
                "Difficult",
                R.drawable.creationdadam, Arrays.asList(
                "Sandro Boticelli",
                "Michelangelo Buonarotti ",
                "Le Caravage",
                "Giovanni Odazzi"
        ), "Michelangelo Buonarotti "
        );


        Question question12 = new Question("Que signifie le mot dinosaure en grec ?",
                "Hard",
                R.drawable.dinosaure,
                Arrays.asList("Lézard féroce", "Lézard disparu", "Lézard craintif", "C'est quoi ce truc?"),
                "Lézard craintif"
        );
        Question question13 = new Question("Xerxès a gouverné un grand empire vers le Ve siècle av. Quel empire ?",
                "Hard",
                R.drawable.perse,
                Arrays.asList("L'empire perse", "L'empire romain", "L'empire ottoman", "L'empire contre-attaque"),
                "L'empire perse"
        );
        Question question14 = new Question("Que signifie le nom du journal russe Pravda ?",
                "Hard",
                R.drawable.journaux,
                Arrays.asList("Wodka", "Fraternité", "Camarade", "Vérité"),
                "Vérité"
        );
        Question question15 = new Question("Quelle malformation Marilyn Monroe avait-elle à sa naissance ?",
                "Hard",
                R.drawable.marilyn_monroe,
                Arrays.asList("Deux nombrils", "Six orteils", "Les doigts palmés", "4 reins"),
                "Six orteils"
        );
        Question question16 = new Question("Qui a remporté le plus de Grammy Awards dans les années 80 ?",
                "Hard",
                R.drawable.grammy_awards,
                Arrays.asList("Phil Collins", "Michael Jackson", "Paul McCartney", "David Bowie"),
                "Michael Jackson"
        );


        List<Question> questionList = Arrays.asList(question1, question12,question13,question14,question15,question16);
        shuffleAnswers(questionList);
        return new QuestionList(questionList);



    }

    public static QuestionList createQuiz() {

        Question question1 = new Question(
                "Quel artiste est à l’origine de l’œuvre “Création d’Adam” ?",
                "Difficult",
                R.drawable.creationdadam, Arrays.asList(
                "Sandro Boticelli",
                "Michelangelo Buonarotti ",
                "Le Caravage",
                "Giovanni Odazzi"
        ),  "Michelangelo Buonarotti "
        );

        Question question2 = new Question("Quel acteur a joué le rôle d'un boxeur russe, Ivan Drago, dans  Rocky 4  ?",
                "Easy",
                R.drawable.rocky_image,
                Arrays.asList("Mister T", "Dolph Lundgren", "Adrian Pinnino Balboa", "Hulk Hogan"),
                "Dolph Lundgren"

        );

        Question question3 = new Question("Qui a peint la Joconde ?",
                "Easy",
                R.drawable.la_joconde,
                Arrays.asList("Jean Bourdichon", "Léonard de Vinci", "Simon Marmion", "Henri Bellechose"),
                "Léonard de Vinci"
        );


        Question question4 = new Question("Dans quelle maison vit le président américain ?",
                "Easy",
                R.drawable.la_maison_blanche,
                Arrays.asList("L'élysée", "La maison close", "La maison Blanche", "10 Downing Street"),
                "La maison Blanche"
        );
        Question question5 = new Question("Qui a été la première personne à marcher sur la lune ?",
                "Easy",
                R.drawable.la_lune,
                Arrays.asList("Nils Holgersson", "Le petit prince", "Buzz Aldrin ", "Neil Armstrong"),
                "Neil Armstrong"
        );
        Question question6 = new Question("Quelle est la capitale des États-Unis ?",
                "Easy",
                R.drawable.flag_usa,
                Arrays.asList("Miami", "Boston", "Washington DC", "New York"),
                "Washington DC"
        );


        Question question7 = new Question("En quelle année Google a-t-il été lancé sur le Web ?",
                "Regular",
                R.drawable.google,
                Arrays.asList("1899", "2010", "1998", "1992"),
                "1998"
        );
        Question question8 = new Question("Quel est le plus grand état des États-Unis ?",
                "Regular",
                R.drawable.carte_etat_unis,
                Arrays.asList("Alaska", "Texas", "Californie", "Montana"),
                "Alaska"
        );
        Question question9 = new Question("En quelle année la Seconde Guerre mondiale a-t-elle pris fin ?",
                "Regular",
                R.drawable.soldat,
                Arrays.asList("1942", "1945", "1948", "1940"),
                "1945"
        );
        Question question10 = new Question("Quel appareil utilisons-nous pour regarder les étoiles ?",
                "Regular",
                R.drawable.star,
                Arrays.asList("Un kaléidoscope", "Une passoire", "Un télescope", "Un camescope"),
                "Un télescope"
        );
        Question question11 = new Question("Quel est le plus grand singe anthropoïde?",
                "Regular",
                R.drawable.singe,
                Arrays.asList("l'orang-outan", "Le chimpanzé", "Le Demis Roussos", "Le gorille"),
                "Le gorille"
        );


        Question question12 = new Question("Que signifie le mot dinosaure en grec ?",
                "Hard",
                R.drawable.dinosaure,
                Arrays.asList("Lézard féroce", "Lézard disparu", "Lézard craintif", "C'est quoi ce truc?"),
                "Lézard craintif"
        );
        Question question13 = new Question("Xerxès a gouverné un grand empire vers le Ve siècle av. Quel empire ?",
                "Hard",
                R.drawable.perse,
                Arrays.asList("L'empire perse", "L'empire romain", "L'empire ottoman", "L'empire contre-attaque"),
                "L'empire perse"
        );
        Question question14 = new Question("Que signifie le nom du journal russe Pravda ?",
                "Hard",
                R.drawable.journaux,
                Arrays.asList("Wodka", "Fraternité", "Camarade", "Vérité"),
                "Vérité"
        );
        Question question15 = new Question("Quelle malformation Marilyn Monroe avait-elle à sa naissance ?",
                "Hard",
                R.drawable.marilyn_monroe,
                Arrays.asList("Deux nombrils", "Six orteils", "Les doigts palmés", "4 reins"),
                "Six orteils"
        );
        Question question16 = new Question("Qui a remporté le plus de Grammy Awards dans les années 80 ?",
                "Hard",
                R.drawable.grammy_awards,
                Arrays.asList("Phil Collins", "Michael Jackson", "Paul McCartney", "David Bowie"),
                "Michael Jackson"
        );


        List<Question> questionList = Arrays.asList(question1,question2,question3,question4,question5,question6,question7,question8,question9,question10,question11, question12,question13,question14,question15,question16);
        shuffleAnswers(questionList);
        return new QuestionList(questionList);

    }








    // QuestionList regularQuiz = new QuestionList(Arrays.asList(question7, question8, question9, question10, question11));
    //  QuestionList hardQuiz = new QuestionList(Arrays.asList(question12, question13, question14, question15, question16, question1));






}

