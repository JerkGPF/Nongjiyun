package com.example.administrator.myapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_cooperation_TabAdapter;
import com.example.administrator.myapplication.fragment.HomeSearchAnswerFragment;
import com.example.administrator.myapplication.fragment.HomeSearchCommunicationFragment;
import com.example.administrator.myapplication.fragment.HomeSearchVideoFragment;
import com.example.administrator.myapplication.fragment.HomeSearchinformationFragment;
import com.example.administrator.myapplication.fragment.My_AskFragment;

import java.util.ArrayList;
import java.util.List;

public class MyAskActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager viewpager;
    private Home_cooperation_TabAdapter adapter;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ask);
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
        tab = (TabLayout) findViewById(R.id.my_ask_tab);
        viewpager = (ViewPager) findViewById(R.id.my_ask_viewpager);
        String[] tabTitle = new String[]{"快速提问", "专家提问"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new My_AskFragment());
        fragments.add(new My_AskFragment());
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


