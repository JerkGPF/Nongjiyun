package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal_Goose;

import java.util.List;

public class Knowledge_Menu_Animal_GooseAdapter extends BaseAdapter {
    private List<Knowledge_Menu_Animal_Goose> list;
    private Context context;

    public Knowledge_Menu_Animal_GooseAdapter(Context context, List<Knowledge_Menu_Animal_Goose> list){
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
        final Knowledge_Menu_Animal_Goose knowledge_menu_animal_goose= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_knowledge_menu_ani_goose, null, false);
            ImageView img = convertView.findViewById(R.id.knowledge_menu_animal_goose_iv);
            TextView title = convertView.findViewById(R.id.knowledge_menu_animal_goose_title);
            TextView date = convertView.findViewById(R.id.knowledge_menu_animal_goose_date);
            TextView readnum = convertView.findViewById(R.id.knowledge_menu_animal_goose_readnum);
            title.setText(list.get(position).getTitle());
            date.setText(list.get(position).getDate());
            readnum.setText(list.get(position).getReadnum());
            img.setImageResource(list.get(position).getImg());

        }


        return convertView;
    }
}
