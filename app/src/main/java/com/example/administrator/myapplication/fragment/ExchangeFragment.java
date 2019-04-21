package com.example.administrator.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.activity.EXPushActivity;
import com.example.administrator.myapplication.activity.Exchenge_DetailActivity;
import com.example.administrator.myapplication.activity.QuickQuestionSubmission;
import com.example.administrator.myapplication.adapter.Exchange_itemAdapter;
import com.example.administrator.myapplication.moduels.Exchange_item;
import com.example.administrator.myapplication.moduels.Knowledge;
import com.example.administrator.myapplication.utils.LocationUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeFragment extends Fragment {
    private List<Exchange_item> lists;
    private ListView listView;
    private Exchange_itemAdapter adapter;
    private TextView push;

    public ExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exchange, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        push =(TextView)view.findViewById(R.id.exchange_tv_push);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),EXPushActivity.class);
                startActivity(intent);
            }
        });




        listView = (ListView) view.findViewById(R.id.exchange_lv);
        lists = new ArrayList<>();
        Exchange_item h1 = new Exchange_item(R.mipmap.icon_default_head,"南京","bei","推广人员","zzzzz",R.mipmap.img4,R.mipmap.home_lv_iv2,R.mipmap.img3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h2 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.img3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h3 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h4 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.img3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h5 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h6 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h7 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h8 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h9 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h10 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);
        Exchange_item h11 = new Exchange_item(R.mipmap.icon_default_head, "阿狸","南京","推广人员","zzzzz",R.mipmap.home_lv_iv1,R.mipmap.home_lv_iv2,R.mipmap.home_lv_iv3,"2018-05-28",R.mipmap.icon_good,R.mipmap.icon_comment,null);


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


        adapter = new Exchange_itemAdapter(getActivity(), lists);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Exchenge_DetailActivity.class);
                startActivity(intent);
            }
        });
    }


}
