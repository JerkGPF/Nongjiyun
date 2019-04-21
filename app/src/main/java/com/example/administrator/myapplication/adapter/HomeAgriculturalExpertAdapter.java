package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.administrator.myapplication.moduels.HomeMenu;
import com.example.administrator.myapplication.utils.ScreenUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/5/6.
 */

public class HomeAgriculturalExpertAdapter extends BaseAdapter {
    private Context context;
    private List<HomeMenu> expertMenu;
    public HomeAgriculturalExpertAdapter(Context context, List<HomeMenu> expertMenu) {

    this.context=context;
    this.expertMenu=expertMenu;

    }

    @Override
    public int getCount() {
        return expertMenu.size();
    }

    @Override
    public Object getItem(int position) {
        return expertMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeMenu expertMenus=expertMenu.get(position);
        RadioButton rb=new RadioButton(context);
        rb.setText(expertMenus.getName());
        rb.setButtonDrawable(null);
        rb.setBackgroundColor(Color.WHITE);
        rb.setCompoundDrawablesWithIntrinsicBounds(0, expertMenus.getImage(), 0, 0);
        rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
        rb.setPadding(25,25,25,25);
        rb.setGravity(Gravity.CENTER);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,expertMenus.getUrl());
                context.startActivity(intent);
            }
        });
        return rb;

    }
}
