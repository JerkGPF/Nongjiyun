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
import com.example.administrator.myapplication.fragment.BrandFeiLiaoFragment;
import com.example.administrator.myapplication.fragment.BrandNongYaoFragment;
import com.example.administrator.myapplication.fragment.BrandQiTaFragment;
import com.example.administrator.myapplication.fragment.BrandZhongZiFragment;
import com.example.administrator.myapplication.fragment.HomeSearchSupplyFragment;
import com.example.administrator.myapplication.fragment.Home_Cooperation_LogoFragment;
import com.example.administrator.myapplication.fragment.Home_Directory_Library_Fragment;
import com.example.administrator.myapplication.fragment.SupplyInfBuyFragment;
import com.example.administrator.myapplication.fragment.SupplyInfSellFragment;

import java.util.ArrayList;
import java.util.List;

public class SupplyInfActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager viewpager;
    private Home_cooperation_TabAdapter adapter;
    private ImageView agricultural_expert_back_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supply_inf);
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
        tab = (TabLayout) findViewById(R.id.supply_inf_tab);
        viewpager = (ViewPager) findViewById(R.id.supply_inf_viewpager);
        String[] tabTitle = new String[]{"供应", "求购"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SupplyInfSellFragment());
        fragments.add(new SupplyInfBuyFragment());
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
