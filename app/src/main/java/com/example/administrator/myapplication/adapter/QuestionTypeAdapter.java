package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.QuestionType;

import java.util.List;


public class QuestionTypeAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<QuestionType> questionTypes;
    public QuestionTypeAdapter(Context context, List<QuestionType> questionTypes){
        layoutInflater=LayoutInflater.from(context);
        this.questionTypes=questionTypes;
    }
    @Override
    public int getCount() {
        return questionTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = layoutInflater.inflate(R.layout.item_question_type, null);
        TextView type=view.findViewById(R.id.tv_type);
        type.setText(questionTypes.get(position).getType());
        return view;
    }
}
