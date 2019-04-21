package com.example.administrator.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Home_Agricultural_Rice_Expert;
import com.example.administrator.myapplication.adapter.HomeAgriculturalExpertAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.HomeMenu;

import java.util.ArrayList;
import java.util.List;

public class agricultural_expert extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layouttop;
    private GridView expert_grid;
    private List<HomeMenu> expertMenu;
    private HomeAgriculturalExpertAdapter adapter;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricultural_expert);


        layouttop=(LinearLayout)findViewById(R.id.home_agricultural_of_expert_layout_top);
        expert_grid=(GridView)findViewById(R.id.home_agricultural_of_expert_gridview);
        agricultural_expert_back_iv =(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        layouttop.setOnClickListener(this);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    private void init() {
        expertMenu=new ArrayList<>();
        expertMenu.add(new HomeMenu(R.mipmap.rice,"水稻", Home_Agricultural_Rice_Expert.class));
        expertMenu.add(new HomeMenu(R.mipmap.wheat,"小麦",null));
        expertMenu.add(new HomeMenu(R.mipmap.tejing,"特粮特经",null));
        expertMenu.add(new HomeMenu(R.mipmap.shucai,"蔬菜",null));
        expertMenu.add(new HomeMenu(R.mipmap.guoshu,"果树",null));
        expertMenu.add(new HomeMenu(R.mipmap.zhibao,"植保",null));
        expertMenu.add(new HomeMenu(R.mipmap.shengzhu,"生猪",null));
        expertMenu.add(new HomeMenu(R.mipmap.jiaqin,"家禽",null));
        expertMenu.add(new HomeMenu(R.mipmap.jiachu,"家畜",null));
        expertMenu.add(new HomeMenu(R.mipmap.huamu,"花木",null));
        expertMenu.add(new HomeMenu(R.mipmap.sangcan,"桑蚕",null));
        expertMenu.add(new HomeMenu(R.mipmap.chaye,"茶叶",null));
        expertMenu.add(new HomeMenu(R.mipmap.shuichan,"水产",null));
        expertMenu.add(new HomeMenu(R.mipmap.tufei,"土肥",null));
        expertMenu.add(new HomeMenu(R.mipmap.huanjingnengyuan,"环境能源",null));
        expertMenu.add(new HomeMenu(R.mipmap.nongji,"农机",null));
        expertMenu.add(new HomeMenu(R.mipmap.nongchanpinjiagong,"农产品加工",null));
        expertMenu.add(new HomeMenu(R.mipmap.nongjing,"农经",null));
        expertMenu.add(new HomeMenu(R.mipmap.nongyexinxihua,"农业信息化",null));
        expertMenu.add(new HomeMenu(R.mipmap.nongchanpinzhiliang,"农产品质量",null));
        expertMenu.add(new HomeMenu(R.mipmap.nongchanpinzhiliang,"农业保险",null));
        adapter=new HomeAgriculturalExpertAdapter(agricultural_expert.this,expertMenu);
        expert_grid.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(agricultural_expert.this, Home_Details.class);
        startActivity(intent);
    }
}
