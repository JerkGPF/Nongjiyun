package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.Home_Search_ExpertAdapter;
import com.example.administrator.myapplication.adapter.Knowledge_Menu_Pro_Rice_NormalAdapter;
import com.example.administrator.myapplication.moduels.Home_Search_Expert;
import com.example.administrator.myapplication.moduels.Knowledge_Menu_Pro_Rice_Normal;
import com.example.administrator.myapplication.view.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSearchExpertFragment extends Fragment {

    //岗位专家
    private List<Home_Search_Expert> lt;
    private Home_Search_ExpertAdapter ap;
    private MyListView lv;


    public HomeSearchExpertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_search_expert, container, false);
        lv= (MyListView)view.findViewById(R.id.home_search_expert_lv);
        lv.setBackgroundColor(Color.WHITE);
        lt=new ArrayList<Home_Search_Expert>();
        Home_Search_Expert h1 = new Home_Search_Expert(R.mipmap.icon_default_head,"马晓峰","问题：1","单位：无锡市惠山区农业技术推广服务站","地方专家","果树",null);
        Home_Search_Expert h2 = new Home_Search_Expert(R.mipmap.icon_default_head,"徐  生","问题：10","单位：南京市耕保站","地方专家","水稻",null);
        Home_Search_Expert h3 = new Home_Search_Expert(R.mipmap.icon_default_head,"张达余","问题：1","单位：阜宁县土壤肥料站","地方专家","土壤",null);
        Home_Search_Expert h4 = new Home_Search_Expert(R.mipmap.icon_default_head,"吴华兵","问题：6","单位：南京市农业技术推广站","地方专家","水稻",null);
        Home_Search_Expert h5 = new Home_Search_Expert(R.mipmap.icon_default_head,"吴向阳","问题：0","单位：昆山市农业技术推广中心","地方专家","植保",null);
        Home_Search_Expert h6 = new Home_Search_Expert(R.mipmap.icon_default_head,"李世兴","问题：1","单位：徐州市铜山区农委","地方专家","水稻",null);

        Home_Search_Expert h7 = new Home_Search_Expert(R.mipmap.icon_default_head,"马晓峰","问题：1","单位：无锡市惠山区农业技术推广服务站","地方专家","果树",null);
        Home_Search_Expert h8 = new Home_Search_Expert(R.mipmap.icon_default_head,"徐  生","问题：10","单位：南京市耕保站","地方专家","水稻",null);
        Home_Search_Expert h9 = new Home_Search_Expert(R.mipmap.icon_default_head,"张达余","问题：1","单位：阜宁县土壤肥料站","地方专家","土壤",null);
        Home_Search_Expert h10 = new Home_Search_Expert(R.mipmap.icon_default_head,"吴华兵","问题：6","单位：南京市农业技术推广站","地方专家","水稻",null);
        Home_Search_Expert h11 = new Home_Search_Expert(R.mipmap.icon_default_head,"吴向阳","问题：0","单位：昆山市农业技术推广中心","地方专家","植保",null);
        Home_Search_Expert h12 = new Home_Search_Expert(R.mipmap.icon_default_head,"李世兴","问题：1","单位：徐州市铜山区农委","地方专家","水稻",null);

        lt.add(h1);
        lt.add(h2);
        lt.add(h3);
        lt.add(h4);
        lt.add(h5);
        lt.add(h6);
        lt.add(h1);
        lt.add(h2);
        lt.add(h3);
        lt.add(h4);
        lt.add(h5);
        lt.add(h6);
        lt.add(h7);
        lt.add(h8);
        lt.add(h9);
        lt.add(h10);
        lt.add(h11);
        lt.add(h12);

        ap = new Home_Search_ExpertAdapter(lt, getActivity());
        lv.setAdapter(ap);


        return view;
    }

}
