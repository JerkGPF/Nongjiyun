package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.HomeNewAdapter;
import com.example.administrator.myapplication.fragment.Home_Details;
import com.example.administrator.myapplication.moduels.HomeNewMenu;

import java.util.ArrayList;
import java.util.List;

public class Home_HeadLine extends AppCompatActivity{

    private List<HomeNewMenu> newMenus;
    private HomeNewAdapter adapter1;
    private ListView home_news_lv;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_line);

        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        home_news_lv=(ListView)findViewById(R.id.home_headline_lv);

        newMenus = new ArrayList<>();
        HomeNewMenu news1 = new HomeNewMenu(R.mipmap.home_lv_iv1, "[关注]兴化首“秀”:我国启动无人农业全程作业  将逐步建立无人农场", "2018-06-04", "阅读数：581", Home_Details.class);
        HomeNewMenu news2 = new HomeNewMenu(R.mipmap.home_lv_iv2, "[关注]“中国农业一号卫星”飞向太空", "2018-06-04", "阅读数：816", Home_Details.class);
        HomeNewMenu news3 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[调查]丰产难丰收，大户很纠结", "2018-06-04", "阅读数：894", Home_Details.class);
        HomeNewMenu news4 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[有问有答]糯玉米地里杂草如何安全有效去除等问答13则", "2018-06-04", "阅读数：529", Home_Details.class);
        HomeNewMenu news5 = new HomeNewMenu(R.mipmap.home_lv_iv1, "[关注]兴化首“秀”:我国启动无人农业全程作业  将逐步建立无人农场", "2018-06-04", "阅读数：581", Home_Details.class);
        HomeNewMenu news6 = new HomeNewMenu(R.mipmap.home_lv_iv2, "[关注]“中国农业一号卫星”飞向太空", "2018-06-04", "阅读数：816", Home_Details.class);
        HomeNewMenu news7 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[调查]丰产难丰收，大户很纠结", "2018-06-04", "阅读数：894", Home_Details.class);
        HomeNewMenu news8 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[有问有答]糯玉米地里杂草如何安全有效去除等问答13则", "2018-06-04", "阅读数：529", Home_Details.class);
        newMenus.add(news1);
        newMenus.add(news2);
        newMenus.add(news3);
        newMenus.add(news4);
        newMenus.add(news5);
        newMenus.add(news6);
        newMenus.add(news7);
        newMenus.add(news8);
        adapter1 = new HomeNewAdapter(getApplicationContext(), newMenus);
        home_news_lv.setAdapter(adapter1);

    }

}
