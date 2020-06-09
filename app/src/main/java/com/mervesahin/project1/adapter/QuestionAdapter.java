package com.mervesahin.project1.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mervesahin.project1.R;
import com.mervesahin.project1.model.Question;
import com.xwray.groupie.GroupieViewHolder;
import com.xwray.groupie.Item;

public class QuestionAdapter extends Item<GroupieViewHolder> {
    public Question question;
    public Context mcontext;

    public QuestionAdapter(Context mcontext,Question question){
        this.mcontext = mcontext;
        this.question = question;
    }
    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        View view = viewHolder.itemView;

        TextView question2= view.findViewById(R.id.question);
        question2.setText(question.getQuestion());

        Button BtnA = view.findViewById(R.id.BtnA);
        BtnA.setText(question.getOptionA());

        Button BtnB = view.findViewById(R.id.BtnB);
        BtnA.setText(question.getOptionB());

        Button BtnC = view.findViewById(R.id.BtnC);
        BtnA.setText(question.getOptionC());

        Button BtnD = view.findViewById(R.id.BtnD);
        BtnA.setText(question.getOptionD());




    }

    @Override
    public int getLayout() {
        return R.layout.activity_questiontest;
    }
}
