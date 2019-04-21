package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.HomeNewAdapter;
import com.example.administrator.myapplication.moduels.HomeNewMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSearchinformationFragment extends Fragment {
    private List<HomeNewMenu> newMenus;
    private HomeNewAdapter adapter1;
    private ListView home_news_lv;


    public HomeSearchinformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_searchinformation, container, false);
        home_news_lv=(ListView)view.findViewById(R.id.home_news_lv);

        newMenus = new ArrayList<>();
        HomeNewMenu news1 = new HomeNewMenu(R.mipmap.home_lv_iv1, "[关注]兴化首“秀”:我国启动无人农业全程作业  将逐步建立无人农场", "2018-06-04", "阅读数：581", Home_Details.class);
        HomeNewMenu news2 = new HomeNewMenu(R.mipmap.home_lv_iv2, "[关注]“中国农业一号卫星”飞向太空", "2018-06-04", "阅读数：816", Home_Details.class);
        HomeNewMenu news3 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[调查]丰产难丰收，大户很纠结", "2018-06-04", "阅读数：894", Home_Details.class);
        HomeNewMenu news4 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[有问有答]糯玉米地里杂草如何安全有效去除等问答13则", "2018-06-04", "阅读数：529", Home_Details.class);
        HomeNewMenu news5 = new HomeNewMenu(R.mipmap.home_lv_iv1, "[关注]兴化首“秀”:我国启动无人农业全程作业  将逐步建立无人农场", "2018-06-04", "阅读数：581", Home_Details.class);
        HomeNewMenu news6 = new HomeNewMenu(R.mipmap.home_lv_iv2, "[关注]“中国农业一号卫星”飞向太空", "2018-06-04", "阅读数：816", Home_Details.class);
        HomeNewMenu news7 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[调查]丰产难丰收，大户很纠结", "2018-06-04", "阅读数：894", Home_Details.class);
        HomeNewMenu news8 = new HomeNewMenu(R.mipmap.home_lv_iv3, "[有问有答]糯玉米地里杂草如何安全有效去除等问答13则", "2018-06-04", "阅读数：529", Home_Details.class);
        newMenus.add(news1);
        newMenus.add(news2);
        newMenus.add(news3);
        newMenus.add(news4);
        newMenus.add(news5);
        newMenus.add(news6);
        newMenus.add(news7);
        newMenus.add(news8);
        adapter1 = new HomeNewAdapter(getActivity(), newMenus);
        home_news_lv.setAdapter(adapter1);
        home_news_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Home_Details.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
