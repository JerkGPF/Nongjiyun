package com.example.administrator.myapplication.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Price_InfActivity;
import com.example.administrator.myapplication.adapter.Home_cooperation_TabAdapter;
import com.example.administrator.myapplication.fragment.Home_Cooperation_LogoFragment;
import com.example.administrator.myapplication.fragment.Home_Directory_Library_Fragment;
import com.example.administrator.myapplication.fragment.Home_Notice_System_Fragment;
import com.example.administrator.myapplication.fragment.PriceFragment;

import java.util.ArrayList;
import java.util.List;

public class Market_quotations extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager viewpager;
    private Home_cooperation_TabAdapter adapter;
    private LinearLayout layout;
    private ImageView agricultural_expert_back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_quotations);
        agricultural_expert_back_iv=(ImageView)findViewById(R.id.agricultural_expert_back_iv);
        agricultural_expert_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        layout =(LinearLayout)findViewById(R.id.market_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Market_quotations.this, Price_InfActivity.class);
                startActivity(intent);
            }
        });
        initviews();

    }

    private void initviews() {

        tab = (TabLayout) findViewById(R.id.market_tab);
        viewpager = (ViewPager) findViewById(R.id.market_viewpager);
        String[] tabTitle = new String[]{"价格行情", "市场聚焦"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PriceFragment());
        fragments.add(new PriceFragment());
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



