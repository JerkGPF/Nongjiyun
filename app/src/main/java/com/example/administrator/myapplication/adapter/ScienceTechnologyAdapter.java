package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.HomeScienceTechnologyHemu;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */

public class ScienceTechnologyAdapter extends BaseAdapter{
    private Context context;
    private List<HomeScienceTechnologyHemu> list;
    public ScienceTechnologyAdapter(Context context, List<HomeScienceTechnologyHemu> list) {
        this.context= context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeScienceTechnologyHemu technologyMenu=list.get(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_science_technology_item, null, false);

            ImageView pic = convertView.findViewById(R.id.science_technology_lv_image);
            TextView title = convertView.findViewById(R.id.science_technology_lv_content_tv);
            TextView date = convertView.findViewById(R.id.science_technology_lv_date_tv);
            TextView read = convertView.findViewById(R.id.science_technology_lv_reader_tv);
            pic.setImageResource(technologyMenu.getImage());
            title.setText(technologyMenu.getContent());
            date.setText(technologyMenu.getTime());
            read.setText(technologyMenu.getReader());
        }
        return convertView;
    }
}
