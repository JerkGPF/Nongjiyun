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
import com.example.administrator.myapplication.moduels.HomeProfessionalCooperationMenu;
import com.example.administrator.myapplication.view.Professional_cooperation;

import java.io.PipedReader;
import java.security.PrivateKey;
import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */

public class HomeProfessionalCooperationAdapter extends BaseAdapter {
    private Context context;
    private List<HomeProfessionalCooperationMenu> cooperationMenus1;



    public HomeProfessionalCooperationAdapter(Context context, List<HomeProfessionalCooperationMenu> cooperationMenus1
) {

     this.context=context;
     this.cooperationMenus1=cooperationMenus1;

      }

    @Override
    public int getCount() {
        return cooperationMenus1.size();
    }

    @Override
    public Object getItem(int position) {
        return cooperationMenus1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final HomeProfessionalCooperationMenu cooperationMenu1 = cooperationMenus1.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_timeof_farming_lv_item,null, false);
            ImageView pic = convertView.findViewById(R.id.home_farming_item_iv);
            TextView title = convertView.findViewById(R.id.home_farming_item_title);
            TextView text  = convertView.findViewById(R.id.textView);
            TextView txt =convertView.findViewById(R.id.zhiding);
            TextView date = convertView.findViewById(R.id.home_farming_item_date);
            TextView read = convertView.findViewById(R.id.home_farming_item_reader);
            pic.setImageResource(cooperationMenu1.getImage());

            title.setText(cooperationMenu1.getTitle());

            text.setText(cooperationMenu1.getText());

            txt.setText(cooperationMenu1.getTxt());

            date.setText(cooperationMenu1.getTime());


            read.setText(cooperationMenu1.getRead());

        }
        return convertView;
    }
}
