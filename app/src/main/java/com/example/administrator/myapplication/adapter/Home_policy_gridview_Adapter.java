package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_technology_gridview_rice_menu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class Home_policy_gridview_Adapter extends BaseAdapter {
    private Context context;
    private List<Home_technology_gridview_rice_menu> policymenu;
    public Home_policy_gridview_Adapter(Context context, List<Home_technology_gridview_rice_menu> policymenu){
        this.context=context;
        this.policymenu=policymenu;
    }
    @Override
    public int getCount() {
        return policymenu.size();
    }

    @Override
    public Object getItem(int position) {
        return policymenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Home_technology_gridview_rice_menu PolicyMenus=policymenu.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_technlology_gridview_rice_lv_item,null, false);
            ImageView pic = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_iv);
            TextView title = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_title);
            TextView date = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_date);
            TextView read = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_reader);
            pic.setImageResource(PolicyMenus.getImage());
            title.setText(PolicyMenus.getTitle());
            date.setText(PolicyMenus.getDate());
            read.setText(PolicyMenus.getReader());
        }
        return convertView;

    }
}
