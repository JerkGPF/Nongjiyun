package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Exchange_item;

import java.util.List;


public class Exchange_itemAdapter extends BaseAdapter {
    private List<Exchange_item> list;
    private Context context;
private String str_location;
    public Exchange_itemAdapter(Context context, List<Exchange_item> list){
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
        final Exchange_item exchange_item= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_exchange_lv, null, false);
            ImageView head_img = (ImageView) convertView.findViewById(R.id.item_exchange_iv);
            TextView name = convertView.findViewById(R.id.item_exchange_tv_name);
            TextView local = convertView.findViewById(R.id.item_exchange_tv_local);
            TextView identity = convertView.findViewById(R.id.item_exchange_tv_id);
            TextView article = convertView.findViewById(R.id.item_exchange_tv_article);
            ImageView article_img = convertView.findViewById(R.id.item_exchange_iv_picture);
            ImageView article_img2 = convertView.findViewById(R.id.item_exchange_iv_picture2);
            ImageView article_img3 =convertView.findViewById(R.id.item_exchange_iv_picture3);
            TextView date = convertView.findViewById(R.id.item_exchange_tv_date);
            ImageView zan_img = convertView.findViewById(R.id.item_exchange_iv_zan);
            ImageView review_img = convertView.findViewById(R.id.item_exchange_iv_review);



            head_img.setImageResource(list.get(position).getHead_img());
            name.setText(list.get(position).getName());
            local.setText(list.get(position).getLocal());
            identity.setText(list.get(position).getIdentity());
            article.setText(list.get(position).getArticle());
            article_img.setImageResource(list.get(position).getArticle_img());
            article_img2.setImageResource(list.get(position).getArticle_img());
            article_img3.setImageResource(list.get(position).getArticle_img());
            date.setText(list.get(position).getDate());
            zan_img.setImageResource(list.get(position).getZan_img());
            review_img.setImageResource(list.get(position).getReview_img());

        }
        return convertView;
    }
}
