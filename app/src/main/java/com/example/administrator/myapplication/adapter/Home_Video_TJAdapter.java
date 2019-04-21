package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Knowledge;
import com.example.administrator.myapplication.utils.ScreenUtil;

import java.util.List;

public class Home_Video_TJAdapter extends BaseAdapter{
    private List<Knowledge> datas;
    private Context context;


    public Home_Video_TJAdapter(Context context, List<Knowledge> datas) {
        this.context = context;
        this.datas = datas;
        // 布局装载器对象
    }
    @Override
    public int getCount() {
        return datas.size();
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

        final Knowledge knowledge = datas.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gv_home_video_tj, null, false);
            ImageView img = convertView.findViewById(R.id.home_video_iv_tj);
            TextView title = convertView.findViewById(R.id.home_video_tv_tj);
            title.setText(datas.get(position).getName());
            img.setBackgroundResource(datas.get(position).getImg());
        }
            return convertView;
        }

}
