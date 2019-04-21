package com.example.administrator.myapplication.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_Library_Adapter;
import com.example.administrator.myapplication.moduels.Home_TimeFarmingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Directory_Library_Fragment extends Fragment {

    private ListView library_lv;
    private  List<Home_TimeFarmingMenu> LibraryMenu;
    private Home_Library_Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_home__directory__library_, container, false);
        initView(view);
        init();
        return view;

    }

    private void initView(View view) {
        library_lv=(ListView)view.findViewById(R.id.home_directory_library_lv);
    }

    private void init() {

        LibraryMenu=new ArrayList<>();
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library1,"2017“双十品牌”：固城湖牌螃蟹","2017-2-23","342", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library2,"2017“双十品牌”：固城湖牌螃蟹","2017-2-23","234", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library3,"2017“双十品牌”：敖毅尚香牌黄桃","2017-2-23","232", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library1,"2017“双十品牌”：春祥牌蜂蜜","2017-2-23","234", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library2,"2017“双十品牌”：范得珍牌广东菜心、芥兰等","2017-2-23","5667", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library3,"2017“双十品牌”：武梅牌辣椒","2017-2-23","654", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library1,"2017“双十品牌”：金香溢牌大米","2017-2-23","775", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        LibraryMenu.add(new Home_TimeFarmingMenu(R.mipmap.library2,"2017“双十品牌”：范得珍牌广东菜心、芥兰等","2017-2-23","6765", Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=b6c897d0-2112-4571-8ebe-3e6299cbc0da"));
        adapter=new Home_Library_Adapter(getActivity(),LibraryMenu);
        library_lv.setAdapter(adapter);

        library_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),LibraryMenu.get(position).getUrl());
                startActivity(intent);

            }
        });
    }

}
