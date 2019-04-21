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

public class Home_technology_gridview_DietAdapter extends BaseAdapter{
    private Context context;
    private List<Home_technology_gridview_rice_menu> dietmenu;
    public Home_technology_gridview_DietAdapter(Context context,List<Home_technology_gridview_rice_menu> dietmenu){
        this.context=context;
        this.dietmenu=dietmenu;
    }
    @Override
    public int getCount() {
        return dietmenu.size();
    }

    @Override
    public Object getItem(int position) {
        return dietmenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Home_technology_gridview_rice_menu DietMenus=dietmenu.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_technlology_gridview_rice_lv_item,null, false);
            ImageView pic = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_iv);
            TextView title = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_title);
            TextView date = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_date);
            TextView read = convertView.findViewById(R.id.home_technology_gridview_rice_lv_item_reader);
            pic.setImageResource(DietMenus.getImage());
            title.setText(DietMenus.getTitle());
            date.setText(DietMenus.getDate());
            read.setText(DietMenus.getReader());

        }
        return convertView;
    }
}
