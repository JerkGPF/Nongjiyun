package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Pro_TLT_Main;

import java.util.List;

public class Knowledge_Menu_Pro_TLT_MainAdapter extends BaseAdapter {
    private List<Knowledge_Menu_Pro_TLT_Main> list;
    private Context context;
    public Knowledge_Menu_Pro_TLT_MainAdapter (List<Knowledge_Menu_Pro_TLT_Main> list, Context context){
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
        final Knowledge_Menu_Pro_TLT_Main knowledge_menu_pro_tlt_main= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_knowledge_menu_pro_maintlt, null, false);
            ImageView img = convertView.findViewById(R.id.knowledge_menu_pro_main_tlt_iv);
            TextView name = convertView.findViewById(R.id.knowledge_menu_pro_main_tlt_name);
            TextView sum = convertView.findViewById(R.id.knowledge_menu_pro_main_tlt_sum);
            TextView main = convertView.findViewById(R.id.knowledge_menu_pro_main_tlt_main);
            TextView inn = convertView.findViewById(R.id.knowledge_menu_pro_main_tlt_inn);
            name.setText(list.get(position).getName());
            sum.setText(list.get(position).getSum());
            main.setText(list.get(position).getMain());
            inn.setText(list.get(position).getInn());
            img.setImageResource(list.get(position).getImg());

        }


        return convertView;
    }
}
