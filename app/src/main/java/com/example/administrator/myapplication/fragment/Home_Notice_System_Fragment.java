package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.HomeNoticeAdapter;
import com.example.administrator.myapplication.moduels.HomeMenu;
import com.example.administrator.myapplication.moduels.HomeNoticeMenu;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Notice_System_Fragment extends Fragment {
    private ListView system_lv;
    private List<HomeNoticeMenu> noticeMenus;
    private HomeNoticeAdapter adapter;
    private List<String>  urls;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        initview(view);
        initDate();
        return view;
    }

    private void initDate() {
        noticeMenus=new ArrayList<>();
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04 ","聚焦产业观察--江苏蓝莓产业发展问题及对策。" ,Home_Details.class,"http://www.niit.edu.cn/46/64/c2086a18020/page.htm"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","请看市场调查--丰产难丰收",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","兴化首“秀”--我国启动无人农机全程作业，将逐步建立无人农场",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","专家支招帮您应对稻田黄叶病",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","请看糯玉米地里杂草如何安全有效去除等问答13则",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","兴化首“秀”--我国启动无人农机全程作业，将逐步建立无人农场",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","兴化首“秀”--我国启动无人农机全程作业，将逐步建立无人农场",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","兴化首“秀”--我国启动无人农机全程作业，将逐步建立无人农场",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04 ","聚焦产业观察--江苏蓝莓产业发展问题及对策。" ,Home_Details.class,"http://www.niit.edu.cn/46/64/c2086a18020/page.htm"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","请看市场调查--丰产难丰收",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","兴化首“秀”--我国启动无人农机全程作业，将逐步建立无人农场",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","专家支招帮您应对稻田黄叶病",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","请看糯玉米地里杂草如何安全有效去除等问答13则",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        noticeMenus.add(new HomeNoticeMenu(R.mipmap.icon_notice,"农技耘","2018-06-04","兴化首“秀”--我国启动无人农机全程作业，将逐步建立无人农场",Home_Details.class,"http://www.jsnjy.net.cn/newsDetail.html?newId=789d5ae2-fd9d-4c7e-8f0f-ae530c51b693"));
        adapter=new HomeNoticeAdapter(getActivity(),noticeMenus);
        system_lv.setAdapter(adapter);

        urls=new ArrayList<>();

        system_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Home_Details.class);
                intent.putExtra("view",noticeMenus.get(position).getNeturl());
                startActivity(intent);
            }
        });
    }

    private void initview(View view) {
        system_lv=(ListView)view.findViewById(R.id.home_notice_system);
    }

}
