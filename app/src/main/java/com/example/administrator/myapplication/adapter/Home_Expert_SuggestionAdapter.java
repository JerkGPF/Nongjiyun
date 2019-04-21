package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Home_Agricultural_Expert_New;
import com.example.administrator.myapplication.moduels.Home_TimeFarmingMenu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class Home_Expert_SuggestionAdapter extends BaseAdapter {
    private Context context;
    private List<Home_TimeFarmingMenu> expert_suggestion;
    public Home_Expert_SuggestionAdapter(Context context, List<Home_TimeFarmingMenu> expert_suggestion) {
        this.context=context;
        this.expert_suggestion=expert_suggestion;
    }

    @Override
    public int getCount() {
        return expert_suggestion.size();
    }

    @Override
    public Object getItem(int position) {
        return expert_suggestion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  Home_TimeFarmingMenu suggestionMenu=expert_suggestion.get(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_timeof_farming_lv_item, null, false);

            ImageView pic = convertView.findViewById(R.id.home_farming_item_iv);
            TextView title = convertView.findViewById(R.id.home_farming_item_title);
            TextView date = convertView.findViewById(R.id.home_farming_item_date);
            TextView read = convertView.findViewById(R.id.home_farming_item_reader);
            pic.setImageResource(suggestionMenu.getImage());
            title.setText(suggestionMenu.getTitle());
            date.setText(suggestionMenu.getDate());
            read.setText(suggestionMenu.getReader());
        }
        return convertView;
    }
}
