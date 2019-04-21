package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Supply_Information_Buy;

import java.util.List;

public class Supply_Information_BuyAdapter extends BaseAdapter {
    private List<Supply_Information_Buy> list;
    private Context context;
    public Supply_Information_BuyAdapter (List<Supply_Information_Buy> list, Context context){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
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
        final Supply_Information_Buy supply_information_buy= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_supplyinfbuy, null, false);
            TextView title = convertView.findViewById(R.id.supply_buy_tv_title);
            TextView article = convertView.findViewById(R.id.supply_buy_article);
            TextView tv = convertView.findViewById(R.id.supply_buy_tv2);
            TextView address = convertView.findViewById(R.id.supply_buy_address);
            TextView date = convertView.findViewById(R.id.supply_buy_tv_date);
            title.setText(list.get(position).getTitle());
            article.setText(list.get(position).getArticle());
            tv.setText(list.get(position).getTv());
            address.setText(list.get(position).getAddress());
            date.setText(list.get(position).getDate());
        }


        return convertView;
    }
}
