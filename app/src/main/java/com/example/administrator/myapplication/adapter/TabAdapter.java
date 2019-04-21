package com.example.administrator.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.myapplication.fragment.HomeFragment_notice;
import com.example.administrator.myapplication.fragment.TabLayoutFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/5/7.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] tabTitle;
    public TabAdapter(FragmentManager fm, List<Fragment> fragments, String[] tabTitle) {
        super(fm);
        this.fragments= fragments;
        this.tabTitle=tabTitle;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return  fragments.size();
    }

//    设置tablayout标题
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitle[position];

    }


}
