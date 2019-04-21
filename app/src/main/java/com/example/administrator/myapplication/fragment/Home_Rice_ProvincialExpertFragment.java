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

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.Home_Agricultural_Rice_Expert;
import com.example.administrator.myapplication.activity.WangcailinActivity;
import com.example.administrator.myapplication.adapter.Home_Agricultural_Provincial_Rice_ExpertAdapter;
import com.example.administrator.myapplication.moduels.Home_Rice_Expert_Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Rice_ProvincialExpertFragment extends Fragment {
    private List<Home_Rice_Expert_Menu> provincialMenu;
    private ListView provincial_expert_lv;
    private Home_Agricultural_Provincial_Rice_ExpertAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home__rice__provincial_expert, container, false);
        provincial_expert_lv=(ListView)view.findViewById(R.id.provincial_expert_lv);
        init();
        return  view;
    }

    private void init() {
        provincialMenu=new ArrayList<>();
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"王才林","江苏省农业科学院","585","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"邓建平","省农药检定所","38","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"李刚华","南京农业大学","552","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"谢成林","扬州市农业技术推广站","53","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"戴其根","扬州大学","85","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"董明辉","江苏太湖地区农业科学研究所（苏州市）","24","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"徐晓杰","江苏（武进）水稻研究所","93","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"王强盛","南京农业大学","54","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"杨洪建","江苏农业技术推广总站","152","  省级专家  ","  水稻  ",null));
        provincialMenu.add(new Home_Rice_Expert_Menu(R.mipmap.pro_head,"陈正行","江南大学","6","  省级专家  ","  水稻  ",null));

        adapter=new Home_Agricultural_Provincial_Rice_ExpertAdapter(getActivity(),provincialMenu);
        provincial_expert_lv.setAdapter(adapter);
        provincial_expert_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), WangcailinActivity.class);
                startActivity(intent);
            }
        });
    }

}
