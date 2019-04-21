package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.SupplyInformationActivity;
import com.example.administrator.myapplication.activity.SupplyInformationBuyActivity;
import com.example.administrator.myapplication.activity.Supply_Inf_Buy_DetailActivity;
import com.example.administrator.myapplication.adapter.Supply_Information_BuyAdapter;
import com.example.administrator.myapplication.moduels.Supply_Information_Buy;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SupplyInfBuyFragment extends Fragment {
    private List<Supply_Information_Buy> lists;
    private ListView listView;
    private Supply_Information_BuyAdapter adapter;
    private FloatingActionButton tab;


    public SupplyInfBuyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supply_inf_buy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        com.melnykov.fab.FloatingActionButton fab = (com.melnykov.fab.FloatingActionButton)view.findViewById(R.id.buy_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),SupplyInformationBuyActivity.class);
                startActivity(intent);
            }
        });

        listView = (ListView) view.findViewById(R.id.buy_lv);
        lists = new ArrayList<>();
        Supply_Information_Buy h1 = new Supply_Information_Buy("种猪","120",null,"江苏省扬州市广陵区海沃路","2018-05-18");
        Supply_Information_Buy h2 = new Supply_Information_Buy( "需要龙虾","5000斤",null,"江苏省淮安市洪泽区民兵路","2018-05-17");
        Supply_Information_Buy h3 = new Supply_Information_Buy("手扶拖拉机","全常州产，外观要好，宽把，价格2000作业",null,"江苏省扬州市广陵区海沃路","2018-05-18");
        Supply_Information_Buy h4 = new Supply_Information_Buy("常规水稻机插秧秧苗","在睢宁有流转土地，需要常规水稻机插秧秧苗",null,"江苏省淮安市洪泽区民兵路","2018-05-17");
        Supply_Information_Buy h5 = new Supply_Information_Buy("水稻育秧无纺布","水稻育秧无纺布，厂家直销，13665273399","  已购买  ","江苏省扬州市广陵区海沃路","2018-05-18");
        Supply_Information_Buy h6 = new Supply_Information_Buy("圣稻19","最迟半个月","  已过期  ","江苏省淮安市洪泽区民兵路","2018-05-17");
        Supply_Information_Buy h7 = new Supply_Information_Buy("水稻育秧无纺布","防老化水稻育秧专用无纺布，李如山13665273399","  已过期  ","江苏省扬州市广陵区海沃路","2018-05-18");
        Supply_Information_Buy h8 = new Supply_Information_Buy("圣稻19","最迟半个月","  已过期  ","江苏省淮安市洪泽区民兵路","2018-05-17");
        Supply_Information_Buy h9 = new Supply_Information_Buy("水稻育秧无纺布","水稻育秧无纺布，厂家直销，13665273399","  已购买  ","江苏省扬州市广陵区海沃路","2018-05-18");
        Supply_Information_Buy h10 = new Supply_Information_Buy("圣稻19","最迟半个月","  已过期  ","江苏省淮安市洪泽区民兵路","2018-05-17");
        Supply_Information_Buy h11 = new Supply_Information_Buy("水稻育秧无纺布","防老化水稻育秧专用无纺布，李如山13665273399","  已过期  ","江苏省扬州市广陵区海沃路","2018-05-18");

        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        lists.add(h4);
        lists.add(h5);
        lists.add(h6);
        lists.add(h7);
        lists.add(h8);
        lists.add(h9);
        lists.add(h10);
        lists.add(h11);
        adapter = new Supply_Information_BuyAdapter(lists, getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Supply_Inf_Buy_DetailActivity.class);
                startActivity(intent);
            }
        });

    }


}

