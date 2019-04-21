package com.example.administrator.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.myapplication.adapter.HomeNoticeAdapter;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.TabAdapter;
import com.example.administrator.myapplication.moduels.HomeNoticeMenu;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment_notice extends AppCompatActivity implements View.OnClickListener{

    private TabLayout tab;
    private ViewPager viewpager;
    private TabAdapter adapter;
    private ImageView notice_iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_fragment_notice);
        initviews();
    }
    private void initviews() {
        notice_iv_back=(ImageView)findViewById(R.id.home_iv_notice_back);
        notice_iv_back.setOnClickListener(this);
        tab = (TabLayout) findViewById(R.id.tab);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        String[] tabTitle = new String[]{"系统消息", "个人消息"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Home_Notice_System_Fragment());
        fragments.add(new Home_Notice_System_Fragment());
        adapter = new TabAdapter(getSupportFragmentManager(), fragments,tabTitle);
        //给ViewPager设置适配器
        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        tab.setupWithViewPager(viewpager);
        //设置可以滑动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        //占满tab栏
        tab.setTabMode(TabLayout.MODE_FIXED);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_iv_notice_back:
            finish();
            break;
        }
    }
}

