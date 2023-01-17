package com.example.flashcard;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collections;
import java.util.List;

public class QuestionList implements Parcelable {

    List<Question> questionList;
    String level;
    int goodAnswersCount = 0;
    int nextQuestionIndex;

    public QuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    protected QuestionList(Parcel in) {
        questionList = in.createTypedArrayList(Question.CREATOR);
        level = in.readString();
        goodAnswersCount = in.readInt();
        nextQuestionIndex = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(questionList);
        dest.writeString(level);
        dest.writeInt(goodAnswersCount);
        dest.writeInt(nextQuestionIndex);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionList> CREATOR = new Creator<QuestionList>() {
        @Override
        public QuestionList createFromParcel(Parcel in) {
            return new QuestionList(in);
        }

        @Override
        public QuestionList[] newArray(int size) {
            return new QuestionList[size];
        }
    };

    public Question getCurrentQuestion() {

        return questionList.get(nextQuestionIndex);
    }

    public Question getNextQuestion() {
        nextQuestionIndex++;

        return getCurrentQuestion();
    }

    public int size() {

        return questionList.size();
    }
}
