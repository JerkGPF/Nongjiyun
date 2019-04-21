package com.example.administrator.myapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_Agricultural_Rice_ExpertAdapter;
import com.example.administrator.myapplication.adapter.TabAdapter;
import com.example.administrator.myapplication.fragment.Home_Rice_ProvincialExpertFragment;

import java.util.ArrayList;
import java.util.List;

public class Home_Agricultural_Rice_Expert extends AppCompatActivity {
    private TabLayout expert_tab;
    private ViewPager rice_expert_vp;
    private Home_Agricultural_Rice_ExpertAdapter adapter;
    private List<Fragment>fragmentList;

    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__agricultural__rice__expert);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    private void init() {
        expert_tab=(TabLayout)findViewById(R.id.home_agricultural_rice_expert_tab);
        rice_expert_vp=(ViewPager)findViewById(R.id.rice_vp);
        String[] tabTitle = new String[]{"省级专家", "地方专家","驻村专家"};
        fragmentList=new ArrayList<>();
        fragmentList.add(new Home_Rice_ProvincialExpertFragment());
        fragmentList.add(new Home_Rice_ProvincialExpertFragment());
        fragmentList.add(new Home_Rice_ProvincialExpertFragment());
        adapter = new Home_Agricultural_Rice_ExpertAdapter(getSupportFragmentManager(),fragmentList,tabTitle);
        //给ViewPager设置适配器
        rice_expert_vp.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        expert_tab.setupWithViewPager(rice_expert_vp);
        //设置可以滑动
        expert_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        //占满tab栏
        expert_tab.setTabMode(TabLayout.MODE_FIXED);

    }
}
