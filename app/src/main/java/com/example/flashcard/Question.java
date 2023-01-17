package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collections;
import java.util.List;

public class Question implements Parcelable {

    String question;
    String level;
    int picture;
    String correctAnswer;
    List<String> answersList;

    public Question(String question, String level, int picture, List<String> answersList, String correctAnswer) {
        this.question = question;
        this.level = level;
        this.picture = picture;
        this.correctAnswer = correctAnswer;
        this.answersList = answersList;
    }


    protected Question(Parcel in) {
        question = in.readString();
        level = in.readString();
        picture = in.readInt();
        correctAnswer = in.readString();
        answersList = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(level);
        dest.writeInt(picture);
        dest.writeString(correctAnswer);
        dest.writeStringList(answersList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public String getLevel() {
        return level;
    }

    public int getPicture() {
        return picture;
    }

    public  String getCorrectAnswer() {

        return correctAnswer;
    }

    public List<String> getAnswersList() {

       // Collections.shuffle(answersList);

        return answersList;
    }

}
