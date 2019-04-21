package com.example.administrator.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_technology_gridview_DietAdapter;
import com.example.administrator.myapplication.adapter.Home_technology_gridview_riceAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.Home_technology_gridview_rice_menu;

import java.util.ArrayList;
import java.util.List;

public class Home_technology_gridview_Specialdiet extends AppCompatActivity {
    private ListView special_diet_lv;
    private List<Home_technology_gridview_rice_menu> dietmenu;
    private Home_technology_gridview_DietAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_technology_gridview__specialdiet);
        init();
        initDates();
    }

    private void initDates() {
        dietmenu=new ArrayList<>();
        dietmenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        dietmenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        dietmenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        dietmenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        dietmenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        dietmenu.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        adapter=new Home_technology_gridview_DietAdapter(Home_technology_gridview_Specialdiet.this,dietmenu);
        special_diet_lv.setAdapter(adapter);
    }

    private void init() {
        special_diet_lv=(ListView)findViewById(R.id.special_diet_lv);
        special_diet_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Home_technology_gridview_Specialdiet.this,dietmenu.get(position).getUrl());
                intent.putExtra("view",dietmenu.get(position).getNeturl());
                startActivity(intent);

            }
        });

    }
}
