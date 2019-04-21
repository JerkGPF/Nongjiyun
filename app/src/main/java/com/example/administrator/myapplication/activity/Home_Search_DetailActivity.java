package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.TabFragmentShouYeAdapter;

import com.example.administrator.myapplication.fragment.HomeSearchAnswerFragment;
import com.example.administrator.myapplication.fragment.HomeSearchCommunicationFragment;
import com.example.administrator.myapplication.fragment.HomeSearchExpertFragment;
import com.example.administrator.myapplication.fragment.HomeSearchSupplyFragment;
import com.example.administrator.myapplication.fragment.HomeSearchVideoFragment;
import com.example.administrator.myapplication.fragment.HomeSearchinformationFragment;

import java.util.ArrayList;
import java.util.List;

public class Home_Search_DetailActivity extends FragmentActivity {
    private EditText home_et;
    private TabLayout tabLayout_shouye;
    private ViewPager viewPager_shouye;
    private List<String> strings = new ArrayList<String>();
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private ImageView home_edit_search_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__search__detail);
        home_edit_search_back=(ImageView)findViewById(R.id.home_edit_search_back);
        home_edit_search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initdate();
        initView();
        Intent intent=getIntent();
        String content=intent.getStringExtra("view");
        home_et.setText(content);
    }



    private void initdate() {
        HomeSearchinformationFragment fragment1 = new HomeSearchinformationFragment();
        fragments.add(fragment1);
        strings.add("资讯");
       HomeSearchCommunicationFragment fragment2 = new HomeSearchCommunicationFragment();
       fragments.add(fragment2);
        strings.add("交流");
        HomeSearchAnswerFragment fragment3 = new HomeSearchAnswerFragment();
        fragments.add(fragment3);
        strings.add("问答");
        HomeSearchExpertFragment fragment4 = new HomeSearchExpertFragment();
        fragments.add(fragment4);
        strings.add("专家");
        HomeSearchVideoFragment fragment5 = new HomeSearchVideoFragment();
        fragments.add(fragment5);
        strings.add("视频");
        HomeSearchSupplyFragment fragment6 = new HomeSearchSupplyFragment();
        fragments.add(fragment6);
        strings.add("供求");
    }
    private void initView(){
        tabLayout_shouye = (TabLayout)findViewById(R.id.tablayout_shouye);
        viewPager_shouye = (ViewPager)findViewById(R.id.viewpager_ShouYe);
        home_et=(EditText)findViewById(R.id.home_et);
        viewPager_shouye.setAdapter(new TabFragmentShouYeAdapter(fragments,strings,
                getSupportFragmentManager(),this));
        tabLayout_shouye.setupWithViewPager(viewPager_shouye);
        tabLayout_shouye.setTabTextColors(getResources().getColor(R.color.bar_grey_90)
                ,getResources().getColor(R.color.green));
    }
}
