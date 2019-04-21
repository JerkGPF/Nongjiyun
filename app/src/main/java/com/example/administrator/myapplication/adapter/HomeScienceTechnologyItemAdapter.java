package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.HomeScienceTechnologyItemHenu;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

public class HomeScienceTechnologyItemAdapter extends BaseAdapter{
    private Context context;
    private List<HomeScienceTechnologyItemHenu> piclist;

    public HomeScienceTechnologyItemAdapter(Context context, List<HomeScienceTechnologyItemHenu> piclist) {
        this.context=context;
        this.piclist=piclist;
    }

    @Override
    public int getCount() {
        return piclist.size();
    }

    @Override
    public Object getItem(int position) {
        return piclist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeScienceTechnologyItemHenu listMenu=piclist.get(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_science_technology_pic_item, null, false);

            ImageView pic1 = convertView.findViewById(R.id.home_science_technology_pic_item_lv);
            pic1.setBackgroundResource(listMenu.getImage());


        }
        return convertView;
    }
}
