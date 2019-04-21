package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_TimeFarmingMenu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class Home_Gridview_Timeof_Farming_Adapter extends BaseAdapter{
    private Context context;
    private List<Home_TimeFarmingMenu> timeofFarming;
    public Home_Gridview_Timeof_Farming_Adapter(Context context, List<Home_TimeFarmingMenu> timeofFarming) {
        this.context=context;
        this.timeofFarming=timeofFarming;
    }

    @Override
    public int getCount() {
        return timeofFarming.size();
    }

    @Override
    public Object getItem(int position) {
        return timeofFarming.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         final  Home_TimeFarmingMenu farmingMenu=timeofFarming.get(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_timeof_farming_lv_item, null, false);

            ImageView pic = convertView.findViewById(R.id.home_farming_item_iv);
            TextView title = convertView.findViewById(R.id.home_farming_item_title);
            TextView date = convertView.findViewById(R.id.home_farming_item_date);
            TextView read = convertView.findViewById(R.id.home_farming_item_reader);
            pic.setImageResource(farmingMenu.getImage());
            title.setText(farmingMenu.getTitle());
            date.setText(farmingMenu.getDate());
            read.setText(farmingMenu.getReader());
        }
        return convertView;
    }
}
