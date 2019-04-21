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
import com.example.administrator.myapplication.adapter.ScienceTechnologyAdapter;
import com.example.administrator.myapplication.moduels.HomeScienceTechnologyHemu;
import com.example.administrator.myapplication.view.Science_and_technology_special;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PriceFragment extends Fragment {
    private ScienceTechnologyAdapter adapter;
    private List<HomeScienceTechnologyHemu> list;
    private ListView listView;


    public PriceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_price, container, false);
        listView =(ListView)view.findViewById(R.id.price_lv);

        list=new ArrayList<>();
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月28日粮食各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月28日蔬菜各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月28日六种畜禽产品各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月28日五种水产品各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月25日粮食各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月25日蔬菜各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月23日粮食各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月27日蔬菜各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月28日粮食各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));
        list.add(new HomeScienceTechnologyHemu(R.mipmap.icon_circle_red,"5月28日蔬菜各地市场报价","2017-09-22","阅读数：13006", Home_Details.class,"https://view.inews.qq.com/q/WXN20180602000567061?refer=mobileqq&rg=3&_wv=1&_rp=1&cur_pos=3&bkt=11002&qq=1968844105&rs=0&pid=2018060214&gid=0&tbkt=F"));

        adapter=new ScienceTechnologyAdapter(getContext(),list);
        listView.setAdapter(adapter);

        return view;
    }

}
