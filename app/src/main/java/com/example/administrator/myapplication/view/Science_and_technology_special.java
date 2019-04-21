package com.example.administrator.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.HomeScienceTechnologyItemAdapter;
import com.example.administrator.myapplication.adapter.ScienceTechnologyAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.HomeScienceTechnologyHemu;
import com.example.administrator.myapplication.moduels.HomeScienceTechnologyItemHenu;
import com.example.administrator.myapplication.utils.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;

public class Science_and_technology_special extends AppCompatActivity {
    private ScienceTechnologyAdapter adapter;
    private List<HomeScienceTechnologyHemu> list;
    private ListViewForScrollView science_technology_lv;
    private ListViewForScrollView science_technology_pic_lv;
    private TextView home_science_technology_more;
    private List<HomeScienceTechnologyItemHenu> piclist;
    private HomeScienceTechnologyItemAdapter adapter2;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_and_technology_special);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
        initData();
    }



    private void init() {
        science_technology_lv=(ListViewForScrollView)findViewById(R.id.science_technology_lv);
        home_science_technology_more=(TextView)findViewById(R.id.home_science_technology_more);
        science_technology_pic_lv=(ListViewForScrollView)findViewById(R.id.science_technology_pic_lv);


    }
    private void initData() {
        list=new ArrayList<>();
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"【聚焦】江苏发布2018-2019年全省农业重大技术推广计划","2017-09-22","阅读数：13006", Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=22de6422-3894-46b2-88af-434cd8eaa529"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"【聚焦】 江苏出台《关于全面推进科技支农强...","2017-09-22","阅读数：13006", Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb\n"));

        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"【关注】2018年江苏省农业职业院校单独招生简章发布，欢迎报考！","2017-09-22","阅读数：13006", Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=c74ab9c4-91b7-4725-8e79-9f1a442d11ab"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"关于组织参加2018年全国农民科学素质网络知识竞答活动的通知","2018-05-30","阅读数：13256", Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb\n"));
        adapter=new ScienceTechnologyAdapter(this,list);
        science_technology_lv.setAdapter(adapter);
        science_technology_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent=new Intent(Science_and_technology_special.this,list.get(position).getUrl());
                intent.putExtra("view",list.get(position).getNeturl());
                startActivity(intent);
//                home_science_technology_more.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent1=new Intent(Science_and_technology_special.this, HomeScienceTechnologyDynamic.class);
//                        startActivity(intent1);
//                    }
//                });
            }
        });

        piclist=new ArrayList<>();
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science1,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=2705eb74-a38d-43fd-90c0-bc30c423e80c"));
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science2,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb"));
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science3,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb"));
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science4,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb"));
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science5,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb"));
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science1,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb"));
        piclist.add(new HomeScienceTechnologyItemHenu(R.mipmap.science4,Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=bef5d8dd-acd0-425f-8107-f7d4389060fb"));

        adapter2=new HomeScienceTechnologyItemAdapter(this,piclist);
        science_technology_pic_lv.setAdapter(adapter2);
        science_technology_pic_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),Home_Details.class);
                startActivity(intent);
            }
        });

    }
}
