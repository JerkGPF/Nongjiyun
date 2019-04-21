package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Tec;

import java.util.List;

public class Knowledge_Menu_TecAdapter extends BaseAdapter {
    private List<Knowledge_Menu_Tec> list;
    private Context context;

    public Knowledge_Menu_TecAdapter(Context context, List<Knowledge_Menu_Tec> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ListView lv= new ListView(context);
        final Knowledge_Menu_Tec knowledge_menu_tec = list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_knowledge_menu_tec, null, false);
            TextView title = convertView.findViewById(R.id.tec_tv_news_title);
            TextView date = convertView.findViewById(R.id.tec_tv_news_date);
            TextView readnum = convertView.findViewById(R.id.tec_tv_news_readnum);
            title.setText(list.get(position).getTitle());
            date.setText(list.get(position).getDate());
            readnum.setText(list.get(position).getReadnum());

        }


        return convertView;
    }



}
