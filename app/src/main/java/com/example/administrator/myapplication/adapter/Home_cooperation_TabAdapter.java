package com.example.administrator.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class Home_cooperation_TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] tabTitle;

    public Home_cooperation_TabAdapter(FragmentManager fm, List<Fragment> fragments, String[] tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    //    设置tablayout标题
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitle[position];

    }



    }
