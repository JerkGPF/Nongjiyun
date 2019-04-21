package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.Home_Rice_ProvincialExpertFragment;
import com.example.administrator.myapplication.moduels.Home_Rice_Expert_Menu;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class Home_Agricultural_Provincial_Rice_ExpertAdapter extends BaseAdapter{
    private Context context;
    private List<Home_Rice_Expert_Menu> provincialMenu;
    public Home_Agricultural_Provincial_Rice_ExpertAdapter(Context context, List<Home_Rice_Expert_Menu> provincialMenu) {
        this.context=context;
        this.provincialMenu=provincialMenu;
    }

    @Override
    public int getCount() {
        return provincialMenu.size();
    }

    @Override
    public Object getItem(int position) {
        return provincialMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Home_Rice_Expert_Menu expertMenu=provincialMenu.get(position);
        if (convertView==null){
         convertView=LayoutInflater.from(context).inflate(R.layout.fragment_rice_provincial_expert_item,null,false );
            ImageView pic = convertView.findViewById(R.id.home_rice_expert_pic);
            TextView name = convertView.findViewById(R.id.home_rice_expert_name);
            TextView company = convertView.findViewById(R.id.home_rice_expert_company);
            TextView question = convertView.findViewById(R.id.home_rice_expert_question);
            TextView experttype=convertView.findViewById(R.id.home_rice_provincial_expert_tv);
            TextView rice=convertView.findViewById(R.id.home_rice_expert_rice_tv);
            pic.setImageResource(expertMenu.getImage());
            name.setText(expertMenu.getName());
            company.setText(expertMenu.getCompany());
            question.setText(expertMenu.getQuestion());
            experttype.setText(expertMenu.getExpert());
            rice.setText(expertMenu.getRice());
        }
        return convertView;
    }
}
