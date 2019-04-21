package com.example.administrator.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myapplication.adapter.Home_Gridview_Timeof_Farming_Adapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.moduels.Home_TimeFarmingMenu;

import java.util.ArrayList;
import java.util.List;

public class timeof_farming extends AppCompatActivity {
    private List<Home_TimeFarmingMenu> timeofFarming;
    private ListView farming_lv;
    private Home_Gridview_Timeof_Farming_Adapter adapter;
    private ImageView agricultural_expert_back_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeof_farming);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv) ;
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        farming_lv=(ListView)findViewById(R.id.home_time_of_farming_lv);
        init();
        farming_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(timeof_farming.this,timeofFarming.get(position).getUrl());
                intent.putExtra("view",timeofFarming.get(position).getNeturl());
                startActivity(intent);
            }
        });

    }

    private void init() {
        timeofFarming=new ArrayList<>();
        timeofFarming.add(new Home_TimeFarmingMenu(R.mipmap.nongshi1,"设施葡萄优质高效栽培技术","2017-08-09","678", Home_Details.class,"http://njy.jsnjy.net.cn/web/share/new.action?newId=c74ab9c4-91b7-4725-8e79-9f1a442d11ab"));
        timeofFarming.add(new Home_TimeFarmingMenu(R.mipmap.nongshi2,"水稻精确定量设计栽培技术","2017-08-09","876",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        timeofFarming.add(new Home_TimeFarmingMenu(R.mipmap.nongshi1,"重点推进“四大工程” 江苏发布2018年水稻生产技术指导意见！","2017-08-09","767", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        timeofFarming.add(new Home_TimeFarmingMenu(R.mipmap.nongshi2,"【植保信息】2018年小麦赤霉病发生趋势与防治技术意见","2017-08-09","887",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        timeofFarming.add(new Home_TimeFarmingMenu(R.mipmap.nongshi1,"60张图片讲解葡萄临界期管理","2017-08-09","907",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        timeofFarming.add(new Home_TimeFarmingMenu(R.mipmap.nongshi2,"实施“四个融入四个服务”工程 推动特粮特经产业绿色高质高效发展","2017-08-09","786",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        adapter=new Home_Gridview_Timeof_Farming_Adapter(timeof_farming.this,timeofFarming);
        farming_lv.setAdapter(adapter);
    }
}
