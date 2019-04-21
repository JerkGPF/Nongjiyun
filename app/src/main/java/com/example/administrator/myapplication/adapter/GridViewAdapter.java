package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.administrator.myapplication.moduels.HomeMenu;
import com.example.administrator.myapplication.moduels.HomeMoreMenu;
import com.example.administrator.myapplication.utils.ScreenUtil;

import java.util.List;

/**
 * Created by xiaolin on 2015/1/24.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<HomeMoreMenu> strList;


    public GridViewAdapter(Context context, List<HomeMoreMenu> strList) {
        this.context = context;
        this.strList = strList;
    }

    @Override
    public int getCount() {
        return strList.size();
    }

    @Override
    public Object getItem(int position) {
        return strList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
           final   HomeMoreMenu drag = strList.get(position);


        RadioButton rb = new RadioButton(context);
        rb.setText(strList.get(position).getName());
        rb.setButtonDrawable(null);
        rb.setBackgroundColor(Color.WHITE);
        rb.setCompoundDrawablesWithIntrinsicBounds(0, strList.get(position).getImage(), 0, 0);
        rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
        rb.setPadding(10,10,10,10);
        rb.setGravity(Gravity.CENTER);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, strList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        return rb;

    }
}
