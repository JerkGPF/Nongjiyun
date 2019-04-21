package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_Search_Expert;

import java.util.List;

public class Home_Search_ExpertAdapter extends BaseAdapter {
    private List<Home_Search_Expert> list;
    private Context context;
    public Home_Search_ExpertAdapter (List<Home_Search_Expert> list, Context context){
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
        final Home_Search_Expert home_search_expert= list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_search_expert, null, false);
            ImageView img = convertView.findViewById(R.id.home_search_expert_iv);
            TextView name = convertView.findViewById(R.id.home_search_expert_name);
            TextView sum = convertView.findViewById(R.id.home_search_expert_sum);
            TextView que = convertView.findViewById(R.id.home_search_expert_question);
            TextView main = convertView.findViewById(R.id.home_search_expert_main);
            TextView inn = convertView.findViewById(R.id.home_search_expert_inn);
            name.setText(list.get(position).getName());
            sum.setText(list.get(position).getSum());
            que.setText(list.get(position).getQue());
            main.setText(list.get(position).getMain());
            inn.setText(list.get(position).getInn());
            img.setImageResource(list.get(position).getImg());

        }


        return convertView;
    }
}
