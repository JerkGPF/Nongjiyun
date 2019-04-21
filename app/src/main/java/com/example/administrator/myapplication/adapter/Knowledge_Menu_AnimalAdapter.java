package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Knowledge_Menu_Animal_CattleActivity;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Animal;
import com.example.administrator.myapplication.utils.ScreenUtil;

import java.util.List;

public class Knowledge_Menu_AnimalAdapter extends BaseAdapter {
    private List<Knowledge_Menu_Animal> list;
    private Context context;

    public Knowledge_Menu_AnimalAdapter(Context context, List<Knowledge_Menu_Animal> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RadioButton rb=new RadioButton(context);
        if (position==9){
            rb.setText("其他");
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.animal4,0,0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context,5));
            rb.setPadding(30,70,30,50);
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Knowledge_Menu_Animal_CattleActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }else {
            rb.setText(list.get(position).getName());
            rb.setButtonDrawable(null);
            rb.setBackgroundColor(Color.WHITE);
            rb.setPadding(30,70,30,50);
            rb.setCompoundDrawablesWithIntrinsicBounds(0,list.get(position).getImg(),0,0);
            rb.setCompoundDrawablePadding(ScreenUtil.dip2px(context,5));
            rb.setGravity(Gravity.CENTER);
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,list.get(position).getaClass());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);
                }
            });
        }

        return rb;
    }
}
