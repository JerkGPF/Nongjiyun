package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
 * Created by Administrator on 2018/5/9.
 */

public class Home_Cooperation_LogoAdapter extends BaseAdapter{
    private Context context;
    private List<Home_TimeFarmingMenu> logoMenu;
    public Home_Cooperation_LogoAdapter(Context context, List<Home_TimeFarmingMenu> logoMenu) {

        this.context=context;
        this.logoMenu=logoMenu;
    }

    @Override
    public int getCount() {
        return logoMenu.size();
    }

    @Override
    public Object getItem(int position) {
        return logoMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  Home_TimeFarmingMenu LogoMenu=logoMenu.get(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_timeof_farming_lv_item, null, false);

            ImageView pic = convertView.findViewById(R.id.home_farming_item_iv);
            TextView title = convertView.findViewById(R.id.home_farming_item_title);
            TextView date = convertView.findViewById(R.id.home_farming_item_date);
            TextView read = convertView.findViewById(R.id.home_farming_item_reader);
            pic.setImageResource(LogoMenu.getImage());
            title.setText(LogoMenu.getTitle());
            date.setText(LogoMenu.getDate());
            read.setText(LogoMenu.getReader());
        }
        return convertView;
    }
}
