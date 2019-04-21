package com.example.administrator.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class Home_Agricultural_Rice_ExpertAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] tabTitle;
    public Home_Agricultural_Rice_ExpertAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] tabTitle) {
        super(fm);
        this.fragmentList=fragmentList;
        this.tabTitle=tabTitle;

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    //    设置tablayout标题
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitle[position];

    }

}
