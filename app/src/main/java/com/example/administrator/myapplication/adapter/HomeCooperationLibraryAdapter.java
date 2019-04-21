package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.HomeCooperationLibraryMenu;
import com.example.administrator.myapplication.moduels.HomeProfessionalCooperationMenu;
import com.example.administrator.myapplication.view.Professional_cooperation;

import java.util.List;

/**
 * Created by Administrator on 2018/5/7.
 */

public class HomeCooperationLibraryAdapter extends BaseAdapter {
    private Context context;
    private  List<HomeCooperationLibraryMenu> cooperationMenus2;
    public HomeCooperationLibraryAdapter(Context context, List<HomeCooperationLibraryMenu> cooperationMenus2) {
        this.context=context;
        this.cooperationMenus2=cooperationMenus2;
    }

    @Override
    public int getCount() {
        return cooperationMenus2.size();
    }

    @Override
    public Object getItem(int position) {
        return cooperationMenus2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeCooperationLibraryMenu cooperationMenu2 = cooperationMenus2.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_timeof_farming_lv_item,null, false);
            ImageView pic = convertView.findViewById(R.id.home_farming_item_iv);
            TextView title = convertView.findViewById(R.id.home_farming_item_title);
            TextView date = convertView.findViewById(R.id.home_farming_item_date);
            TextView read = convertView.findViewById(R.id.home_farming_item_reader);
            pic.setImageResource(cooperationMenu2.getImage());
            title.setText(cooperationMenu2.getTitle());
            date.setText(cooperationMenu2.getTime());
            read.setText(cooperationMenu2.getRead());
        }
        return convertView;
    }
}
