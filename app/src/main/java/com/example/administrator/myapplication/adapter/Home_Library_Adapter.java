package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.Home_Directory_Library_Fragment;
import com.example.administrator.myapplication.moduels.Home_TimeFarmingMenu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class Home_Library_Adapter extends BaseAdapter {
    private List<Home_TimeFarmingMenu> LibraryMenu;
    private Context context;
    public Home_Library_Adapter(Context context, List<Home_TimeFarmingMenu> libraryMenu){
        this.context=context;
        this.LibraryMenu=libraryMenu;
    }
    @Override
    public int getCount() {
        return LibraryMenu.size();
    }

    @Override
    public Object getItem(int position) {
        return LibraryMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  Home_TimeFarmingMenu LibraryMenus=LibraryMenu.get(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_timeof_farming_lv_item, null, false);
            ImageView pic = convertView.findViewById(R.id.home_farming_item_iv);
            TextView title = convertView.findViewById(R.id.home_farming_item_title);
            TextView date = convertView.findViewById(R.id.home_farming_item_date);
            TextView read = convertView.findViewById(R.id.home_farming_item_reader);
            pic.setImageResource(LibraryMenus .getImage());
            title.setText(LibraryMenus.getTitle());
            date.setText(LibraryMenus.getDate());
            read.setText(LibraryMenus.getReader());
        }
        return convertView;
    }
}
