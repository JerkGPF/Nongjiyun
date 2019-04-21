package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.administrator.myapplication.moduels.HomeMenu;
import com.example.administrator.myapplication.utils.ScreenUtil;
import com.example.administrator.myapplication.view.more;


import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class MyGridAdapter extends BaseAdapter {


    private Context context;
    private MyGridAdapter adapter;
    private List<Integer> list;
    private List<HomeMenu> dates;
    LayoutInflater layoutInflater;
    private ImageView mImageView;
    private RadioButton rb;



    public MyGridAdapter(Context context,List<HomeMenu>dates) {

        this.context = context;
        this.dates=dates;
        this.list=list;
       layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 9;

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return dates.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        RadioButton rb = new RadioButton(context);
        final HomeMenu homeMenu = dates.get(position);
        if (position == 8) {
            rb.setText("更多");
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, dates.get(position).getImage(), 0, 0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
            rb.setPadding(20,20,20,20);
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,more.class);
                    context.startActivity(intent);
                }
            });
        } else {
            rb.setText(dates.get(position).getName());
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, dates.get(position).getImage(), 0, 0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
            rb.setPadding(20,20,20,20);
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, dates.get(position).getUrl());
                    context.startActivity(intent);
                }
            });
        }

        return rb;
    }
    }
