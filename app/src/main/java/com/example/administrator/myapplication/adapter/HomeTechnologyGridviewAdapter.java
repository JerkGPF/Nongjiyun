package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.administrator.myapplication.moduels.Home_technology_gridview;
import com.example.administrator.myapplication.utils.ScreenUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class HomeTechnologyGridviewAdapter extends BaseAdapter {
    private Context context;
    private List<Home_technology_gridview> home_technology_gridviewList;
    public HomeTechnologyGridviewAdapter(Context context, List<Home_technology_gridview> home_technology_gridviewList) {
        this.context=context;
        this.home_technology_gridviewList=home_technology_gridviewList;
    }

    @Override
    public int getCount() {
        return 18;
    }

    @Override
    public Object getItem(int position) {
        return home_technology_gridviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Home_technology_gridview technology_gridview=home_technology_gridviewList.get(position);
        RadioButton rb=new RadioButton(context);
        rb.setText(technology_gridview.getName());
        rb.setButtonDrawable(null);
        rb.setBackgroundColor(Color.WHITE);
        rb.setCompoundDrawablesWithIntrinsicBounds(0, technology_gridview.getImage(), 0, 0);
        rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
        rb.setGravity(Gravity.CENTER);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, technology_gridview.getUrl());
                context.startActivity(intent);
            }
        });
        return rb;
    }
}
