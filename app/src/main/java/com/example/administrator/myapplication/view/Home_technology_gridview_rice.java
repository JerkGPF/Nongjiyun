package com.example.administrator.myapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.adapter.Home_technology_gridview_riceAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_technology_gridview_rice_menu;

import java.util.ArrayList;
import java.util.List;

public class Home_technology_gridview_rice extends AppCompatActivity {
private ListView  rice_lv;
private List<Home_technology_gridview_rice_menu> riceList;
private Home_technology_gridview_riceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_technology_gridview_rice);
        rice_lv=(ListView)findViewById(R.id.home_technology_gridview_rice_lv);

        riceList=new ArrayList<>();
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        riceList.add(new Home_technology_gridview_rice_menu(R.mipmap.ic_launcher,"很好","11111","2911",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=43aebebf-e4ed-4fed-a60e-6f0c7799d0d6"));
        adapter=new Home_technology_gridview_riceAdapter(this,riceList);
        rice_lv.setAdapter(adapter);
        rice_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Home_technology_gridview_rice.this,riceList.get(position).getUrl());
                intent.putExtra("view",riceList.get(position).getNeturl());
                startActivity(intent);
            }
        });

    }
}
