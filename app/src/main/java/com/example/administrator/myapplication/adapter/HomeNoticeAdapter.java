package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.HomeNoticeMenu;

import java.util.List;

/**
 * Created by Administrator on 2018/4/30.
 */

public class HomeNoticeAdapter extends BaseAdapter{

    private List<HomeNoticeMenu> noticeMenus;
    private Context context;
//    public HomeNoticeAdapter(Context context, List<HomeNoticeMenu> noticeMenus){
//
//    }

    public HomeNoticeAdapter(Context context,List<HomeNoticeMenu> noticeMenus) {
        this.noticeMenus=noticeMenus;
        this.context=context;
    }

    @Override
    public int getCount() {
        return noticeMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return noticeMenus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeNoticeMenu homeNoticeMenu = noticeMenus.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_notice_item1,null, false);
            ImageView pic = convertView.findViewById(R.id.home_iv_system_notice);
            TextView title = convertView.findViewById(R.id.home_tv1_system_notice);
            TextView date = convertView.findViewById(R.id.home_tv2_system_notice);
            TextView read = convertView.findViewById(R.id.home_tv3_system_notice);
            pic.setImageResource(noticeMenus.get(position).getNotice_image());
            title.setText(noticeMenus.get(position).getNotice_title());
            date.setText(noticeMenus.get(position).getNotice_time());
            read.setText(noticeMenus.get(position).getNotice_content());
        }

        return convertView;
    }
}
