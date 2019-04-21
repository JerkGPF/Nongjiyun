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
import com.example.administrator.myapplication.utils.ScreenUtil;

import java.util.List;

/**
 * Created by xiaolin on 2015/1/24.
 */
public class GridViewAdapter2 extends BaseAdapter {
    private Context context;
    private List<HomeMenu> strList2;
    private int hidePosition = AdapterView.INVALID_POSITION;

    public GridViewAdapter2(Context context, List<HomeMenu> strList2) {
        this.context = context;
        this.strList2 = strList2;
    }

    @Override
    public int getCount() {
        return strList2.size();
    }

    @Override
    public Object getItem(int position) {
        return strList2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HomeMenu drag=strList2.get(position);

        RadioButton rb;
        if(convertView == null) {

            rb= new RadioButton(context);
        }
        else {
            rb = (RadioButton) convertView;
        }

        //hide时隐藏Text
        if(position != hidePosition) {
            rb.setText(strList2.get(position).getName());
        }
        else {
            rb.setText("");
        }
        rb.setId(position);

//        return view;
//            RadioButton rb = new RadioButton(context);
            rb.setText(strList2.get(position).getName());
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, strList2.get(position).getImage(), 0, 0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context, 5));
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, strList2.get(position).getUrl());
                    context.startActivity(intent);
                }
            });

        return rb;

    }


}
