package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_Search_Answer;

import java.util.List;

public class Home_Search_AnswerAdapter extends BaseAdapter {
    private List<Home_Search_Answer> list;
    private Context context;
    private String str_location;
    public Home_Search_AnswerAdapter(Context context, List<Home_Search_Answer> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final Home_Search_Answer home_search_answer= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_search_answer, null, false);
            ImageView head_img = (ImageView) convertView.findViewById(R.id.search_answer_iv);
            TextView name = convertView.findViewById(R.id.search_answer_tv_name);
            TextView local = convertView.findViewById(R.id.search_answer_tv_local);
            TextView identity = convertView.findViewById(R.id.search_answer_tv_id);
            TextView id = convertView.findViewById(R.id.search_answer_tv_id2);
            TextView article = convertView.findViewById(R.id.search_answer_tv_article);
            ImageView article_img = convertView.findViewById(R.id.search_answer_iv_picture);
            ImageView article_img2 = convertView.findViewById(R.id.search_answer_iv_picture2);
            ImageView article_img3 =convertView.findViewById(R.id.search_answer_iv_picture3);
            TextView date = convertView.findViewById(R.id.search_answer_tv_date);
            TextView redum = convertView.findViewById(R.id.search_answer_tv_readum);



            head_img.setImageResource(list.get(position).getHead_img());
            name.setText(list.get(position).getName());
            local.setText(list.get(position).getLocal());
            identity.setText(list.get(position).getIdentity());
            id.setText(list.get(position).getId());
            article.setText(list.get(position).getArticle());
            article_img.setImageResource(list.get(position).getArticle_img());
            article_img2.setImageResource(list.get(position).getArticle_img());
            article_img3.setImageResource(list.get(position).getArticle_img());
            date.setText(list.get(position).getDate());
            redum.setText(list.get(position).getReadum());


        }
        return convertView;
    }
}
