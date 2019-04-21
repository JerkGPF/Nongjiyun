package com.example.administrator.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_policy_gridview_Adapter;
import com.example.administrator.myapplication.adapter.Home_technology_gridview_DietAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.Home_technology_gridview_rice_menu;

import java.util.ArrayList;
import java.util.List;

public class Agricultural_policy extends AppCompatActivity {
    private ListView home_policy_gridview_lv;
    private List<Home_technology_gridview_rice_menu> policymenu;
    private Home_policy_gridview_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricultural_policy);
       init();
       initdates();
    }

    private void initdates() {
        policymenu=new ArrayList<>();
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        policymenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
    }

    private void init() {
        home_policy_gridview_lv=(ListView)findViewById(R.id.home_policy_gridview_lv);
        home_policy_gridview_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Agricultural_policy.this,policymenu.get(position).getUrl());
                intent.putExtra("view",policymenu.get(position).getNeturl());
                startActivity(intent);

            }
        });
    }
}
