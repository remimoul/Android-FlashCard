package com.example.flashcard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> implements View.OnClickListener {

    private List<Question> questions;

    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Question question = questions.get(position);
        holder.picture.setImageResource(question.picture);
        holder.level.setText(question.level);

        holder.itemView.setTag(question);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {

        return questions.size();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.testItem:

                Context context = v.getContext();

                Question q = (Question) v.getTag();
                Intent intent = new Intent(context,QuizActivity.class);

                ArrayList<Question> questions = new ArrayList<>();
                questions.add(q);
                QuestionList questionList = new QuestionList(questions);
                intent.putExtra("Quiz",questionList);
                context.startActivity(intent);

                break;


        }

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        final ImageView picture;
        final TextView level;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        // Récupération du composant de item view
        picture = itemView.findViewById(R.id.questionImageRecyclerView);
        level = itemView.findViewById(R.id.questionRecyclerViewTextView);
    }

}
}
