package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_cooperation_TabAdapter;
import com.example.administrator.myapplication.fragment.Home_Video_TJFragment;
import com.example.administrator.myapplication.fragment.Home_Video_ZZFragment;
import com.example.administrator.myapplication.fragment.SupplyInfBuyFragment;
import com.example.administrator.myapplication.fragment.SupplyInfSellFragment;

import java.util.ArrayList;
import java.util.List;

public class Home_video extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager viewpager;
    private Home_cooperation_TabAdapter adapter;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_video);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initviews();
    }

    private void initviews() {
        tab = (TabLayout) findViewById(R.id.home_video_tab);
        viewpager = (ViewPager) findViewById(R.id.home_video_viewpager);
        String[] tabTitle = new String[]{"推荐", "种植","园艺","畜禽","水产","其他","新闻","乡村"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Home_Video_TJFragment());
        fragments.add(new Home_Video_ZZFragment());
        fragments.add(new Home_Video_ZZFragment());
        fragments.add(new Home_Video_ZZFragment());
        fragments.add(new Home_Video_ZZFragment());
        fragments.add(new Home_Video_ZZFragment());
        fragments.add(new Home_Video_ZZFragment());
        fragments.add(new Home_Video_ZZFragment());
        adapter = new Home_cooperation_TabAdapter(getSupportFragmentManager(), fragments, tabTitle);
        //给ViewPager设置适配器
        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        tab.setupWithViewPager(viewpager);
        //设置可以滑动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setTabMode(TabLayout.MODE_FIXED);
    }
}
