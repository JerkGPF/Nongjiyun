package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.HomeNewMenu;

import java.util.List;

/**
 * Created by Administrator on 2018/4/28.
 */

public class HomeNewAdapter extends BaseAdapter {

    private List<HomeNewMenu> newMenus;
    private Context context;

    public HomeNewAdapter(Context context, List<HomeNewMenu> newMenus) {
        this.newMenus = newMenus;
        this.context=context;
    }

    @Override
    public int getCount() {
        return newMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return newMenus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeNewMenu homeNewMenu = newMenus.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_news,null, false);
            ImageView pic = convertView.findViewById(R.id.home_iv_news_pic);
            TextView title = convertView.findViewById(R.id.home_iv_news_title);
            TextView date = convertView.findViewById(R.id.home_iv_news_date);
            TextView read = convertView.findViewById(R.id.home_iv_news_read);
            pic.setImageResource(newMenus.get(position).getImage());
            title.setText(newMenus.get(position).getTitle());
            date.setText(newMenus.get(position).getTime());
            read.setText(newMenus.get(position).getRead());

        }
        return convertView;
    }
}
