package com.example.administrator.myapplication.view;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.HomeTechnologyGridviewAdapter;
import com.example.administrator.myapplication.adapter.Home_Technology_WheatAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.Home_technology_gridview_rice_menu;

import java.util.ArrayList;
import java.util.List;

public class Home_technology_gridview_Wheat extends AppCompatActivity {
    private ListView gridview_wheat;
    private List<Home_technology_gridview_rice_menu> gridview_wheat_menus;
    private Home_Technology_WheatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_technology_gridview__wheat);
        init();
        initview();
    }



    private void init() {
        gridview_wheat=(ListView)findViewById(R.id.gridview_wheat);
        gridview_wheat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Home_technology_gridview_Wheat.this,gridview_wheat_menus.get(position).getUrl());
                 intent.putExtra("view",gridview_wheat_menus.get(position).getNeturl());
                startActivity(intent);
            }
        });
    }
    private void initview() {
        gridview_wheat_menus=new ArrayList<>();
        gridview_wheat_menus.add(new Home_technology_gridview_rice_menu( R.mipmap.ic_launcher,"不好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=2b53d27b-7daa-4167-bfa6-78fd7b413657"));
        gridview_wheat_menus.add(new Home_technology_gridview_rice_menu( R.mipmap.ic_launcher,"不好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=2b53d27b-7daa-4167-bfa6-78fd7b413657"));
        gridview_wheat_menus.add(new Home_technology_gridview_rice_menu( R.mipmap.ic_launcher,"不好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=2b53d27b-7daa-4167-bfa6-78fd7b413657"));
        gridview_wheat_menus.add(new Home_technology_gridview_rice_menu( R.mipmap.ic_launcher,"不好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=2b53d27b-7daa-4167-bfa6-78fd7b413657"));

        adapter=new Home_Technology_WheatAdapter(Home_technology_gridview_Wheat.this,gridview_wheat_menus);
        gridview_wheat.setAdapter(adapter);
    }
}
