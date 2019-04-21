package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_Search_Supply;

import java.util.List;

public class Home_Search_SupplyAdapter extends BaseAdapter {
    private List<Home_Search_Supply> list;
    private Context context;
    public Home_Search_SupplyAdapter (List<Home_Search_Supply> list, Context context){
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
        final Home_Search_Supply home_search_supply= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_search_supply, null, false);
            ImageView img = convertView.findViewById(R.id.search_supply_iv);
            TextView title = convertView.findViewById(R.id.search_supply_tv_title);
            TextView article = convertView.findViewById(R.id.search_supply_article);
            TextView tv = convertView.findViewById(R.id.search_supply_tv2);
            TextView address = convertView.findViewById(R.id.search_supply_tv_content_address);
            TextView date = convertView.findViewById(R.id.search_supply_tv_date);
            title.setText(list.get(position).getTitle());
            article.setText(list.get(position).getArticle());
            tv.setText(list.get(position).getTv());
            address.setText(list.get(position).getAddress());
            date.setText(list.get(position).getDate());
            img.setImageResource(list.get(position).getImg());

        }


        return convertView;
    }
}
